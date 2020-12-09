# SpringMVC

[TOC]

## 1. 概述

### 1.1 什么是SpringMVC

`SpringMVC`是`Spring Framework`的一部分，是基于`java`实现的MVC的轻量级`Web`框架

特点

1. 轻量级，简单易学
2. 高效，基于请求和响应的`MVC`框架
3. 与`Spring`兼容性好，无缝结合
4. 约定优于配置
5. 功能强大：`RESTFUL`、数据验证、格式化、本地化、主题等
6. 简洁灵活

### 1.2 中心控制器

- `Spring`的`web`框架围绕`DispatcherServlet`调度`Servelt`设计

- `DispatcherServlet`的作用域是将请求分发到不同的处理器，`Spring2.5`开始，使用`Java5`或者以上的版本的用户可以采用基于注解的`controller`声明方式

- `Spring MVC`框架像许多其他`MVC`框架一样，以请求为驱动，围绕一个中心`Servlet`分派请求及提供其他功能，`DispatcherServlet`是一个实际的`Servelt`(它继承自`HttpServlet`基类)

