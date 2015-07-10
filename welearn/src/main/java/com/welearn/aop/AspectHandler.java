/**
 * 
 */
package com.welearn.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.welearn.util.JsonUtil;
import com.welearn.view.View;


/**
 * @author Tracy
 *
 */
@Aspect
@Component
public class AspectHandler {

	/** 
     * 根据类和方法名得到方法 
     */
    public Method getMethodByClassAndName(Class c , String methodName){  
        Method[] methods = c.getDeclaredMethods();  
        for (Method method : methods) {  
            if(method.getName().equals(methodName)){  
                return method;  
            }
        }
        return null;
    }
    
    /**
     * 根据目标方法和注解类型  得到该目标方法的指定注解 
     * @param method
     * @param annoClass
     * @return
     */
    public Annotation getAnnotationByMethod(Method method , Class annoClass){  
        Annotation all[] = method.getAnnotations();
        for (Annotation annotation : all) {
            if (annotation.annotationType() == annoClass) {  
                return annotation;
            }
        }
        return null;
    }
	
	@Around("@annotation(com.welearn.aop.Authentication)")
	public Object loginVerifyAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
        String methodName = joinPoint.getSignature().getName();
        //joinPoint.getStaticPart();
        Object target = joinPoint.getTarget();
        Method method = this.getMethodByClassAndName(target.getClass(), methodName); //得到拦截的方法  
        Object[] args = joinPoint.getArgs();	//方法的参数
        getAnnotationByMethod(method,Authentication.class);
        HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        Parameter[] s = method.getParameters();
        for(Parameter t:s) {
        	System.out.println(t.getName());
        }
        
        Object o1 = method.getDefaultValue();
        Object o2 = method.getParameterAnnotations();
        
        return joinPoint.proceed();
        
//    	if(session.getAttribute("aid") != null) {	//当aid不为空的时候  视为已经登录
//            return joinPoint.proceed();
//    	} else {
//            Class returnType = method.getReturnType();//得到方法返回值类型  
//            if(returnType == String.class) { //如果返回值为String
//                return JsonUtil.getJsonLoginTimeOut();
//            } else if(returnType == View.class) {
//            	return new View("admin","admin","login","登录"); 
//            } else {  //当使用Ajax的时候 可能会出现这种情况  
//                
//            	throw new Exception("错误的返回类型，此注解适用的方法返回值需为View或者是String！");
//            }
//    	}
	}
	
	
	
}
