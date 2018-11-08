package org.sudocode.api.core.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * Meta annotation for {@link Transactional} and @{@link Service} that rolls back for any
 * exception.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
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
