/**
 * 
 */
package com.welearn.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import com.welearn.util.InfoCode;

/**
 * @author Tracy
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authentication {

	public int role() default InfoCode.ROLE_STUDENT;
}
