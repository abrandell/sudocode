package org.sudocode.api.core;

import com.google.common.cache.LoadingCache;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith({MockitoExtension.class})
class TimeOutServiceTest {

    @Mock
    private LoadingCache<Long, LocalDateTime> loadingCache;

    @InjectMocks
    private TimeOutService timeOutService;

    @Test
    void Not30SecondsPassed_thenTimeOutTrue() throws ExecutionException {
        given(loadingCache.get(2L)).willReturn(LocalDateTime.now());
        assertTrue(timeOutService.isTimedOut(2L), "Should be timed out.");
    }

    @Test
    void enoughTimePassed_thenTimeOutFalse() throws Exception {
        given(loadingCache.get(1L)).willReturn(LocalDateTime.now().minusSeconds(50));
        assertFalse(timeOutService.isTimedOut(1L), "Should not be timed out since 30 seconds passed.");
    }

    @Test
    void notEnoughTimePassed_thenExceptionThrown() throws ExecutionException {
        given(loadingCache.get(1L)).willReturn(LocalDateTime.now());

        assertThrows(TooManyRequestException.class,
                () -> timeOutService.handleIfTimedOut(1L)
        );
    }

    @Test
    void enoughTimePassed_thenNoException() throws Exception {
        given(loadingCache.get(2L)).willReturn(LocalDateTime.now().minusSeconds(35));

        timeOutService.handleIfTimedOut(2L);

    }

    @Test
    void passedEnoughTime_thenNotSpamming() throws ExecutionException {
        timeOutService.ensureNotSpamming(1L, LocalDateTime.now().minusSeconds(35));

        assertFalse(timeOutService.isTimedOut(1L));
    }

    @Test
    void notEnoughTimePassed_thenSpamming() throws ExecutionException {
        given(loadingCache.get(1L)).willReturn(LocalDateTime.now());
        assertAll("not enough time passed",
                () -> assertThrows(TooManyRequestException.class,
                        () -> timeOutService.ensureNotSpamming(1L, LocalDateTime.now())
                ),
                () -> assertTrue(timeOutService.isTimedOut(1L)));
    }
}