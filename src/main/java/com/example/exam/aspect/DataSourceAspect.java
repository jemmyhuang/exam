package com.example.exam.aspect;


import com.example.exam.MutiDataSourceConfig.DataSourceRouteHolder;
import com.example.exam.annotation.MutiDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class DataSourceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);

    private final String[] QUERY_PREFIX = {"select"};

    @Pointcut("execution(* com.example.exam.dao.*.*(..))")
    public void pointcut() {
    }

//    @Before("pointcut()")
//    public void doBefore(JoinPoint joinPoint) {
//        LOGGER.info("进入switchDataSource方法。。。");
//        Boolean queryMethod = isQueryMethod(joinPoint.getSignature().getName());
//        if (queryMethod) {
//            DataSourceRouteHolder.useSlaveDataSource();
//        }
//    }

    @Before("pointcut()")
    public void before(JoinPoint point){
        LOGGER.info("进入switchDataSource方法。。。");
        MutiDataSource annotation = getAnnotation(point, MutiDataSource.class);
        String db_key = annotation.name().name();
        DataSourceRouteHolder.setDataSourceKey(db_key);
        LOGGER.info("set db as [{}]", db_key);
    }

    /**
     * 获得@DataSource注解的annotation，目的是获取属性value
     *
     * @return
     */
    private <T extends Annotation> T getAnnotation(JoinPoint jp, Class<T> clz) {
        MethodSignature sign = (MethodSignature) jp.getSignature();
        Method method = sign.getMethod();
        return method.getAnnotation(clz);
    }



    @After("pointcut()")
    public void doAfter(JoinPoint joinPoint) {
        DataSourceRouteHolder.clearDataSourceKey();
    }

    /**
     * Judge if method start with query prefix
     *
     * @param methodName
     * @return
     */
    private Boolean isQueryMethod(String methodName) {
        for (String prefix : QUERY_PREFIX) {
            if (methodName.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
