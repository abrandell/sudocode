package org.sudocode.api.core.security.timeout;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.sudocode.api.core.exception.TooManyRequestException;
import org.sudocode.api.post.PostingService;
import org.sudocode.api.post.comment.Comment;
import org.sudocode.api.post.project.Project;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static org.sudocode.api.core.Constants.LOCAL_DATE_TIME_MIN;

/**
 * Service for timing out users for spamming and/or posting too often.
 */
@Service
class TimeOutService {

    private final Logger LOG = LoggerFactory.getLogger(TimeOutService.class);

    private final PostingService postingService;

    @Autowired
    public TimeOutService(PostingService postingService) {
        this.postingService = postingService;
    }

    void handleTimeOut(Long userId) {
        if (isTimedOut(userId)) {
            LOG.info("Timed out User: {} attempted to make a post.", userId);
            throw new TooManyRequestException(userId);
        }
        LocalDateTime lastDatePosted = lastPostDateByUser(userId);
        long secPassed = Duration.between(lastDatePosted, LocalDateTime.now()).toSeconds();
        LOG.info("User: {} waited {} seconds before attempting to post again.", userId, secPassed);
        if (secPassed < 5) {
            timeOutUser(userId);
            throw new TooManyRequestException(userId);
        }
    }

    private void timeOutUser(Long id) {
        var currentTime = LocalDateTime.now();
        LOG.warn("Too many requests. Timing out user with ID {}.", id);
        loadingCache().put(id, currentTime);
    }

    private boolean isTimedOut(Long id) {
        LocalDateTime lastPosted = loadingCache().getUnchecked(id);

        return Duration.between(lastPosted, LocalDateTime.now()).toSeconds() <= 10;
    }

    /**
     * Searches for the latest post date for both comments and projects made by a user.
     * <p>
     * If none were made, it'll set them to {@link LocalDateTime#MIN}.
     *
     * @param id ID of the user
     * @return The latest post date between the two.
     */
    private LocalDateTime lastPostDateByUser(Long id) {

        // To not make more queries than needed.
        if (!isTimedOut(id)) {
            return postingService.fetchLatestPostDateByAuthorId(id);
        }

        return LOCAL_DATE_TIME_MIN;
    }

    /**
     * LoadingCache that fetches the last {@link LocalDateTime} of the most recent post a
     * user made with given ID.<br>
     * Returns the most recent date between both the latest {@link Project} and
     * {@link Comment} made.<br>
     * <p>
     * This is mainly to check if a user is spamming/posting too often.
     *
     * @return LoadingCache that fetches both dates (if they exist) for the last
     * {@link Project} and {@link Comment} posted. The load function returns the latest.
     * @see LoadingCache
     * @see PostingService#fetchLatestPostDateByAuthorId(Long)
     */
    private LoadingCache<Long, LocalDateTime> loadingCache() {
        return CacheBuilder.newBuilder()
                           .expireAfterWrite(6, TimeUnit.MINUTES)
                           .maximumSize(100)
                           .build(new CacheLoader<>() {
                               @Override
                               public LocalDateTime load(@NonNull Long userId) {
                                   return postingService.fetchLatestPostDateByAuthorId(userId);
                               }
                           });
    }

}
