package com.example.exam.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

@Component
@Aspect
@Order(-5)
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    @Pointcut("execution(* com.example.exam.controller.*.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public  void before(JoinPoint joinPoint) {
        threadLocal.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录请求的内容
        LOGGER.info("Request URL: {}", request.getRequestURL().toString());
        LOGGER.info("Request Method: {}", request.getMethod());
        LOGGER.info("IP: {}", request.getRemoteAddr());
        LOGGER.info("User-Agent:{}", request.getHeader("User-Agent"));
        LOGGER.info("Class Method:{}", joinPoint.getSignature().getDeclaringTypeName() + "."  + joinPoint.getSignature().getName());
        LOGGER.info("Cookies:{}", request.getCookies());
        LOGGER.info("Params:{}", Arrays.toString(joinPoint.getArgs()));
        Enumeration<String> enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String paraName = enums.nextElement();
            LOGGER.info(paraName + ":" + request.getParameter(paraName));
        }
    }

    @After("pointcut()")
    public void doAfter(JoinPoint joinPoint) {
        LOGGER.info("doAfter():{}", joinPoint.toString());
    }

    @AfterReturning("pointcut()")
    public void doAfterReturning(JoinPoint joinPoint) {
        LOGGER.info("耗时 :{}", ((System.currentTimeMillis() - threadLocal.get())) + "ms");
    }

}
