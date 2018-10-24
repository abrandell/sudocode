package org.sudocode.api.core;

import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sudocode.api.core.exceptions.TooManyRequestException;
import org.sudocode.api.project.ProjectService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

import static org.sudocode.api.core.util.Constants.DEFAULT_LOCAL_DATE_TIME;

/**
 * Service for timing out users for spamming and/or posting too often.
 */
@Service
@Transactional(readOnly = true)
public class TimeOutService {

    private final LoadingCache<Long, LocalDateTime> loadingCache;
    private final Logger LOG = LoggerFactory.getLogger(TimeOutService.class);
    private final ProjectService projectService;

    @Autowired
    public TimeOutService(LoadingCache<Long, LocalDateTime> loadingCache, ProjectService projectService) {
        this.loadingCache = loadingCache;
        this.projectService = projectService;
    }

    public void handleTimeOut(Long userId) throws ExecutionException {
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
        loadingCache.put(id, currentTime);
    }

    private boolean isTimedOut(Long id) throws ExecutionException {
        LocalDateTime lastPosted = loadingCache.get(id);

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
    protected LocalDateTime lastPostDateByUser(Long id) throws ExecutionException {

        // To not make more queries than needed.
        if (!isTimedOut(id)) {
            return projectService.fetchLatestPostDateByAuthorId(id);
        }

        return DEFAULT_LOCAL_DATE_TIME;
    }
}



