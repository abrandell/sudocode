package org.sudocode.api.core.annotation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.AliasFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sudocode.api.core.AbstractEntity;

import java.awt.*;
import java.lang.annotation.*;

/**
 * Meta annotation for {@link GetMapping} that produces {@code MediaType.APPLICATION_JSON_VALUE}
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET)
@Documented
public @interface Get {

    @AliasFor(annotation = RequestMapping.class)
    String value() default "";

    @AliasFor(annotation = RequestMapping.class)
    String path() default "";

    @AliasFor(annotation = RequestMapping.class)
    String[] produces() default {MediaType.APPLICATION_JSON_VALUE};
}
