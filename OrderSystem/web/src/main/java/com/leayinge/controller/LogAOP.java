package com.leayinge.controller;

import com.github.pagehelper.PageInfo;
import com.leayinge.domain.Log;
import com.leayinge.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

@Component //是一个bean
@Aspect  //创建一个切面
public class LogAOP {

    @Autowired
    private LogService logService;
    @Autowired
    private HttpServletRequest request; //在web.xml配置了RequestContextListener监听器
    private Date visitTime;
    private Class clazz; //访问的类
    private Method method; //访问的方法

    @Before("execution(* com.leayinge.controller.*.*(..))") //拦截controller所有方法,主要获取开始时间、类、方法用了哪个
    public void doBeford(JoinPoint jp) throws NoSuchMethodException {  //jp主要用于反射追踪日志
        visitTime = new Date();  //前置一执行，当前时间就是访问时间
        clazz = jp.getTarget().getClass();  //getTarget是返回这个jp，getClass是返回类的哈希值,具体要访问的类
        String methodName = jp.getSignature().getName(); //获取方法的名称
        Object[] args = jp.getArgs();
        if (args.length == 0 || args == null) method = clazz.getMethod(methodName); //只能获取无参数方法
        else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) classArgs[i] = args[i].getClass();
            method = clazz.getMethod(methodName, classArgs);
        } //获取具体执行的方法

    }

    @After("execution(* com.leayinge.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        int time = (int) (new Date().getTime() - visitTime.getTime()); //获取访问时长

        String url = null;
        if (clazz != null && method != null && clazz != LogAOP.class) { //获取类和方法的注解值，拼在一起
            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (clazzAnnotation != null) {
                String[] clazzValue = clazzAnnotation.value();
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = clazzValue[0] + methodValue[0];
                }
            }

            String ip = request.getRemoteAddr(); //获取ip地址

            //从管理用户的security中拿到用户名，当前访问者
            SecurityContext securityContext = SecurityContextHolder.getContext();
            User user = (User) securityContext.getAuthentication().getPrincipal();
            String username = user.getUsername();

            Log log = new Log();
            log.setIp(ip);
            log.setExecutionTime(time);
            log.setUsername(username);
            log.setVisitTime(visitTime);
            log.setMethod("[类] " + clazz.getName() + "[方法] " + method.getName());
            log.setUrl(url);

            logService.addLog(log);
        }


    }


}
