package org.sudocode.api.core.security;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SanitizeInputServiceTest {

    private SanitizeInputService sanitizeService = new SanitizeInputService();

    @Test
    void sanitizeInput() {
        String unsafe = "<p><a href='http://example.com/' onclick='stealCookies()'>Link</a></p>";

        String result = SanitizeInputService.sanitizeInput(unsafe);

        assertEquals("<p><a href=\"http://example.com/\" rel=\"nofollow\">Link</a></p>", result);
    }

    @Test
    void escape() {
        String nonEntityCode = "<b>ayo</b>";

        var result = sanitizeService.escape(nonEntityCode);

        assertEquals("&lt;b&gt;ayo&lt;/b&gt;", result);
    }



}