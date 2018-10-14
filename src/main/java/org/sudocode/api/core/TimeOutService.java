package org.sudocode.api.core;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class TimeOutService {

    private final ConcurrentMap<Long, LocalDateTime> timeOutMap = new ConcurrentHashMap<>();

    public void timeOutUser(Long userId) {
        timeOutMap.putIfAbsent(userId, LocalDateTime.now());
    }

    public boolean isTimedOut(Long userId) {
        if (!timeOutMap.containsKey(userId)) return false;

        long minPassed = Duration.between(timeOutMap.get(userId), LocalDateTime.now()).toMinutes();

        if (minPassed >= 5) {
            timeOutMap.remove(userId);
            return false;
        }

        return true;
    }

}
