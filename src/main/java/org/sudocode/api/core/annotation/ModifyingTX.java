package org.sudocode.api.core.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Meta-annotation for {@link Modifying} and {@link Transactional} that rolls back for any exception.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Modifying
@Transactional(readOnly = false, rollbackFor = Exception.class)
public @interface ModifyingTX {

    @AliasFor(annotation = Transactional.class)
    Propagation propagation() default Propagation.REQUIRED;
}
