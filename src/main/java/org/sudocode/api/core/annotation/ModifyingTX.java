package org.sudocode.api.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Meta-annotation for {@link Modifying} and {@link Transactional} that rolls back for any exception.
 */
@Deprecated
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Modifying
@Transactional(readOnly = false, rollbackFor = Exception.class)
public @interface ModifyingTX {

	@AliasFor(annotation = Transactional.class)
	Propagation propagation() default Propagation.REQUIRED;
}
