package aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class PersonProxy {
    @Before(value = "execution(* aopanno.User.add(..))")
    public void Before() {
        System.out.println("Person before...");
    }
}
