# SpringBoot

[TOC]

## 1. Spring Boot基础

### 1.1 SpringBoot 简介

`SpringBoot`是所有基于`Spring`开发的项目的起点。`SpringBoot`起始不是什么新的框架，它默认配置了很多框架的使用方式，就像`maven`整合了所有的`jar`包，`Spring Boot`整合了很多的技术，提供了`javaEE`的大整合

#### 1.1.1 SpringBoot的主要特性

1. `SpringBoot Starter`：它将常用的依赖分组进行了整合，将其合并到一个依赖中，这样就可以一次性添加到项目的`maven`或`Gradle`构建中
2. 使编码变的简单，`SpringBoot`采用了`JavaConfig`的方式对`Spring`进行配置，并且提供了大量的注解，极大的提高了工作效率
3. 自动配置：`SpringBoot`的自动配置特性利用了`Spring`对条件化配置的支持。合理地推测应用所需的`bean`并自动化品类之他们
4. 使得部署变的简单，`SpringBoot`内置类三种`Servlet`容器，`Tomcat`，`Jetty`，`Undertow`我们只需一个`Java`的运行环境就可以跑`SpringBoot`的项目了，`SpringBoot`的项目可以打成一个`jar`包
5. 现在流行微服务与分布式系统，`SpringBoot`就是一个非常好的微服务开发框架，你可以使用它快速的搭建起一个系统。同时，你也可以使用`Spring Clound`来搭建一个分布式的架构

#### 1.1.2 SpringBoot缺点

1. 将现有或传统的`Spring Framework`项目转换为`Spring Boot`应用程序是一个非常困难和耗时的过程。它仅适用于全新的`Spring`项目。
2. 使用简单，学习成本高，精通难

### 1.2 快速入门

#### 1.2.1 HelloWorld

1. 创建父工程

2. `pom`文件中引入启动器`starter`

   ```xml
   <parent>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-parent</artifactId>
       <version>2.4.1</version>
   </parent>
   ```

3. 引入`web`依赖

   ```xml
   <dependencies>
       <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-web</artifactId>
       </dependency>
   </dependencies>
   ```

4. 新建子项目，编写`Controller`

   ```java
   @RestController
   public class TestController {
       @RequestMapping("hello")
       public String hello() {
           return "Hello World";
       }
   }
   ```

5. 编写启动类

   ```java
   @SpringBootApplication // Spring的启动类
   public class FirstSpringApplication {
       public static void main(String[] args) {
           SpringApplication.run(FirstSpringApplication.class, args);
       }
   }
   ```

6. 测试

   ```
   http://localhost:8080/hello
   ```

#### 1.2.2 程序打包

1. 父工程的`pom`中导入插件

   ```xml
   <build>
       <plugins>
           <plugin>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-maven-plugin</artifactId>
           </plugin>
       </plugins>
   </build>
   ```

   如果报错需要加入`version`标签
   
2. 执行编译命令

   ```bash
   mvn -f 01_HelloWorld clean package
   ```

### 1.3 其他问题

#### 1.3.1 默认扫描器basepackage

`SpringBoot`的主启动类所在的`package`就是扫描器的`basepackage`

#### 1.3.2 开启热部署

1. `pom`文件中加入依赖

   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-devtools</artifactId>
       <optional>true</optional>
   </dependency>
   ```

2. `settings`->`compiler`->勾选`Build project automatically`

3. `Ctrl`+`Shift`+`Alt`+`/` --> `Registry`-->勾选`compiler.automake.allow.when.app.running`

忽略某些文件或文件夹热部署，新建`application.properties`

```
spring.devtools.restart.exclude=static/**,public/**
```

表示`static`和`public`文件夹下的所有的文件都被忽略

## 2. SpringBoot配置文件

### 2.1 配置文件的位置

`SpringBoot`启动时会扫描以下位置的`application.properties`或者`application.yml`文件作为`SpringBoot`的默认配置文件

- `file`：`/config/`
- `file`：`/`   表示项目的根目录，如果当前项目有父工程，配置文件要放在父工程的根路径
- `classpath`：`/config/`
- `classpath`：`/`

优先级由低到高，高优先级的配置会覆盖低优先级的配置

`SpringBoot`会从这四个位置全部加载主配置文件；互补配置

如果我们的配置文件的名字不是`application.properties`或者`application.yml`，可以通过以下参数来指定配置文件的名字，`myproject`是配置文件名

```bash
java -jar myproject.jar --spring.config.name=myproject
```

也可以指定其他位置的配置文件来生效

```bash
java -jar --spring.config.location=C:/myproject.properties
```

### 2.2 yml的配置文件

#### 2.2.1 yaml概述

`yml`是`YAML`(`YAML Ain't Markup Language`)语言的文件，以数据为中心，比`properties`、`xml`等更适合做配置文件

- `yml`和`xml`相比，少了一些结构化的代码，使数据更直接，一目了然
- 相比`properties`文件更简洁

#### 2.2.2 yaml语法

以空格的缩进程度来控制层级关系。空格的个数不重要，只要左边空格对齐则视为同一个层级。且大小写敏感。支持字面量值，对象，数组三种数据结构，也支持复合结构

- 字面值：字符串、布尔类型、数值、日期。字符串默认不加引号，单引号会转义特殊字符。日期格式支持`yyyy/MM/dd HH:mm:ss`，双引号会保持转义字符的含义
- 对象：由键值对组成，形如`key: value`的数据组成。冒号后面的空格是必须要有的，每组键值对占一行，且缩进的程度要一致，也可以使用行内写法：`{k1: v1, ..., kn: vn}`
- 数组：由形如`- value`的数据组成。短横线后面的空格是必须要有的，每组数据占用一行，且缩进的程度要一致，以可以使用行内写法：`[1, 2, ..., n]`
- 复合结构：上面三种数据结构任意组合

1. 准备实体类`YamlModel.java`

   ```java
   @Component
   @ConfigurationProperties(prefix = "yaml")
   public class YamlModel {
       private String str;
       private int num;
       private double Dnum;
       private Date birth;
       private List<String> list = new ArrayList<>();
       private List<User> users = new ArrayList<>();
       private Map<String, String> map = new HashMap<>();
       
       // get set toString
   }
   ```

   `@ConfigurationProperties`用于指定`yaml`的前缀，多层级需要用`.`指定 `yaml.level`

2. 编写`application.xml`

   ```yml
   yaml:
     str: 字符串不需要加双引号
     num: 666
     Doum: 666.88
     birth: 2000/12/10 12:23:34
     list:
       - one
       - two
       - three
     users:
       - name: 张三
         salary: 123.8
       - name: 李四
         salary: 456.3
     map: {key1: value1, key2: value2}
   ```

3. `controller`

   ```java
   @RestController
   public class YamlController {
   
       @Autowired
       private YamlModel yamlModel;
   
       @RequestMapping("yaml")
       public String hello() {
           return  yamlModel.toString();
       }
   }
   ```

4. 测试访问

   ```java
   YamlModel{str='字符串不需要加双引号', num=666, Dnum=0.0, birth=Sun Dec 10 12:23:34 CST 2000, list=[one, two, three], users=[User{name='张三', salary=123.8}, User{name='李四', salary=456.3}], map={key1=value1, key2=value2}}
   ```

### 2.3 属性绑定

1. 创建实体类

   ```java
   @Data
   @Component
   @ConfigurationProperties("acme")
   public class AcmeProperties {
       private boolean enabled;
       private InetAddress remoteAddress;
       private final Security security = new Security();
   
       public boolean isEnabled() {
           return enabled;
       }
   
       public static class Security {
           private String username;
           private String password;
           private List<String> roles = new ArrayList<>(Collections.singleton("USER"));
       }
   }
   ```

2. 添加依赖

   能让当前的实体类能在配置文件中有对应的提示

   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-configuration-processor</artifactId>
       <optional>true</optional>
   </dependency>
   ```

3. 编写`application.yml`

   ```yml
   acme:
     enabled: true
     remote-address: 192.168.0.108 # - 对应驼峰命名法
     security:
       username: txjava
       password: 123
       roles:
         - 男主角
         - 摄影师
   ```

4. 编写`controller`

   ```java
   @RestController
   public class YamlController {
   
       @Autowired
       private AcmeProperties acme;
   
       @RequestMapping("test")
       public AcmeProperties test() {
           return acme;
       }
   }
   ```

5. 启动测试

### 2.4 构造器绑定

1. 准备实体类

   ```java
   @Data
   @ConfigurationProperties("acme")
   @ConstructorBinding
   public class AcmeProperties {
       private boolean enabled;
       private InetAddress remoteAddress;
       private Security security;
   
       public AcmeProperties(boolean enabled, InetAddress remoteAddress, Security security) {
           this.enabled = enabled;
           this.remoteAddress = remoteAddress;
           this.security = security;
       }
   
       @Data
       public static class Security {
           private String username;
           private String password;
           private List<String> roles = new ArrayList<>(Collections.singleton("USER"));
   
           public Security(String username, String password, @DefaultValue("USER") List<String> roles) {
               this.username = username;
               this.password = password;
               this.roles = roles;
           }
       }
   }
   ```

2. `application.yml`的内容与上述相同

3. `Controller`：开启属性类的构造器绑定

   ```java
   @RestController
   @EnableConfigurationProperties(AcmeProperties.class)
   public class YamlController {
   
       @Autowired
       private AcmeProperties acme;
   
       @RequestMapping("test")
       public AcmeProperties test() {
           return acme;
       }
   }
   ```

使用构造器函数绑定，必须使用`@EnableConfigurationProperties`或配置属性扫描启用类。不能对常规`Spring`机制创建的`Bean`使用构造函数绑定（例如`@Component Bean`、通过`@Bean`方法创建的`Bean`或使用`@Import`加载的`Bean`）

如果一配置类只配置`@ConfigurationProperties`注解，而没有使用`@Component`，那么在`IOC`容器中是获取不到`properties`配置文件转化的`bean`，`@EnableConfigurationProperties`相当于把使用`@ConfigurationProperties`的类进行了启用注入

在`SpringBoot2.2.1`之前的版本我们都是使用`@Configuration`来进行作为配置类，`2.2.1`之后不需要添加`@Configuration`，可以在主启动类的包扫描范围之内定义`bean`实例

### 2.5 第三方组件注入

除了使用`@ConfigurationProperties`注释类之外，还可以在`public@Bean`方法使用它。如果要讲属性绑定到不在你控制范围内的第三方组件

依然采用之前的案例的`yaml`配置

1. 创建一个组件类

   ```java
   @Data
   public class AnotherComponent {
       private boolean enabled;
       private InetAddress remoteAddress;
   }
   ```

2. 新建`MyService.class`

   ```java
   @Service
   public class MyService {
   
       @Bean
       @ConfigurationProperties("acme")
       public AnotherComponent getAnotherComponent() {
           return new AnotherComponent();
       }
   }
   ```

3. 控制器

   ```java
   @Autowired
   private AnotherComponent anotherComponent;
   
   @RequestMapping("/another")
   public AnotherComponent another() {
   	return anotherComponent;
   }
   ```

4. 测试访问

### 2.6 松散绑定

`SpringBoot`使用一些宽松的规则将环境绑定到`@ConfigurationProperties bean`，因此环境属性名和`bean`属性之间不需要完全匹配

1. 新建`model`

   ```java
   @Data
   @ConfigurationProperties("acme.my-person.person")
   @Component
   public class OwnerProperties {
       private String firstName;
   }
   ```

2. `application.yml`

   ```yml
   acme:
     my-person:
       person:
         first-name: 张
   ```

3. 控制器

   ```java
   @Autowired
   private OwnerProperties ownerProperties;
   
   @RequestMapping("owner")
   public OwnerProperties owner() {
   	return ownerProperties;
   }
   ```

| 属性文件中配置                    | 说明                                     |
| --------------------------------- | ---------------------------------------- |
| acme.my-project.person.first-name | 羊肉串模式case，推荐使用                 |
| acme.myProject.person.firstName   | 标准驼峰模式                             |
| acme.my_project.person.first_name | 下划线模式                               |
| ACME_MYPROJECT_PERSON_FIRSTNAME   | 大写下划线，如果使用系统环境时候推荐使用 |

属性类的声明中前缀不能是驼峰模式，在`yml`配置文件中可以

### 2.7 校验

每当使用`Spring`的`@Validated`注释对`@ConfigurationProperties`类进行注释时，`Spring Boot`就会尝试验证它们。你可以使用`JSR-303 javax.validation`直接在配置类上的约束注释。为此，请确保类路径上有一个兼容的`JSR-303 javax.validation`直接在配置类上的约束注释。为此，请确保类路径上有一个兼容的`JSR-303`实现，为此我们的是`hibernate`的实现，然后将约束注释添加到字段中

1. 引入依赖

   ```xml
   <dependency>
       <groupId>org.hibernate.validator</groupId>
       <artifactId>hibernate-validator</artifactId>
       <version>6.1.6.Final</version>
   </dependency>
   ```

2. 在属性类上加入注解

   ```java
   public class Person {
       // 普通属性校验
   
       @NotNull
       private String firstName;
       @Max(18)
       private int age;
       @Email
    private String email;
   
       // 内部类校验
       @Valid
       private School school = new School();
   
       @Data
       class School{
           @NotNull
           private String sname;
       }
   }
   ```
   
3. `application.yml`

   ```xml
   person:
     first-name: 张
     age: 18
     email: xxxxx
   ```

4. `controller`

   ```java
   @Autowired
   Person person;
   
   @RequestMapping("yaml")
   public Person yaml() {
   	return person;
   }
   ```

5. 启动测试

内部类的校验，需要在内部类的实例上添加`@Valid`

### 2.8 @Value

`@Vlaue`与`@ConfigurationProperties`功能相似

绑定的类型

| Feature      | @ConfigurationProperties | @Value |
| ------------ | ------------------------ | ------ |
| 松散绑定     | Yes                      | Limit  |
| 元数据支持   | Yes                      | No     |
| SpEl表达式   | No                       | Yes    |
| 复杂类型绑定 | Yes                      | No     |

`@Value`仅仅支持绑定单个数据

```java
@Data
@Component
public class ValueProperties {

    @Value("${person.first-name}")
    private String firstName;
    private int age;

    private String email;
}
```

`SpEl`表达式

```java
@Value("#{2 * 3}")
private int age;
```

`@Value`不支持校验

### 2.9 多profile

#### 2.9.1 通过---分割环境

`application.yml`可以指定多种环境以`---`分割，

```yml
acme:
  enable: true
  remote-address: 192.168.0.108
spring:
  profiles:
    active: dev
---
acme:
  enable: true
  remote-address: 192.168.0.109
spring:
  config:
    activate:
      on-profile: dev
---
acme:
  enable: true
  remote-address: 192.168.0.110
spring:
  config:
    activate:
      on-profile: pro
```

可以在`yml`文件中通过`spring.profiles.active`指定环境，也可以通过启动参数指定，也可以通过启动参数覆盖环境的参数

```
-Dspring.profiles.active=dev -Dacme.enabled=false
```

#### 2.9.2 通过文件名称来分割环境

文件的名称需要为`application-环境名称.yml`

假设有

- `application-dev.yml`
- `application-pro.yml`

依然通过启动参数指定环境

```
-Dspring.profiles.active=pro
```

## 3. 自动装配

### 3.1 java中的spi

`SPI`的全名为`Service Provider Interface`大多数开发人员可能不熟悉，因为这个是针对厂商或者插件的。

简单的总结少`java SPI`机制的思想。我们系统里抽象的各个模块，往往有很多不同的实现方案。面向对象的设计里，我们一般推荐模块之间基于接口编程，模块之间不对实现类进行硬编码。一旦代码里涉及具体的实现类，就违反了可拔插的原则，如果需要替换一种实现，就需要修改代码。为了实现在模块装配的时候能不在程序里动态指明，这就需要一种服务发现机制

`java SPI`就是提供这样的一个机制：为某个接口寻找服务实现的机制，有点类似`IOC`的思想，就是将装配的控制权移到程序之外，在模块化设计中这个机制尤其重要

