package com.example.exam.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class Interceptor1 implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(Interceptor1.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        LOGGER.info("Interceptor1拦截器开始工作，拦截到当前请求地址：" + httpServletRequest.getRequestURL().toString());
        // 只有返回true才会继续向下执行，返回false取消当前请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
        HandlerMethod method = (HandlerMethod) o;
        System.out.println("-- MethodName:" + method.getMethod().getName());
        System.out.println("-- ReturnType:" + method.getMethod().getReturnType());
        System.out.println("-- MethodParameters:" + method.getMethodParameters());
        MethodParameter[] parameters = method.getMethodParameters();
        if (null != parameters) {
            for (MethodParameter parameter : parameters) {
                System.out.println("  -- parameterIndex:" + parameter.getParameterIndex() + ",parameterName:" + parameter.getParameterName() + ",parameterType:" + parameter.getParameterType());
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        // 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
        //        System.out.println("CustomInterceptor1.afterCompletion:" + o);
        LOGGER.info("afterCompletion清理资源...");
        // 清理session
    }
}
