# Mybatis

[TOC]

## 1. 简介

### 1.1 什么是MyBatis

- MyBatis 是一款优秀的**持久层**框架
- 它支持自定义 SQL、存储过程以及高级映射。
- MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作。
- MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。

- 获取

  ```xml
  <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
  <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.6</version>
  </dependency>
  ```

### 1.2 持久层

数据持久化：持久化就是讲程序的数据在持久状态和瞬时状态装换的过程

持久层：完成持久工作的代码块

## 2. 第一个Mybatis程序

### 2.1 搭建环境

1. 数据库准备