package com.play_v1.log;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
/**
 * This is an annotation interface used for logging
 * DearmIt
 * @author maher
 *
 */
@Qualifier
@Retention(RUNTIME)
@Target({ FIELD, TYPE, METHOD })
public @interface Log {

}