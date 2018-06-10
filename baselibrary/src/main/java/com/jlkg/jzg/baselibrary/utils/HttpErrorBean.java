package com.jlkg.jzg.baselibrary.utils;

/**
 * Created by zcs on 2018/3/7.
 *
 * @describe:
 */

public class HttpErrorBean {

    /**
     * status : 500
     * error : Internal Server Error
     * message : 登陆失败:用户名或密码错误
     * timeStamp : Wed Mar 07 12:09:07 CST 2018
     * trace : java.lang.RuntimeException: 登陆失败:用户名或密码错误
     * at com.orcbit.building.action.CompanyAction.signIn(CompanyAction.java:197)
     * at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     * at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
     * at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     * at java.lang.reflect.Method.invoke(Method.java:498)
     * at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:221)
     * at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:137)
     * at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:110)
     * at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:776)
     * at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:705)
     * at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:85)
     * at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:959)
     * at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:893)
     * at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:967)
     * at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:869)
     * at javax.servlet.http.HttpServlet.service(HttpServlet.java:648)
     * at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:843)
     * at javax.servlet.http.HttpServlet.service(HttpServlet.java:729)
     * at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:292)
     * at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207)
     * at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
     * at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240)
     * at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207)
     * at com.orcbit.core.CORSFilter.doFilter(CORSFilter.java:27)
     * at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240)
     * at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207)
     * at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:77)
     * at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
     * at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240)
     * at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207)
     * at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:85)
     * at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
     * at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240)
     * at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207)
     * at org.springframework.boot.context.web.ErrorPageFilter.doFilter(ErrorPageFilter.java:116)
     * at org.springframework.boot.context.web.ErrorPageFilter.access$000(ErrorPageFilter.java:60)
     * at org.springframework.boot.context.web.ErrorPageFilter$1.doFilterInternal(ErrorPageFilter.java:91)
     * at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
     * at org.springframework.boot.context.web.ErrorPageFilter.doFilter(ErrorPageFilter.java:109)
     * at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240)
     * at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207)
     * at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:212)
     * at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:94)
     * at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:504)
     * at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:141)
     * at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:79)
     * at org.apache.catalina.valves.AbstractAccessLogValve.invoke(AbstractAccessLogValve.java:620)
     * at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:88)
     * at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:502)
     * at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1104)
     * at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:684)
     * at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1519)
     * at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.run(NioEndpoint.java:1475)
     * at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
     * at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
     * at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
     * at java.lang.Thread.run(Thread.java:745)
     */

    private int status;
    private String error;
    private String message;
    private String timeStamp;
    private String trace;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }
}
