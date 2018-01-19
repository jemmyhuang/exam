//package com.example.exam.aspect;
//
//import com.example.exam.MutiDataSourceConfig.DataSourceRouteHolder;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
///**
// * Multiple DataSource Aspect
// *
// * @author HelloWood
// * @date 2017-08-15 11:37
// * @email hellowoodes@gmail.com
// */
//@Aspect
//@Component
//public class DynamicDataSourceAspect {
//    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);
//
//    private final String[] QUERY_PREFIX = {"select"};
//
//    /**
//     * Dao aspect.
//     */
//    @Pointcut("execution( * com.example.exam.dao.*.*(..))")
//    public void daoAspect() {
//    }
//
//    /**
//     * Switch DataSource
//     *
//     * @param point the point
//     */
//    @Before("daoAspect()")
//    public void switchDataSource(JoinPoint point) {
//        logger.info("进入switchDataSource方法。。。");
//        Boolean isQueryMethod = isQueryMethod(point.getSignature().getName());
//        if (isQueryMethod) {
//            DataSourceRouteHolder.useSlaveDataSource();
//            logger.debug("Switch DataSource to [{}] in Method [{}]",
//                    DataSourceRouteHolder.getDataSourceKey(), point.getSignature());
//        }
//    }
//
//    /**
//     * Restore DataSource
//     *
//     * @param point the point
//     */
//    @After("daoAspect())")
//    public void restoreDataSource(JoinPoint point) {
//        DataSourceRouteHolder.clearDataSourceKey();
//        logger.debug("Restore DataSource to [{}] in Method [{}]",
//                DataSourceRouteHolder.getDataSourceKey(), point.getSignature());
//    }
//
//
//    /**
//     * Judge if method start with query prefix
//     *
//     * @param methodName
//     * @return
//     */
//    private Boolean isQueryMethod(String methodName) {
//        for (String prefix : QUERY_PREFIX) {
//            if (methodName.startsWith(prefix)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//}
