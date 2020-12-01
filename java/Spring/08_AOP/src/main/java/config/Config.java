package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value = {"aopanno"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {
}
