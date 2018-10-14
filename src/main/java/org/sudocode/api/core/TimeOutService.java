package org.sudocode.api.core;

import com.google.common.cache.LoadingCache;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@Service
public final class TimeOutService {

//    private final LoadingCache<Long, LocalDateTime> commentTimeOutCache;
//    private final LoadingCache<Long, LocalDateTime> projectTimeOutCache;

    private final ConcurrentMap<Long, LocalDateTime> timeOutMap = new ConcurrentHashMap<>();

//    public TimeOutService(LoadingCache<Long, LocalDateTime> commentTimeOutCache,
//                          LoadingCache<Long, LocalDateTime> projectTimeOutCache) {
//        this.commentTimeOutCache = commentTimeOutCache;
//        this.projectTimeOutCache = projectTimeOutCache;
//    }

    public void timeOutUser(Long id) {
        if (timeOutMap.containsKey(id)) {
            timeOutMap.replace(id, LocalDateTime.now());
        } else {
            timeOutMap.putIfAbsent(id, LocalDateTime.now());
        }
    }

    public boolean isUserTimedOut(Long id) {
        if (!timeOutMap.containsKey(id)) return false;

        long minPassed = Duration.between(timeOutMap.get(id), LocalDateTime.now()).toMinutes();

        if (minPassed >= 5) {
            timeOutMap.remove(id);
            return false;
        }

        return true;
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


}
