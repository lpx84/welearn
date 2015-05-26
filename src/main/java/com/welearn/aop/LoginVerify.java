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
public @interface LoginVerify {

	/**
	 * 进入系统的角色：默认是学生
	 * @return
	 */
	public int role() default InfoCode.ROLE_STUDENT;
}
