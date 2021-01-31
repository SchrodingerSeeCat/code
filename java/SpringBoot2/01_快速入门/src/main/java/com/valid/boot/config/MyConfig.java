package com.valid.boot.config;

import com.valid.boot.bean.Car;
import com.valid.boot.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*
* 1. 配置类里面使用@Bean标注在方法上给容器注册组件，默认是单实例
* 2. 配置类本身也是组件
* 3. proxyBeanMethods: 代理bean的方法，如果为true，则获得MyConfig的实例之后调用本身的方法，返回的对象永远都是相同的。如果为false则不同，默认为true
* 4. @Import() 参数为一个数组，会创建数组中的组件(调用无参构造)
* 5. @ImportResource("classpath:beans.xml") 导入beans.xml文件中的组件
* */

//@ImportResource("classpath:beans.xml")
@Import({User.class, String.class})
@Configuration(proxyBeanMethods = true) // 告诉SpringBoot这是一个配置类
//@EnableConfigurationProperties(Car.class) // 启用Car的属性绑定
public class MyConfig {

    @Bean  //在容器中添加组件，以方法名作为组件的id。返回类型就是组件类型。返回的值就是组件在容器中的实例
    public User user() {
        return new User("张三", 18);
    }
}
