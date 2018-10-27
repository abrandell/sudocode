package org.sudocode.api.core.security.timeout;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.core.exceptions.TooManyRequestException;
import org.sudocode.api.project.Project;
import org.sudocode.api.project.ProjectService;
import org.sudocode.api.project.comment.Comment;
import org.sudocode.api.user.User;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static org.sudocode.api.core.util.Constants.DEFAULT_LOCAL_DATE_TIME;

/**
 * Service for timing out users for spamming and/or posting too often.
 */
@Service
@Transactional(readOnly = true)
class TimeOutService {

    private final Logger LOG = LoggerFactory.getLogger(TimeOutService.class);
    private final ProjectService projectService;

    @Autowired
    public TimeOutService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public void handleTimeOut(Long userId) {
        if (isTimedOut(userId)) {
            LOG.info(String.format("Timed out User: %d attempted to make a post.", userId));
            throw new TooManyRequestException();
        }

        LocalDateTime lastDatePosted = lastPostDateByUser(userId);
        long secPassed = Duration.between(lastDatePosted, LocalDateTime.now()).toSeconds();
        LOG.info(String.format("User: %d waited %d seconds before attempting to post again.", userId, secPassed));

        if (secPassed < 10) {
            timeOutUser(userId);
            throw new TooManyRequestException();
        }
    }

    private void timeOutUser(Long id) {
        var currentTime = LocalDateTime.now();
        LOG.info("TOO MANY REQUESTS --- Timing out user with ID: " + id + " at " + currentTime);
        loadingCache().put(id, currentTime);
    }

    private boolean isTimedOut(Long id) {
        LocalDateTime lastPosted = loadingCache().getUnchecked(id);

        return Duration.between(lastPosted, LocalDateTime.now()).toSeconds() <= 30;
    }

    /**
     * Searches for the latest post date for both comments and projects made by a user.
     * <p>
     * If none were made, it'll set them to {@link LocalDateTime#MIN}.
     *
     * @param id ID of the user
     * @return The latest post date between the two.
     */
    protected LocalDateTime lastPostDateByUser(Long id) {

        // To not make more queries than needed.
        if (!isTimedOut(id)) {
            return projectService.fetchLatestPostDateByAuthorId(id);
        }

        return DEFAULT_LOCAL_DATE_TIME;
    }

    /**
     * LoadingCache that fetches the last {@link LocalDateTime} builder the most recent postProject a user made by their ID.<br>
     * Returns the most recent date between both the latest {@link Project} and {@link Comment} made.<br>
     * <p>
     * This is mainly to check if a user is spamming/posting too often.
     *
     * @return LoadingCache that fetches both dates (if they exist) for the last {@link Project} and {@link Comment} posted.
     *         The load function returns the latest.
     * @see LoadingCache
     * @see ProjectService#fetchLatestPostDateByAuthorId(Long)
     */
    @Bean
    public LoadingCache<Long, LocalDateTime> loadingCache() {
        return CacheBuilder.newBuilder()
                           .expireAfterWrite(6, TimeUnit.MINUTES)
                           .maximumSize(100)
                           .build(new CacheLoader<>() {
                               @Override
                               public LocalDateTime load(@NonNull Long userId) {
                                   return projectService.fetchLatestPostDateByAuthorId(userId);
                               }
                           });

    }


}


