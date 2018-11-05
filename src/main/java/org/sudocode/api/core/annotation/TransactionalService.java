package org.sudocode.api.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Meta annotation for {@link Transactional} and @{@link Service} that rolls back for any exception.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Service
@Transactional(rollbackFor = Exception.class)
public @interface TransactionalService {

	@AliasFor(annotation = Transactional.class)
	boolean readOnly() default false;

	@AliasFor(annotation = Transactional.class)
	Propagation propagation() default Propagation.REQUIRED;
}
