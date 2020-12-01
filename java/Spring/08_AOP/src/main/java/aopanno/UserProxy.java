package aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 增强类
@Component
@Aspect
@Order(1)
public class UserProxy {

    // 相同切入点抽取
    @Pointcut(value = "execution(* aopanno.User.add(..))")
    public void point() {

    }

    // 前置通知
    // @before注解表示作为前置通知
    @Before(value = "point()")
    public void before() {
        System.out.println("before....");
    }

    // 最终通知，有没有异常都会执行
    @After(value = "point()")
    public void after() {
        System.out.println("after...");
    }

    // 方法返回之后执行
    @AfterReturning(value = "point()")
    public void afterReturn() {
        System.out.println("AfterReturning...");
    }

    // 异常通知
    @AfterThrowing(value = "point()")
    public void afterThrowing() {
        System.out.println("AfterThrowing...");
    }

    // 环绕通知
    @Around(value = "point()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前...");

        // 被增强的方法执行
        proceedingJoinPoint.proceed();

        System.out.println("环绕之后...");
    }
}
