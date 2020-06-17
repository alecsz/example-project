package org.example.kvs.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
@Transactional(readOnly = true)
public @interface Query {

    @AliasFor(annotation = Service.class)
    String value() default  "";

}
