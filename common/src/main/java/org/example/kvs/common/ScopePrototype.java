package org.example.kvs.common;

import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Scope("prototype")
public @interface ScopePrototype {
}
