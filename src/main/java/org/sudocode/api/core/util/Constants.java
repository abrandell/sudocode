package org.sudocode.api.core.util;

import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Constants {

    /**
     * Shorter constant for {@link MediaType#APPLICATION_JSON_VALUE}
     */
    public static final String JSON = MediaType.APPLICATION_JSON_VALUE;

    /**
     * Regex string for valid urls.
     */
    public static final String URL_REGEX =
            "https?://(www\\.)?[-a-zA-Z0-9@:%._+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_+.~#?&/=]*)";

    /**
     * Regex pattern for valid url's.
     */
    public static final Pattern URL_REGEX_PATTERN = Pattern.compile(URL_REGEX);

    public static final LocalDateTime DEFAULT_LOCAL_DATE_TIME = LocalDateTime.MIN;
}
