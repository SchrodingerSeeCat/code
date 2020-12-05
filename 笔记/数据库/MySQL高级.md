# MySQL高级

[TOC]

## 1. 概述

`mysql`的安装目录

| 路径              | 解释                      | 备注                       |
| ----------------- | ------------------------- | -------------------------- |
| /var/lib/mysql/   | mysql数据库文件的存放路径 | /var/lib/mysql/test.pid    |
| /usr/share/mysql  | 配置文件目录              | mysql.server命令及配置文件 |
| /usr/bin          | 相关命令目录              | mysqladmin mysqldump等命令 |
| /etc/init.d/mysql | 启停相关脚本              |                            |

修改字符集

- 查看字符集

  ```sql
  show variables like 'character%';
  ```

  