package org.sudocode.api.core;

import com.google.common.cache.LoadingCache;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@Service
public class TimeOutService {

    private final LoadingCache<Long, LocalDateTime> cache;

    public TimeOutService(LoadingCache<Long, LocalDateTime> cache) {
        this.cache = cache;
    }

    public void timeOutUser(Long userId) {
        cache.put(userId, LocalDateTime.now());
    }

    public boolean isTimedOut(Long userId) throws ExecutionException {
        if (cache.get(userId) == null) return false;

        return Duration.between(cache.get(userId), LocalDateTime.now()).toMinutes() <= 5;
    }



}
