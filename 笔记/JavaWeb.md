# JavaWeb

[TOC]

## 1. 基本概念

### 1.1 前言

web开发：

- `web`，网页的意思

- 静态`web`

  `html`、`css`

  提供给所有人看的数据始终不会发生变化

- 动态`web`

  提供给所有人看的数据始终会发生变化，每个人在不同的时间，不同的地点看到的信息各不相同

  技术栈：`Servlet/JSP`、`ASP`、`PHP`

- 在`java`中。动态`web`资源开发的技术统称为`javaweb`

### 1.2 web应用程序

`web`应用程序：可以提供浏览器访问的程序

- `a.html`、`b.html`....多个`web`资源，这些`web`资源可以被外界访问，对外界提供服务

- 我们能够访问的任何一个页面或者资源，都存在于这个世界上的某一台服务器上

- 这些统一的`web`资源会被放在同一个文件夹下，会被`Tomcat`服务器所呈现出来

- 一个`web`应用由多部分组成

  `html`、`css`、`js`

  `jsp`、`servelet`

  `java`程序

  `jar`包

  配置文件`Properties`	

### 1.3 静态web

- `*.htm`，`*.html`都是网页的后缀，如果服务器上一直存在这些资源，我们就可以获取
- 静态`web`存在的缺点
  - `web`页面无法动态更新，所有用户看到都是同一个页面
  - 无法与数据库交互(数据无法持久化)

### 1.4 动态`web`

- 页面会动态展示：`web`的页面展示的效果因人而异

- 缺点

  加入服务器的动态`web`资源出现了错误，我们需要重新编写我们的后台程序，停机维护，重新发布

- 优点：

  可以与数据库交互(数据持久化)

## 2. web服务器

### 2.1 技术详解

ASP

- 微软：国内最早流行的`ASP`
- 在`HTML`中嵌入了`VB`的脚本，`ASP`+`COM`
- 在`ASP`开发中，基本一个页面都有几千行的业务代码，页面极其混乱，维护成本很高，开发语言为`C#`

PHP

- `PHP`开发速度很快，功能很强大，跨平台，代码很简单
- 无法承载大访问量的情况

JSP/Servlet

- `sun`公司主推的`B/S`架构
- 基于`java`语言的(所有的大公司，或者一些开源的组件，都是`java`写的)
- 可以承载三高问题带来的影响
- 与`ASP`类似

### 2.2 web服务器

服务器是一种被动的操作，用来处理用户的一些请求和给用户一些响应信息

`java`主要用的`web`服务器是`tomcat`

## 3. Tomcat

### 3.1 配置

- 下载[官网](http://tomcat.apache.org/)

- 解压到某个目录

- 核心配置文件`server.xml`

- 对于`sudo apt install tomcat9`

  ```bash
  # 配置文件
  /etc/tomcat9/
  
  # 启动文件
  /usr/share/tomcat9
  
  # webapps
  /var/lib/tomcat9
  ```

- 默认端口`8080`

### 3.2 发布一个web

```bash
webapps
	- ROOT # 默认网站目录
	- example # 自定义网站目录
		- META-INF # 网站源信息
			- classes # java程序
			- lib # 网站依赖的jar包
			- context.xml # 网站配置文件
		- index.html # 默认首页
```

## 4. IDEA使用Maven

由于`maven`本身的问题，可能之后写的配置文件无法被导出的问题，在`pom.xml`下加入

```xml
<build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
    </resources>
</build>
```

修改`web.xml`为最新版

```xml
<?xml version="1.0" encoding="UTF-8"?>

<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                             http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0"
         metadata-complete="true">
</web-app>
```

