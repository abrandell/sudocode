package org.sudocode.api.core;

import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/**
 * Service for timing out users for spamming and/or posting too often.
 */
@Service
public final class TimeOutService {

    private final LoadingCache<Long, LocalDateTime> loadingCache;

    @Autowired
    public TimeOutService(LoadingCache<Long, LocalDateTime> loadingCache) {
        this.loadingCache = loadingCache;
    }

    public void timeOutUser(Long id) {
        loadingCache.put(id, LocalDateTime.now());
    }

    public boolean isTimedOut(Long id) throws ExecutionException {
        if (loadingCache.get(id) == null) {
            return false;
        }

        return Duration.between(loadingCache.get(id), LocalDateTime.now()).toMinutes() <= .5;

    }

    public void handleIfTimedOut(Long id) throws ExecutionException {
        if (isTimedOut(id)) {
            throw new TooManyRequestException();
        }
    }

    // TODO rename me. Checks last time posted and times out the user for 5 mins if it was under 30 sec ago.
    public void ensureNotSpamming(Long userId, @Nullable LocalDateTime lastPosted) {

        if (lastPosted != null) {
            var now = LocalDateTime.now();
            assert now.isAfter(lastPosted);

            long secPassed = Duration.between(lastPosted, now).toSeconds();

            if (secPassed < 30) {
                timeOutUser(userId);
                throw new TooManyRequestException();
            }

        }
    }
}
//
//    public void timeOutUserFromComments(Long userId) {
//        commentTimeOutCache.put(userId, LocalDateTime.now());
//    }
//
//    public boolean isTimedOutFromComments(Long userId) throws ExecutionException {
//        if (commentTimeOutCache.get(userId) == null) return false;
//
//        return Duration.between(commentTimeOutCache.get(userId), LocalDateTime.now()).toMinutes() <= 5;
//    }
//
//    public void timeOutFromProjects(Long userId) {
//        projectTimeOutCache.put(userId, LocalDateTime.now());
//    }
//
//    public boolean isTimedOutFromProjects(Long userId) throws ExecutionException {
//        if (projectTimeOutCache.get(userId) == null) return false;
//
//        return Duration.between(projectTimeOutCache.get(userId), LocalDateTime.now()).toMinutes() <= 5;
//    }


