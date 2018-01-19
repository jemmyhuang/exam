package com.example.exam.aspect;


import com.example.exam.annotation.BusinessAccess;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Order(-1)
public class BusinessAccessAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessAccessAspect.class);

    @Pointcut("execution(* com.example.exam.service..*.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void  doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        Signature signature = joinPoint.getSignature();
        MethodSignature mst=null;
        if (!(signature instanceof  MethodSignature)) {
            LOGGER.error("该注解只能用于方法");
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        mst = (MethodSignature) signature;
        Object target = joinPoint.getTarget();
        //获取拦截方法的参数
        Method currentMethod = target.getClass().getMethod(mst.getName(), mst.getParameterTypes());
        //获取操作业务的名称
        BusinessAccess annotation = currentMethod.getAnnotation(BusinessAccess.class);
        String bussinessName = annotation.value();
        LOGGER.info("进入{}方法...", bussinessName);
    }
}
