package aopanno;

import org.springframework.stereotype.Component;

// 被增强类
@Component
public class User {
    public void add() {
//        int i = 1 / 0;
        System.out.println("add....");
    }
}
