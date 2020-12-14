# Spring Boot

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

2. `pom`文件中引入启动器

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

   

