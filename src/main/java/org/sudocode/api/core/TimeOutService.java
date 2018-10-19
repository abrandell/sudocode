package org.sudocode.api.core;

import com.google.common.cache.LoadingCache;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

/**
 * Service for timing out users for spamming and/or posting too often.
 */
@Service
public class TimeOutService {

    private final LoadingCache<Long, LocalDateTime> loadingCache;
    private final Log LOG = LogFactory.getLog(TimeOutService.class);

    @Autowired
    public TimeOutService(LoadingCache<Long, LocalDateTime> loadingCache) {
        this.loadingCache = loadingCache;
    }

    public void timeOutUser(Long id) {
        var currentTime = LocalDateTime.now();
        LOG.info("TOO MANY REQUESTS --- Timing out user with ID: " + id + " at " + currentTime);
        loadingCache.put(id, currentTime);
    }

    public boolean isTimedOut(Long id) throws ExecutionException {
        LocalDateTime lastPosted = loadingCache.get(id);
        if (lastPosted == null) {
            return false;
        }
        return Duration.between(lastPosted, LocalDateTime.now()).toSeconds() <= 30;
    }

    /**
     * @param id of the user to check if timed out. Throws a {@link TooManyRequestException} if true.
     */
    public void handleIfTimedOut(Long id) throws ExecutionException {
        if (isTimedOut(id)) {
            LOG.info(String.format("Timed out User: %d attempted to make a post.", id));
            throw new TooManyRequestException();
        }
    }

    // TODO rename me. Checks last time posted and times out the user for 5 mins if it was under 30 sec ago.
    public void ensureNotSpamming(Long userId, @Nullable LocalDateTime lastPostDate) throws ExecutionException {

        if (lastPostDate != null) {
            long secPassed = Duration.between(lastPostDate, LocalDateTime.now()).toSeconds();
            LOG.info(String.format("User: %d waited %d seconds before attempting to post again.", userId, secPassed));

            if (secPassed < 10) {
                timeOutUser(userId);
                throw new TooManyRequestException();
            }

        }
    }
}



