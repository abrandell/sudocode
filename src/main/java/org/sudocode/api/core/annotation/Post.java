package org.sudocode.api.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Meta annotation for {@link PostMapping} that produces & consumes {@code MediaType.APPLICATION_JSON_VALUE}
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.POST)
@Documented
public @interface Post {

	@AliasFor(annotation = RequestMapping.class)
	String value() default "";

	@AliasFor(annotation = RequestMapping.class)
	String path() default "";

	@AliasFor(annotation = RequestMapping.class)
	String[] produces() default { MediaType.APPLICATION_JSON_VALUE };

	@AliasFor(annotation = RequestMapping.class)
	String[] consumes() default { MediaType.APPLICATION_JSON_VALUE };
}
