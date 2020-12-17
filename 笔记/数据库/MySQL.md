# MySQL

MySQL因为开源，免费等优点成为世界上最受欢迎的数据库管理系统，值得每一位coding爱好者去学习和掌握

## 一.MySQL启动

- 查看MySQL版本(未登录MySQL)

  ```cmd
  mysql --version
  ```

- 启动

  ```cmd
  net start mysql
  ```

- 停止

  ```cmd
  net stop mysql
  ```

- 登陆

  ```cmd
  mysql -h localhost -P 3306 -u root -p 
  ```

  h 主机名

  P 端口号

  u 用户名

  p 密码

  如果是连接本地的MySQL 参数h P可省略

  回车之后提示输入密码

- 退出

  ```cmd
  exit 或者 quit 或者 CTRL+C
  ```

- 查看当前MySQL版本(已登陆MySQL)

  ```mysql
  select version();
  ```

## 二.MySQL常用命令

**快速入门**

- 显示所有的数据库

  ```mysql
  show databases;
  ```

  每条语句的结尾可以用英文分号也可用\g

- 打开指定的数据库名

  ```mysql
  use db;
  ```

- 显示数据库db中所有的表(此时已进入db中)

  ```mysql
  show tables;
  ```

- 可以直接查看指定数据库的表

  ```mysql
  show tables from db
  ```

- 查看当前所在的数据库

  ```mysql
  select database()
  ```

- 创建一张表

  ```mysql
  create table student_info(
  	id int,
  	name varchar(20));
  ```

- 查看表的结构

  ```mysql
  desc student_info;
  ```

- 查看表的所有数据

  ```mysql
  select *from student_info
  ```

- 向表中插入一条记录

  ```mysql
  insert into student_info (id, name) values(1, "jack");
  ```

- 修改表中id为1的数据

  ```mysql
  update student_info set name="john" where id=1;
  ```

- 删除id为1的记录

  ```mysql
  delete from student_info where id=1;
  ```


## 三.MySQL的语法规范

1. MySQL不区分大小写但建议关键字大写，表明、列名小写

2. 每条命令最好用分号结尾

3. 每条命令根据需要，可以缩进或者换行。建议关键字单独一行

4. 注释 

   ```mysql
   #单行注释
   -- 单行注释有空格
   /*多行注释*/
   ```

## 四.SQL结构化查询语言

### DQL语言

现在有一个数据库一`myemployees`数据库中有一下几张表及其结构
$$
departments
$$

| 字段 | department_id | department_name | manager_id | location_id |
| ---- | ------------- | --------------- | ---------- | ----------- |
| 类型 | int           | varchar(3)      | int        | int         |

$$
employees
$$

| 字段 | employee_id | first_name  | last_name   | email       | phone_number | job_id      | salary       | commission_pct | manager_id | department_id | hiredate |
| ---- | ----------- | ----------- | ----------- | ----------- | ------------ | ----------- | ------------ | -------------- | ---------- | ------------- | -------- |
| 类型 | int         | varchar(20) | varchar(25) | varchar(25) | varchar(20)  | varchar(10) | double(10,2) | double(4,2)    | int        | int           | datetime |

$$
jobs
$$

| 字段 | job_id      | job_title   | min_salary | max_salary |
| ---- | ----------- | ----------- | ---------- | ---------- |
| 类型 | varchar(10) | varchar(35) | int        | int        |

$$
locations
$$

| 字段 | location_id | street_address | postal_code | city        | state_province | country_id |
| ---- | ----------- | -------------- | ----------- | ----------- | -------------- | ---------- |
| 类型 | int         | varchar(40)    | varchar(12) | varchar(30) | varchar(25)    | varchar(2) |

$$
job\_grades
$$

| 字段 | grade_level | lowest_sal | highest_sal |
| ---- | ----------- | ---------- | ----------- |
| 类型 | varchar(3)  | int        | int         |

数据库二`girls`数据库中有以下几张表
$$
admin
$$

| 字段 | id   | username    | password    |
| ---- | ---- | ----------- | ----------- |
| 类型 | int  | varchar(10) | varchar(10) |

$$
beauty
$$

| 字段 | id   | name        | sex     | borndate | phone       | photo | boyfriend_id |
| ---- | ---- | ----------- | ------- | -------- | ----------- | ----- | ------------ |
| 类型 | int  | varchar(50) | char(1) | datetime | varchar(11) | blob  | int          |

$$
boys
$$

| 字段 | id   | boyName     | userCP |
| ---- | ---- | ----------- | ------ |
| 类型 | int  | varchar(20) | int    |

以下的学习均会在数据库`myemployees`和`grils`进行

#### 基础查询

- 语法：`select 查询列表 from 表名`
- 查询列表可以是：表中的字段，常量表达式，函数
- 查询的结果是一个虚拟的表格
- **案例演示**

1. `use 数据库名称` 打开指定的数据库

   ```mysql
   USE myemployees;
   ```

2. 查询表中的某个字段

   ```mysql
   SELECT last_name FROM employees;
   ```

3. 查询表中的多个字段,中间以逗号隔开

   ```mysql
   SELECT last_name,salary,email FROM employees;
   ```

4. 查询表中的所有字段

   ```mysql
   SELECT * FROM employees;
   ```

5. 查询常量值 

   字符型和日期型的常量必须用单引号引起

   ```mysql
   SELECT 100;
   SELECT 'john';
   ```

6. 查询表达式

   ```mysql
   SELECT 100*10;
   ```

7. 查询函数 version() 返回MySQL版本号

   ```mysql
   SELECT version(); 
   ```

8. 起别名 AS可以省略

   - 便于理解
   - 如果要查询的字段有重名的情况，使用别名可以区分开来
   - 如果别名当中有关键字需用双引号或者单引号括起，建议双引号

   ```mysql
   SELECT 100%98 AS 结果;
   SELECT last_name AS 姓,first_name AS 名 FROM employees;
   ```

9. 去重

   案例：查询员工表中涉及到的所有的部门的编号

   ```mysql
   SELECT DISTINCT department_id FROM employees;
   ```

10. `+`号的作用 在MySQL中"+"仅仅为运算符，没有字符串拼接的功能

    两个操作数都为整数做加法

    ```mysql
    SELECT 100+90;
    ```

    其中一方为字符型，试图将字符型数值转换为数值型，转换成功，继续做加法运算

    ```mysql
    SELECT "123"+2;
    ```

    一方或者双方为字符则转换失败，则将字符转换为0继续做加法

    ```mysql
    SELECT 123+"john";
    ```

    其中一方为NULL则结果为NULL

    ```mysql
    SELECT NULL+10;
    ```

    案例：查询员工名和姓连接成一个字段并显示为姓名 使用`CONCAT(str1,str2...)`函数

    ```mysql
    SELECT
    	CONCAT( last_name, first_name ) AS 姓名 
    FROM
    	employees;
    ```

11. IFNULL(exp1,exp2)函数 判断exp1是否为NULL，若为NULL用exp2替换

    ```mysql
    SELECT
    	IFNULl( commission_pct, 0 ) AS 奖金率 
    FROM
    	employees;
    ```

#### 条件查询

- 语法：`SELECT 查询列表 from 表名 where 筛选条件;`

- 分类：

  1. 按条件表达式筛选 条件运算符：`>`,`<`,`=`,`!=`,`<> 不等于的另外一种写法`,`>=`,`<=`
  2. 按逻辑表达式筛选 逻辑运算符：`&&`,`||`,`!` 或者`and`,`or`,`not`
  3. 模糊查询 `like`,`between and`,`in`,`is null`

- 案例演示

1. 条件表达式筛选

   查询`工资>12000`的员工信息

   ```mysql
   SELECT * FROM employees WHERE salary>12000;
   ```

   查询部门编号`不等于90号`的员工名和部门编号

   ```mysql
   SELECT 
   	last_name,department_id 
   FROM 
   	employees 
   WHERE 
   	department_id<>90;
   ```

  2. 按逻辑表达式筛选

     查询`工资在10000到20000`之间的员工名、工资以及奖金

     ```mysql
     SELECT 
     	last_name,
     	salary,
     	commission_pct
     FROM 
     	employees
     WHERE
     	salary>=10000&&salary<=20000;
     ```

     查询部门编号不是在90到110之间，或者工资高于15000的员工信息

     ```mysql
     SELECT 
     	*
     FROM
     	employees
     WHERE 
     	NOT(department_id>=90&&department_id<=110)||salary>15000;
     ```

  3. 模糊查询

     `like` 一般和通配符搭配使用 	

     - `%`任意多个字符	

     - `_`任意单个字符

   查询员工名中包含字符a的员工信息

```mysql
SELECT
	* 
FROM
	employees 
WHERE
	last_name LIKE '%a%'
```

查询员工名中第三个字符为`n`，第五个字符为`l`的员工名和工资

```mysql
SELECT
	last_name,
	salary 
FROM
	employees 
WHERE
	last_name LIKE '__n_l%';
```

查询员工名中第二个字符为`_`的员工名 使用`\`转义

```mysql
SELECT
	last_name 
FROM
	employees 
WHERE
	last_name LIKE '_\_%';
    #last_name LIKE '_$_%' ESCAPE '$';
    #ESCAPE 指定$为转义字符
```

  `between and` 包含临界值 临界值不可颠倒

  查询员工编号`100到120`之间的员工信息

```mysql
SELECT
	* 
FROM
	employees 
WHERE
	employee_id BETWEEN 100 
	AND 120;
```

 `in`：用于判断某字段的值是否属于`in`列表中的某一项

  特点：

- 使用`in`提高语句简洁度

  - `in`列表的值类型必须统一或者兼容(可以隐式转换)

查询员工的工种编号是 `IT_PROG`、`AD_VP`、`AD_PRES`中的一个员工名和工种编号

  ```mysql
SELECT
	last_name,
	job_id 
FROM
	employees 
	WHERE
	#job_id='IT_PROT' OR job_id='AD_VP' OR job_id='AD_PRES';
	job_id IN ( 'IT_PROT', 'AD_VP', 'AD_PRES' );
  ```

 `is null`

 - `=`,`<>`不能判断`NULL`值

 - `is null` 为`NULL` ，`is not null` 不为`NULL`

  查询没有奖金的员工名和奖金率

```mysql
SELECT
	last_name,
	commission_pct 
FROM
	employees 
WHERE
	commission_pct IS NULL;
```

安全等于 `<=>` 可以判断`NULL`值也可判断普通值

查询没有奖金的员工名和奖金率

```mysql
SELECT
	last_name,
	commission_pct 
FROM
	employees 
WHERE
	commission_pct <=> NULL;
```

#### 排序查询

- 语法：`select 查询列表 from 表 where 筛选条件 order by 排序列表 asc|desc`

- 特点：

  - `desc`降序
  - `asc`升序
  - 不写默认升序

- 案例演示

 查询员工信息，要求工资`从高到底`排序

  ```mysql
  SELECT
  	* 
  FROM
  	employees 
  ORDER BY
  	salary DESC;
  ```

  查询部门编号`>= 90`的员工信息，按入职时间`(升序)`进行排序

  ```mysql
  SELECT
  	* 
  FROM
  	employees 
  WHERE
  	department_id >= 90 
  ORDER BY
  	hiredate ASC;
  ```

  按表达式(别名)排序：按年薪的高低显示员工的信息和年薪

  ```mysql
  SELECT
  	*,
  	salary * 12 * (1+IFNULL ( commission_pct, 0 )) AS 年薪 
  FROM
  	employees 
  ORDER BY
  	#salary * 12 * (1+IFNULL ( commission_pct, 0 ));
  	年薪 ASC;
  ```

  按函数排序：按姓名的长度显示员工的姓名和工资·`length(str)`求指定字符串str的长度

  ```mysql
  SELECT
  	CONCAT( first_name, last_name ),
  	salary 
  FROM
  	employees 
  ORDER BY
  	LENGTH(CONCAT( first_name, last_name )) ASC;
  ```

  按多个字段排序：查询员工信息，要求先按工资升序，再按员工编号降序

  ```mysql
  SELECT
  	* 
  FROM
  	employees 
  ORDER BY
  	salary ASC,
  	employee_id DESC;
  ```

  

#### 常见函数

- 概念：类似与编程语言中的方法，指将一组逻辑语句封装再方法体中，对外暴露方法名
- 优点：1.隐藏了实现的细节 2.提高代码的复用性
- 语法：`select 函数名(实参列表) from 表;`
- 分类：

  - 单行函数 `concat()`、`length()`、`ifnull()`等
  - 分组函数：做统计使用，又称为统计函数、聚合函数、组函数
- 案例演示

##### 单行函数

###### 字符函数

1. `length(str) ` 接受一个字符串返回改字符串的字节长度

   ```mysql
    SELECT LENGTH("john");
   ```

2. `concat(str1,str2,...)` 拼接字符串最少接受两个参数

   ```mysql
   SELECT
     	CONCAT( last_name, '_', first_name ) 
     FROM
     	employees;
   ```

3. `upper(str)` 转换为大写、`lower(str)`转换为小写

   ```mysql
   SELECT UPPER("john");
     SELECT LOWER("JoHN");
   ```

4. `substr()`该方法有重载 ,在SQL中字符串的索引是从1开始

   - `substr(str,pos)` 在str中截取从pos位置开始的所有字符

     ```mysql
     SELECT SUBSTR("我是一名学生",5);
       #结果：学生
     ```

   - `substr(str,pos,length)`  在str中截取从pos位置开始的length个字符

     ```mysql
     SELECT SUBSTR("我是一名学生",1,1);
       #结果：我
     ```

5. `instr(parentstr,sonstr)` 返回sonstr在parentstr中的第一次出现起始索引，如果找不到则返回`0`

   ```mysql
   SELECT INSTR("我是一名学生","学生");
     #结果：学生
   ```

6. `trim()` 

   - `trim(str)` 去除str中前后的空格

     ```mysql
     SELECT LENGTH(TRIM("    hahaha     ")) AS len;
     #结果：6
     ```

   - `trim(s FROM str)` 去除str中前后的字符s

     ```mysql
     SELECT TRIM("ab" FROM "abcdfghabab");
     #结果：cdfgh
     ```

  7. `LPAD(str,len,padstr)`用padstr左填充指定长度len的字符串str,如果原本字符str以超过len则会`左`截取

     ```mysql
     SELECT LPAD("我是一名学生",10,"*");
     #结果：****我是一名学生
     
     SELECT LPAD("我是一名学生",2,"*");
     #结果：我是
     ```

  8. `RPAD(str,len,padstr)`用padstr右填充指定长度len的字符串str,如果原本字符str以超过len则会`左`截取

     ```mysql
     SELECT RPAD("我是一名学生",10,"*");
     #结果：我是一名学生****
     
     SELECT RPAD("我是一名学生",2,"*");
     #结果：我是
     ```

  9. `replace(str,from_str,to_str)` 在字符串str中将from_str替换to_str，若str中有多个from_str则全部替换

     ```mysql
     SELECT REPLACE("我是一名学生","学生","教师");
     #结果：我是一名教师
     ```

###### 数学函数    

1. `round()`

   - `round(num)`四舍五入

     ```
     SELECT ROUND(1.65);
     #结果：2
     ```

   - `round(num,digit)` 四舍五入并保留小数点后digit位

     ```mysql
     SELECT ROUND(1.567,2);
     #结果：1.56
     ```

2. `ceil(num)` num向上取整即返回>=该参数的最小整数

   ```mysql
   SELECT CEIL(1.003);
   #结果：2
   ```

3. `floor(num)` num向下取整即返回<=该参数的最大整数

   ```mysql
   SELECT FLOOR(9.99);
   #结果：9
   ```

4. `truncate(num,digit)` 保留小数点后digit位

   ```mysql
   SELECT TRUNCATE(1.789999,1);
   #结果：1.7
   ```

5. `mod(num1,num2)` 将num1对num2取余 `num1-num1/num2*num2`

   ```mysql
   SELECT MOD(10,3);
   #结果：1
   ```

6. `rand()`获取随机数，返回0-1之间的整数

   ```mysql
   SELECT rand();
   ```


###### 日期函数

1. `now()` 返回当前系统日期+时间

   ```mysql
   SELECT NOW();
   #结果：2020-03-29 16:49:36
   ```

2. `curdate()` 返回当前系统日期，不包含时间

   ```mysql
   SELECT curdate();
   #结果：2020-03-29
   ```

3. `curtime()` 返回当前时间，不包含日期

   ```mysql
   SELECT CURTIME();
   #结果：16:52:43
   ```

4. `year(date)`、`month(date)`、`day(date)`、`hour(date)`、`minute(date)`、`second(date)` 获取相应的部分

   ```mysql
   SELECT YEAR(NOW());
   #结果：2020
   
   SELECT MONTH(NOW());
   #结果：3
   
   SELECT MONTHNAME(NOW());
   #结果：March
   ```

5. `str_to_DATE(date,expression)`按照expression的形式格式化日期date

   ```mysql
   SELECT STR_TO_DATE("2020-3-29","%Y-%c-%d");
   #结果：2020-03-29
   ```

   查询入职日期为1992-4-3的员工信息

   ```mysql
   SELECT
   	* 
   FROM
   	employees 
   WHERE
   	hiredate = STR_TO_DATE( "4-3 1992", "%m-%d %Y" );
   ```

6. `date_format(date,expression)`将日期转换为字符

   ```mysql
   SELECT DATE_FORMAT(NOW(),"%Y年%m月%d日");
   #结果：2020年03月29日
   ```

   查询有奖金的员工名和入职日期(xx月/xx日 xx年)

   ```mysql
   SELECT
   	last_name,
   	DATE_FORMAT( hiredate, "%m/%d %y" ) 入职日期
   FROM
   	employees;
   ```

   | 格式 | 功能                  |
   | ---- | --------------------- |
   | %Y   | 四位的年份            |
   | %y   | 二位的年份            |
   | %m   | 月份(01,02,...,11,12) |
   | %c   | 月份(1,2,...,11,12)   |
   | %d   | 日(01,02...)          |
   | %H   | 小时(24小时制)        |
   | %h   | 小时(12小时制)        |
   | %i   | 分钟(00,01,02,...,59) |
   | %s   | 秒(00,01,...59)       |

###### 其他函数

1. `version()` 查看数据库版本号

   ```mysql
   SELECT VERSION();
   #结果：8.0.19
   ```

2. `DATABASE()` 查看当前数据库

   ```mysql
   SELECT DATABASE();
   #结果：myemployees
   ```

3. `user()` 查看当前用户

   ```mysql
   SELECT USER();
   #结果：root@localhost
   ```

4. `password(str)` 返回字符串str的` MysqlSHA1`加密形式

   ```mysql
   #8.0版本不支持此函数
   ```

5. `md5(str)` 返回字符串str的`md5`加密形式

   ```mysql
   SELECT MD5("hahah");
   #结果 44bea1375d673dacfa7038a2a6896ae6
   ```

###### 流程控制函数

1. `if(expr1,expr2,expr3)` if else 的效果 expr1为条件表达式如果为真返回expr2否则返回expr3

   ```mysql
   SELECT
   	last_name,
   	commission_pct,
   IF
   	( commission_pct IS NULL, "没奖金", "有奖金" ) 
   FROM
   	employees;
   ```

2. case1`case 要判断的字段或表达式 when 常量1 then 要显示的值1或语句1;` 可以有多条最后`else 要显示的值n或语句n end`

   查询员工的工资

   部门号=30，显示的工资为1.1倍

   部门号=40，显示的工资为1.2倍

   部门号=50，显示的工资为1.3倍

   否则工资不变

   ```mysql
   SELECT
   	salary 原工资,
   	department_id,
   CASE
   		department_id 
   		WHEN 30 THEN
   		salary * 1.1 
   		WHEN 40 THEN
   		salary * 1.2 
   		WHEN 50 THEN
   		salary * 1.3 ELSE salary 
   	END AS 新工资 
   FROM
   	employees;
   ```

3. case2 `case when 条件1 then 要显示的值1或语句1 `可以有多个 `else 要显示的值n或语句n end`

   查询员工的工资的情况

   工资>20000 显示A级别

   工资>15000 显示B级别

   工资>10000 显示C级别

   否则显示D级别

   ```mysql
   SELECT
   	salary,
   CASE
   		
   		WHEN salary > 20000 THEN
   		"A" 
   		WHEN salary > 15000 THEN
   		"B" 
   		WHEN salary > 10000 THEN
   		"C" ELSE "D" 
   	END AS ”级别“ 
   FROM
   	employees;
   ```

##### 分组函数

1. `sum(field)`  求出字段field的和 `不支持`字符型，日期型字段 忽略`NULL`

   ```mysql
   SELECT
   	SUM( salary ) 
   FROM
   	employees;
   ```

2. `avg(field)`  求出字段field的平局值 `不支持`字符型，日期型字段 忽略`NULL`

   ```mysql
   SELECT
   	AVG( salary ) 
   FROM
   	employees;
   ```

3. `min(field)`  求出字段field的最小值 可以处理任何类型 忽略`NULL`

   ```mysql
   SELECT
   	MIN( salary ) 
   FROM
   	employees;
   ```

4. `max(field)`  求出字段field的最大值 可以处理任何类型 忽略`NULL`

   ```mysql
   SELECT
   	MAX( salary ) 
   FROM
   	employees;
   ```

5. `count(field)` 

   - `count(field)` 计算该字段不为`NULL`的个数 可以处理任何类型

     ```mysql
     SELECT COUNT(salary) FROM employees;
     
     SELECT COUNT(commission_pct) FROM employees;
     ```

   - `count(*)` 计算所有行

     ```mysql
     SELECT
     	COUNT(*) 
     FROM
     	employees; 
     ```

6. 以上几个函数都可以和distinct搭配实现去重的功能

   ```mysql
   SELECT
   	SUM( DISTINCT salary ) 
   FROM
   	employees;
   ```

7. 和分组函数一同查询的字段有限制要求是`group by`后的字段

   ```mysql
   SELECT
   	AVG( salary ),
   	employee_id 
   FROM
   	employees;
   #这种写法在MySQL5.0版本下employee_id查询所得到值没有实际含义
   #在MYSQL8.0版本下则会出现语法错误
   ```

#### 分组查询

- 语法：`select 分组函数,列(要求出现在group by的后面) from 表 where 筛选条件group by 分组的列表 order by 字句`
- 注意：查询列表比较特殊，要求是分组函数和group by后出现的字段

1. 查询每个工种的最高工资

   ```mysql
   SELECT
   	MAX( salary ),
   	job_id 
   FROM
   	employees 
   GROUP BY
   	job_id;
   ```

2. 查询每个位置上的部门个数

   ```mysql
   SELECT
   	COUNT(*),
   	location_id 
   FROM
   	departments 
   GROUP BY
   	location_id;
   ```

3. 增加分组前的筛选条件查询邮箱中包含a字符的，每个部门的平均工资

   ```mysql
   SELECT
   	AVG( salary ),
   	department_id
   FROM
   	employees 
   WHERE
   	email LIKE "%a%" 
   GROUP BY
   	department_id;
   ```

4. 增加分组后的筛选条件，

   查询哪个部门的员工个数>2 使用`having`关键字在语句末尾获取分组后的结果

   ```mysql
   SELECT
   	COUNT(*) 总数,
   	department_id 
   FROM
   	employees 
   GROUP BY
   	department_id
   HAVING COUNT(*)>2;
   #HAVING 总数 > 2;
   ```

   查询每个工种有奖金的员工的最高工资>120000的工种编号和最高工资

   ```mysql
   SELECT
   	MAX( salary ),
   	job_id 
   FROM
   	employees 
   WHERE
   	commission_pct IS NOT NULL 
   GROUP BY
   	job_id 
   HAVING
   	MAX( salary ) > 12000;
   ```

   查询领导编号>102的每个领导手下的最低工资>5000的领导编号是哪个，以及其最低工资

   ```mysql
   SELECT
   	MIN( salary ),
   	manager_id 
   FROM
   	employees 
   WHERE
   	manager_id > 102 
   GROUP BY
   	manager_id 
   HAVING
   	MIN( salary ) > 5000;
   ```

5. 按表达式或函数分组

   按员工姓名的长度分组，查询每一组的员工个数筛选员工个数>5的有哪些

   ```mysql
   SELECT
   	COUNT(*),
   	length( last_name ) 
   FROM
   	employees 
   GROUP BY
   	LENGTH( last_name ) 
   HAVING
   	COUNT(*) > 5;
   ```

6. 按多个字段分组

   查询每个部门每个工种的员工的平均工资

   ```mysql
   SELECT
   	AVG( salary ),
   	department_id,
   	job_id 
   FROM
   	employees 
   GROUP BY
   	department_id,
   	job_id;
   ```

7. 添加排序

   查询每个部门每个工种的员工的平均工资，并且按平居工资的高低显示

   ```mysql
   SELECT
   	AVG( salary ),
   	department_id,
   	job_id 
   FROM
   	employees 
   GROUP BY
   	department_id,
   	job_id;
   
   ORDER BY
   	AVG( salary ) DESC;
   ```


#### 连接查询

- 含义：又称多表查询，当查询的字段来自于多个表时就需要用到连接查询
- 笛卡尔乘积现象：表一 有m行，表二 有n行，结果m*n行
- 添加有效的连接条件
- 分类
  - 按年代分类
    - sql92标准：仅仅支持内连接
    - sql99标准：支持所有连接
  - 按功能分类
    - 内连接
      1. 等值连接
      2. 非等值连接
      3. 自连接
    - 外连接
      1. 左外连接
      2. 右外连接
      3. 全外连接
    - 交叉连接
- 案例演示

##### sql92标准

**等值连接**

查询`beauty`表中的女神对应`boys`表中男朋友，即`beauty`表中的`boyfriend_id`对应`boys`表中的`id`

```mysql
SELECT NAME
	'name',
	boyName 
FROM
	beauty,
	boys 
WHERE
	beauty.boyfriend_id = boys.id;
```

查询员工名对应的部门名

```mysql
SELECT
	last_name,
	job_title,
	# 如果不同的表中有相同的字段必须指定表名，如果有别名，必须使用别名
	e.job_id  
	FROM
	# 可以为表取别名
	employees AS e, 
	jobs AS j 
WHERE
	e.`job_id` = j.`job_id`;
```

筛选 查询有奖金的员工名，部门名

```mysql
SELECT
	last_name,
	department_name,
	commission_pct
FROM
	employees e,
	departments d 
WHERE
	e.department_id = d.department_id 
	AND e.commission_pct IS NOT NULL;
```

**非等值连接**

查询员工的工资和工资级别

```mysql
SELECT
	salary,
	grade_level 
FROM
	employees e,
	job_grades g 
WHERE
	e.salary BETWEEN g.lowest_sal 
	AND g.highest_sal;
```

**自连接**

查询 员工名和上级的名称

```mysql
SELECT
	e.employee_id,
	e.last_name,
	m.employee_id,
	m.last_name 
FROM
	employees e,
	employees m 
WHERE
	e.manager_id = m.manager_id;
```

##### sql99标准

- 内连接`inner`

- 外连接

  - 左外`left (outer)`
  - 右外`right (outer)`
  - 全外`full (outer)`

- 交叉连接 `cross`

- 语法

  ```mysql
  SELECT
  	查询列表 
  FROM
  	表 1 别名 【连接类型】
  	JOIN 表 2 别名 ON 连接条件 
  WHERE
  	筛选条件 
  GROUP BY
  	分组 
  HAVING
  	筛选条件 
  ORDER BY
  	排序列表
  ```

**内连接**

语法：`select 查询列表 from 表1 别名 inner join 表2 别名 on 连接条件`

特点：`inner join`连接和`sql92`语法中的等值连接效果是一样的，都是查询交集

**等值连接** 

查询员工名、部门名(调换位置)

```mysql
SELECT
	last_name,
	department_name 
FROM
	employees e
	INNER JOIN departments d ON e.department_id = d.department_id;
#表的顺序可调换
```

查询名字中包含e的员工名和工种名(添加筛选)

```mysql
SELECT
	last_name,
	job_title 
FROM
	employees e
	INNER JOIN jobs d ON e.job_id = d.job_id 
WHERE
	e.last_name LIKE "%e%";
```

查询部门个数>3的城市名和部门个数(添加分组+筛选)

```mysql
SELECT
	city,
	COUNT(*) 部门个数 
FROM
	locations l
	INNER JOIN departments d ON l.location_id = d.location_id 
GROUP BY
	city 
HAVING
	部门个数 > 3;
```

查询哪个部门的部门员工个数>3的部门名和员工数，并按个数降序(排序)

```mysql
SELECT
	department_name 个数, 
	COUNT(*) 
FROM
	departments d
	INNER JOIN employees e ON d.department_id = e.department_id 
GROUP BY
	department_name 
HAVING
	COUNT(*) > 3 
ORDER BY
	COUNT(*) DESC;
```

查询员工名、部门名、工种名、并按部门名降序(多表连接)

```mysql
SELECT
	last_name,
	department_name,
	job_title 
FROM
	employees e
	INNER JOIN departments d ON e.department_id = d.department_id
	INNER JOIN jobs j ON e.job_id = j.job_id 
ORDER BY
	department_name DESC;
```

**非等值连接**

查询员工的工资级别

```mysql
SELECT
	last_name,
	salary,
	grade_level 
FROM
	employees e
	# 非等值连接INNER可省略
	INNER JOIN job_grades j ON e.salary BETWEEN j.lowest_sal 
	AND j.highest_sal 
ORDER BY
	salary;
```

查询工资级别的个数>20的个数，并且按工资级别降序

```mysql
SELECT
	COUNT(*),
	grade_level 
FROM
	employees e
	JOIN job_grades g ON e.`salary` BETWEEN g.`lowest_sal` 
	AND g.`highest_sal` 
GROUP BY
	grade_level 
HAVING
	COUNT(*) > 20 
ORDER BY
	grade_level DESC;
#有些MySQL会报1055错误只需打开my.ini在[mysqld]加入以下一句话不包含#
#sql_mode=STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION
```

**自连接**

查询员工名字、上级的名字

```mysql
SELECT
	e.last_name,
	em.last_name
FROM
	employees e
	INNER JOIN employees em ON e.manager_id = em.employee_id;
```

查询姓名中包含字符k的员工的姓名、上级的名字

```mysql
SELECT
	e.last_name,
	em.last_name 
FROM
	employees e
	INNER JOIN employees em ON e.manager_id = em.employee_id 
WHERE
	e.last_name LIKE "%k%";
```

**外连接**

- 用于查一个表中有，另一个表中没有的记录
- 外连接的查询结果为主表中的所有记录，如果从表中有和它匹配的，则显示匹配的值，如果从表中没有和它匹配的则显示为`NULL`
- 外连接查询结果=内连接结果+主表中有而从表中没有的记录
- 左外连接，`left join`左边的是主表。右外连接，`right join`右边的是主表
- 左外和右外交换两个表的顺序，可以实现同样的结果
- 全外连接=内连接的结果+表1中有但表2中没有的+表2中有但表1中没有的

查询男朋友不在男神表的女神名

```mysql
SELECT
	b.`name`
FROM
	beauty b
	LEFT OUTER JOIN boys bo ON b.boyfriend_id = bo.id 
WHERE
	bo.id IS NULL;
```

查询哪个部门没有员工

1. 左外

   ```mysql
   SELECT
   	d.*,
   	e.employee_id 
   FROM
   	departments d
   	LEFT OUTER JOIN employees e ON d.department_id = e.department_id 
   WHERE
   	e.employee_id IS NULL;
   ```

2. 右外

   ```mysql
   SELECT
   	d.*,
   	e.employee_id 
   FROM
   	employees e
   	RIGHT OUTER JOIN departments d ON d.department_id = e.department_id 
   WHERE
   	e.employee_id IS NULL;
   ```

3. 全外，`MySQL`不支持

**交叉连接**

sql99语法实现笛卡尔乘积

```mysql
SELECT
	b.*,
	bo.* 
FROM
	beauty b
	CROSS JOIN boys bo;
```

##### `sql92`和`sql99`对比

1. 功能：`sql99`支持的校对
2. 可读性：`sql99`实现连接条件和筛选条件的分离，可读性较高

#### 子查询

- 含义：出现在其他语句中的select语句，称为子查询或内查询，外部的查询语句，称为主查询或外查询
- 分类
  - 按子查询出现的位置：
    - select后面：仅仅支持标量子查询
    - from后面：支持表子查询
    - ⭐where或having后面：支持标量子查询与列子查询和行子查询
    - exists后面(相关子查询)：表子查询
  - 按结果集的行列数不同
    - 标量子查询(结果集只有一行一列)
    - 列子查询(结果集只有一列多行)
    - 行子查询(结果集有一行多列)
    - 表子查询(结果集一般为多行多列)

##### where或者having后

特点

- 子查询放在小括号内
- 子查询一般放在条件的右侧
- 子查询的优先级大于主查询

**标量子查询(单行子查询)**

标量子查询，一般搭配着单行操作符使用 `>`,`<`,`>=`,`<=`,`=`,`<>`

谁的工资比`Abel`高

```mysql
SELECT
	last_name,
	salary 
FROM
	employees 
WHERE
	salary > ( 
		SELECT 
			salary 
		FROM 
			employees 
		WHERE 
			last_name = "Abel" 
	);
```

查询job_id与141号员工相同，salary比143号员工多的员工姓名，job_id 和工资

```mysql
SELECT
	last_name,
	job_id,
	salary 
FROM
	employees 
WHERE
	job_id = ( SELECT job_id FROM employees WHERE employee_id = 141 ) 
AND 
	salary > ( SELECT salary FROM employees WHERE employee_id = 143);
```

返回公司工资最少的员工的last_name,job_id和salary

```mysql
SELECT
	last_name,
	job_id,
	salary 
FROM
	employees 
WHERE
	salary = ( SELECT MIN( salary ) FROM employees );
```

查询最低工资大于50号部门最低工资的部门id和其最低工资

```mysql
SELECT
	MIN( salary ),
	department_id 
FROM
	employees 
GROUP BY
	department_id 
HAVING
	MIN( salary ) > (
		SELECT
			MIN( salary ) 
		FROM
			employees 
		WHERE
		department_id = 50 
	);
```



**列子查询(多行子查询)**

一般搭配着多行操作符使用`IN`,`ANY/SOME`,`ALL`

查询location_id是1400或者1700的部门中的所有员工姓名

```mysql
SELECT
	last_name 
FROM
	employees 
WHERE
	department_id IN (
		SELECT DISTINCT
			department_id 
		FROM
			departments 
		WHERE
			location_id = 1400 
		OR location_id = 1700 
 );
```

查询其他工种中比`job_id`为`IT_PROG`部门`任一`工资低的员工的员工号、姓名、job_id以及salary

```mysql
SELECT
	employee_id,
	last_name,
	job_id,
	salary 
FROM
	employees 
WHERE
	job_id <> "IT_PROG" 
	AND salary < ANY(
        SELECT
            salary
        FROM
            employees 
        WHERE
        job_id = "IT_PROG" 
	);
```

查询其他工种中比`job_id`为`IT_PROG`部门`所有`工资低的员工的员工号、姓名、job_id以及salary

```mysql
SELECT
	employee_id,
	last_name,
	job_id,
	salary 
FROM
	employees 
WHERE
	job_id <> "IT_PROG" 
	AND salary < ALL(
        SELECT
            salary
        FROM
            employees 
        WHERE
        job_id = "IT_PROG" 
	);
```

**行子查询**

结果集一行多列或多行多列

查询员工编号最小并且工资最高的员工信息

```mysql
SELECT
	* 
FROM
	employees 
WHERE
	( employee_id, salary ) = (
		SELECT
			MIN( employee_id ),
			MAX( salary ) 
		FROM
		employees 
	);
```

##### SELECT之后的子查询

结果集必须为一行一列

查询每个部门的员工个数

```mysql
SELECT 
	d.*,
	( 
		SELECT 
			COUNT(*) 
		FROM 
			employees e 
		WHERE 
			e.department_id = d.department_id 
	) 个数
FROM
	departments d;
```

查询员工工号=102的部门名

```mysql
SELECT
	( 
		SELECT 
			department_name 
		FROM 
			departments d 
		INNER JOIN 
			employees e 
		ON 
			d.department_id = e.department_id 
		WHERE 
			e.employee_id = 102 
	) 部门名;
```

##### FROM之后的子查询

将子查询的结果充当一张表，要求必须起别名

查询每个部门的平均工资等级

```mysql
SELECT
	e.*,
	g.grade_level 
FROM
	( 
		SELECT 
			AVG( salary ) ag, 
			department_id 
		FROM 
			employees 
		GROUP BY 
			department_id 
	) e
	INNER JOIN 
		job_grades g 
	ON 
		e.ag 
	BETWEEN g.lowest_sal AND g.highest_sal;
```

##### exists之后(相关子查询)

语法`exists(完整的查询语句)`结果为0或1，反应子查询的结果是否存在

```mysql
SELECT EXISTS
	( SELECT employee_id FROM employees );
```

查询有员工的部门名

```mysql
SELECT
	department_name 
FROM
	departments d 
WHERE
	EXISTS ( 
                SELECT 
                    * 
                FROM 
                    employees e 
                WHERE 
                    d.department_id = e.department_id 
    		);
```

查询没有女朋友的男神信息

```mysql
SELECT
	bo.* 
FROM
	boys bo 
WHERE
	NOT EXISTS 
		( 
			SELECT 
				boyfriend_id 
			FROM 
				beauty b 
			WHERE 
				bo.id = b.boyfriend_id 
		);
```

#### 分页查询

- 应用场景：当要显示的数据，一页显示不全，需要分页提交sql请求

- 语法

  ```mysql
  SELECT 
  	查询列表
  FROM 
  	表
  	连接类型 JOIN 
  	表2
  ON 
  	连接条件
  WHERE 
  	筛选条件
  GROUP BY 
  	分组字段
  HAVING 
  	分组后的筛选
  ORDER BY
  	排序后的字段
  LIMIT offset, size;
  # offset 要显示条目的其实索引(起始索引索引从0开始)
  # offset 可省略，默认从0开始
  # size 要显示的条目个数
  ```

- `limit`语句放在查询语句的最后

  查询前5条员工信息

  ```mysql
  SELECT
  	* 
  FROM
  	employees 
  LIMIT 0,5;
  ```

  查询第十一条到第二十五条

  ```mysql
  SELECT
  	* 
  FROM
  	employees 
  LIMIT 10,
  	15;
  ```

  有奖金的员工信息，并且工资较高的前十名

  ```mysql
  SELECT
  	* 
  FROM
  	employees 
  WHERE
  	commission_pct IS NOT NULL 
  ORDER BY
  	salary DESC 
  LIMIT 10;
  ```

#### `union`联合查询

合并：将多条查询语句的结果合并成一个结果

- 快速入门:查询部门编号`>90`或邮箱包含`a`的员工信息

  查询语句1

  union

  查询语句2

  ```mysql
  SELECT
  	* 
  FROM
  	employees 
  WHERE
  	department_id > 90 UNION
  SELECT
  	* 
  FROM
  	employees 
  WHERE
  	email LIKE '%a%';
  ```

- 应用：当我们要查询的结果，且多个表之间没有直接的连接关系，但查询的信息一致时

- 特点：

  1. 要求多条查询语句的查询列数是一致的
  2. 最后查询的字段名为第一条查询语句的字段名
  3. 要求每条查询语句的列顺序一致
  4. 联合查询会自动去重`union all`不去重

### DML语言

`DML`数据操作语言

- 插入：`insert`
- 修改：`update`
- 删除：`delete`

#### 插入语句

- 原则：

  1. 插入的值的类型要与列的类型一致或兼容
  2. 列数和值的个数保持一致
  3. 可以省略列名，默认所有列，顺序为表中列的顺序
  4. 字符、日期加单引号或双引号

- 方式一语法

  ```mysql
  insert into 表名(列名,...) values(值,...);
  ```

  在`beauty`表中插入一条新的记录

  ```mysql
  INSERT INTO beauty ( id, NAME, sex, borndate, phone, photo, boyfriend_id )
  VALUES
  	( 13, '唐艺昕', '女', '1990-4-23', '18999999999', NULL, 2 );
  ```

  支持插入多条

  ```mysql
  INSERT INTO beauty ( id, NAME, sex, borndate, phone, photo, boyfriend_id )
  VALUES
  	( 14, '唐艺昕', '女', '1990-4-23', '18999999999', NULL, 2 ),
  	( 15, '唐艺昕', '女', '1990-4-23', '18999999999', NULL, 2 ),
  	( 16, '唐艺昕', '女', '1990-4-23', '18999999999', NULL, 2 );
  ```

  支持子查询,把子查询的内容插入到指定表中

  ```mysql
  INSERT INTO beauty(id,name,phone)
  SELECT 17, '松溪', '12345678901';
  ```

- 方式二语法

  ```mysql
  insert into 表名 set 列名=值,列名-值...
  ```

  在`beauty`表中插入一条新的记录

  ```mysql
  INSERT INTO beauty 
  SET id = 18,
  `name` = '娜扎',
  phone = '110';
  ```

#### 修改语句

- 修改单表的记录

  语法：

  ```mysql
  update 表名 
  set 列=新值,...
  where 筛选条件;
  ```

  案例：修改`beauty`表姓唐的`phone`为`1234`

  ```mysql
  UPDATE beauty 
  SET phone = "1234" 
  WHERE
  	NAME LIKE '唐%'
  ```

- 修改多表的记录

  语法：

  ```mysql
  update 表1 别名
  inner | left | right join 表2 别名
  on 连接条件
  set 列=值,...
  where 筛选条件
  ```

  案例：

  修改张无忌的女朋友的手机号为114

  ```mysql
  UPDATE boys b
  INNER JOIN beauty g ON b.id = g.boyfriend_id 
  SET g.phone = "123" 
  WHERE
  	b.boyName = '张无忌';
  ```

  修改没有男朋友的女神的男朋友编号都为`2`

  ```mysql
  UPDATE boys b
  RIGHT JOIN beauty g ON b.id = g.boyfriend_id 
  SET g.boyfriend_id = 2
  WHERE
  	g.boyfriend_id IS NULL;
  ```

#### 删除语句

- 方式一

  单表删除语法

  ```mysql
  delete from 表名 where 筛选条件
  ```

  案例：删除`beauty`表中`phone`以`9`结尾的记录

  ```mysql
  DELETE 
  FROM
  	beauty 
  WHERE
  	phone LIKE '%9';
  ```

  多表删除语法

  ```mysql
  delete 别名 from 表1 别名, inner|left|right join 表2 别名 on 连接条件 where 筛选条件;
  ```

  案例：删除张无忌的女朋友的信息

  ```mysql
  DELETE g 
  FROM
  	beauty g
  	LEFT JOIN boys b ON b.id = g.boyfriend_id 
  WHERE
  	b.boyName = '张无忌';
  ```

- 方式二

  `truncate`语法 不能加筛选条件

  ```mysql
  truncate table 表名;
  ```

  案例：清空`boys`表

  ```mysql
  truncate table boys;
  ```

- 两种方式的区别

  1. `delete`可以加`where`条件,`truncate`不能加筛选条件
  2. `truncate`，效率比`delete`高
  3. 如果要删除的表中有自增长列，如果用`delete`删除后，再插入数据，自增长列的值从断点开始，而`truncate`删除后，再插入数据自增列从`1`开始
  4. `truncate`删除没有返回值，`delete`删除有返回值
  5. `truncate`删除不能回滚,`delete`删除可以回滚

### DDL语言

数据定义语言用于库和表的管理

1. 创建：`create`
2. 修改：`alter`
3. 删除：`drop`

#### 库的管理

- 库的创建

  ```mysql
  create database 数据库名;
  ```

  创建数据库`books`

  ```mysql
  CREATE DATABASE
  IF
  	NOT EXISTS books;
  ```

  库的修改：更改库的字符集

  ```mysql
  ALTER DATABASE books CHARACTER 
  SET gbk;
  ```

- 库的删除：

  ```
  DROP DATABASE IF is EXISTS books;
  ```

#### 表的管理

- 表的创建

  ```mysql
  create table 表明(
  	# 约束以及长度可选
  	列名 列的类型(长度) 约束,
  	列名 列的类型(长度) 约束,
  	...
  	列名 列的类型(长度) 约束
  )
  ```

  创建表`book`

  ```mysql
  CREATE TABLE book (
  	id INT,						#编号
  	book_name VARCHAR ( 20 ),	#图书名
  	price DOUBLE,				#价格
  	author_id INT,				#作者编号
  	publish_date TIMESTAMP 		#出版日期
  )
  ```

  创建表`author`

  ```mysql
  CREATE TABLE author(
  	id INT,
  	author_name VARCHAR(20),
  	nation VARCHAR(10) #国籍
  )
  ```

- 表的修改

  语法

  ```mysql
  alter table 表名 add|drop|modify|change [column] 列名 [列的类型 约束]
  ```

  修改列名：修改`book`表中`publish_date` 为 `publishdate`

  ```mysql
  ALTER TABLE book CHANGE COLUMN publish_date publishdate TIMESTAMP;
  ```

  修改列的类型或约束：修改`publishdate`的类型为`DATETIME`

  ```mysql
  ALTER TABLE book MODIFY COLUMN publishdate DATETIME;
  ```

  添加新列：为表`author`添加一个年薪`annual`列

  ```mysql
  ALTER TABLE author ADD COLUMN annual DOUBLE;
  
  #可以添加到指定列名之前/后
  ALTER TABLE author ADD COLUMN annual DOUBLE FIRST/AFTER 列名;
  ```

  删除列：删除`author`表中的`annual`列

  ```mysql
  ALTER TABLE author DROP COLUMN annual;
  ```

  修改表名：修改表`author`的名字为`book_author`

  ```mysql
  ALTER TABLE author RENAME TO book_author;
  ```

- 表的删除：删除`book_author`表

  ```mysql
  DROP TABLE book_author;
  ```

- 表的复制

  仅仅复制表的结构：将`author`表复制到`copy`表

  ```mysql
  CREATE TABLE copy LIKE author;
  ```

  复制表的结构和数据：将`author`表复制到`copy`表

  ```mysql
  CREATE TABLE copy SELECT * FROM author;
  ```

### SQL数据类型

#### 数值型

- 整型

  | 整数类型    | 字节 | 范围                                  |
  | ----------- | ---- | ------------------------------------- |
  | tinyint     | 1    | 有符号：-2^7~2^7-1 无符号：0~2^8-1    |
  | smallint    | 2    | 有符号：-2^15~2^15-1 无符号：0~2^16-1 |
  | mediumint   | 3    | 有符号：-2^23~2^23-1 无符号：0~2^24-1 |
  | int/integer | 4    | 有符号：-2^31~2^31-1 无符号：0~2^32-1 |
  | Bigint      | 8    | 有符号：-2^63~2^63-1 无符号：0~2^64-1 |

  设置无符号和有符号(加关键字`unsigned`)

  ```mysql
  CREATE TABLE tab(
  	t1 INT,
  	t2 INT UNSIGNED
  );
  ```

  插入的值超出临界值会设置临界值`mysql 5.x`,`mysql 8.x`会报错误。

  不设置长度，会有默认的长度，长度仅代表显示的最大宽度。

  `ZEROFILL`零填充，设置零填充之后，默认无符号

- 小数

  定点数

  | 浮点数       | 字节 |
  | ------------ | ---- |
  | float(M, D)  | 4    |
  | double(M, D) | 8    |

  浮点数

  | 定点数                   | 字节 | 范围                                                         |
  | ------------------------ | ---- | ------------------------------------------------------------ |
  | DEC(M, D)，DECIMAL(M, D) | M+2  | 最大取值范围与double相同，给定decimal的有效值范围由M和D决定，默认(10, 0) |

  在小数中`M`代表长度`D`小数点保留的位数

  `M`、`D`都可以省略如果是`decimal`、则默认为`10`、`D`默认为`0`，如果是`float`和`double`，则会根据插入的数值的精度来决定

  定点型的精确度较高

#### 字符型

- 较短的文本：`char`，`varchar`

  | 字符串类型 | 最多字符数          | 描述及存储要求              |
  | ---------- | ------------------- | --------------------------- |
  | char(M)    | M可以省略默认为1    | M为0~255                    |
  | varchar(M) | M不可省略           | M为0~65535                  |
  | ENUM(list) | list,为可插入的数据 | 枚举                        |
  | SET(list)  | list为可插入的数据  | 与ENUM不同的是SET可插入多个 |

  `char`固定长度的字符，空间耗费高但效率好，

  `varchar`可变长度的字符，比较节省空间，效率低

- 长的文本：`text`、`blob`较长的二进制

- 日期型

  | 类型      | 字节 | 最小值         | 最大值              |
  | --------- | ---- | -------------- | ------------------- |
  | date      | 4    | 1000-01-01     | 9999-12-31          |
  | datetime  | 8    | 1000-01-01     | 9999-12-31 23:59:59 |
  | timestamp | 4    | 19700101080001 | 2038年的某个时刻    |
  | time      | 3    | -838:59:59     | 838:59:59           |
  | year      | 1    | 1901           | 2155                |

  `timestamp`和实际的时区有关，更能反应实际的日期，而`datetime`则只能反映出插入时的当地时区    

### 常见约束

#### 介绍：

一种限制，用于限制表中的数据，为了保证表中的数据的准确和可靠性

- `NOT NULL`非空，用于保证该字段的值不能为空
- `DEFAULT`默认值，用于保证该字段有默认值
- `PRIMARY KEY`主键，用于保证该字段唯一性，并且非空，可以有多个列形成一个主键 
- `UNIQUE`用于保证该字段的唯一性，可以为空
- `CHECK`检查约束`mysql`不支持
- `FOREIGN KEY`外键，用于限制两个表的关系，用于保证该字段的值必须来自于主表的关联列的值。在从表中添加外键约束，引用主表中某列的值，插入数据时先插入主表，再插入从表。

添加约束的时机

- 创建表时
- 修改表时

约束的分类

- 列级约束

  外键，检查约束没有效果

- 表级约束

  除了非空和默认其他均支持

检查索引

```mysql
SHOW INDEX FROM 表名;
```

#### 案例

创建表时添加约束

```mysql
CREATE TABLE stuinfo(
	id INT PRIMARY KEY, 						   #主键
	stuName VARCHAR(20) NOT NULL , 				   #非空
	gender CHAR CHECK(gender='男' OR gender='女'), #检查
	seat INT UNIQUE, 							  #唯一
	age INT DEFAULT 18, 						  #默认值  
);
```

添加表级约束

```mysql
CREATE TABLE stuinfo(
	id INT,
	stuname VARCHAR(20),
	gender CHAR,
	seat INT,
	age INT,
	majorid INT,
	
	CONSTRAINT pk PRIMARY KEY(id),					#为id添加主键
	CONSTRAINT up UNIQUE(seat),						#唯一
	CONSTRAINT ck CHECK(gender='男' OR gender='女'), #检查
	CONSTRAINT fk FOREIGN KEY(majorid) REFERENCES major(id)#外键
    
    #CONSTRAINT 名字 可省略
);
```

修改表时添加约束

列级

```mysql
ALTER TABLE 表名 MODIFY COLUMN 字段名 类型 约束
```

表级

```mysql
ALTER TABLE 表名 ADD UNIQUE(字段名);
```

外键

级联删除：在删除主表中的记录时可以将从表中引用该记录的记录一同删除

```mysql
ALTER TABLE 表名 ADD CONSTRAINT 外键名 FOREIGN KEY (字段名) REFERENCES 主表(字段) ON DELETE CASCADE;
```

级联置空：在删除主表中的记录可以将从表中引用该记录的外键置空

```mysql
ALTER TABLE 表名 ADD CONSTRAINT 外键名 FOREIGN KEY (字段名) REFERENCES 主表(字段) ON DELETE SET NULL;
```

#### 标识列

- 又称为自增长列，可以不用手动插入值，系统提供默认的序列值

  标识列可以和任意`key`搭配

  一个表中至多一个标识列

  标识列只能是数值型

- 案例

  ```mysql
  CREATE TABLE tab_auto(
  	id INT PRIMARY KEY AUTO_INCREMENT,
  	name VARCHAR(20)
  );
  ```

- 设置自增长的步长

  ```mysql
  SET auto_increment_increment=3
  
  # 默认值为1
  ```

### TCL语言

`Transaction Control Language`事物控制语言

事物：一个或一组sql语句组成一个执行单元，这个执行单元要么全部执行，要么全部不执行。

事物的`ACID`属性

1. 原子性：原子性是指事物是一个不可分割的工作单位，事物中的操作要么都发生，要么都不发生
2. 一致性：事物必须使数据库从一个一致性状态变换到另外一个一致性状态
3. 隔离性：事物的隔离性是指一个事物的执行不能被其他事物干扰，即一个事物内部的操作及使用的数据对并发的其他事物是隔离的，并发执行的各个事物之间不能相互干扰
4. 持久性：持久性是指一个事物一旦被提交，它对数据库中数据的改变就是永久性的，接下来的其他操作和数据库故障不应该对其有任何影响

#### MySQL的存储引擎

- 概念：在`mysql`中的数据用各种不同的技术存储在文件(或内存)中
- 通过`show engines`可以查看mysql支持的存储引擎
- 在mysql中用的最多的存储引擎有：`innodb`、`myisam`、`memory`等。其中`innodb`支持事物，而`myisam`、`memory`不支持事物

#### 事物的创建

隐式事物：事物没有明显的开启和结束的标记`insert`、`update`、`delete`语句

显示事物：事物有明显的开启和结束的标记，前提是先设置自动提交功能为禁用

查看自动提交

```mysql
SHOW VARIABLES LIKE 'autocommit';
```

设置自动提交功能为禁用，只针对当前会话

```mysql
SET autocommit=0;
```

显示事物的步骤

```mysql
SET autocommit=0;
start transaction; #开启事物，可选的

#编写事物中的sql包括(select insert update delete)
语句1;
savepoint 回滚点名称; #设置回滚点
语句2;
...
commit; #提交事物
rollback; #回滚事物默认回滚所有，可以加上回滚点，TRUNCATE不能回滚
```

案例：

```mysql
CREATE TABLE account(
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(20),
	balance DOUBLE
);

INSERT INTO account(username,balance)
VALUES('张无忌', 1000),('赵敏', 1000);

#开启事物
SET autocommit=0;
START TRANSACTION;
#编写一组事物的语句
UPDATE account SET balance=500 WHERE username='张无忌';
UPDATE account SET balance=1500 WHERE username='赵敏';
#结束事物
COMMIT;
```

#### 事务的隔离级别

- 对于同时运行的多个事务，当这些事务访问数据库中相同的数据时，如果没有采取必要的隔离机制，就会导致各种并发问题

  - 脏读：对于两个事务`T1`、`T2`，T1读取了已经被T2更新但还没有被提交的字段之后，若T2回滚，T1读取的内容就是临时且无效的

  - 不可重复读：对于两个事务T1，T2，T1读取了一个字段，然后T2更新了字段之后，T1再次读取同一个字段，值就不同了。
  - 幻读：对于两个事务T1，T2，T1从一个表中读取了一个字段，然后T2在该表中插入了一些新的行之后，如果T1再次读取同一个表，就会多出几行数据

- 数据库事务的隔离性：数据库系统必须具有隔离并发运行各个事务的能力，使它们不会相互影响，避免各种并发问题

- 一个事务与其他事务隔离程度称为隔离级别，数据库规定了多种事务隔离级别，不同隔离级别分别对应不同的干扰程度，隔离级别越高，数据的一致性就越好，但并发生越弱

- 数据库提供的事务隔离级别

  | 隔离级别                      | 描述                                                         |
  | ----------------------------- | ------------------------------------------------------------ |
  | READ UNCOMMITED(读未提交数据) | 允许事务读取未被其他事务提交的变更，脏读，不可重复读和幻读的问题都会出现 |
  | READ COMMITED(读已提交数据)   | 只允许事务读取已经被其他事务提交的变更，可以避免脏读，但不可重复读和幻读问题仍然会出现 |
  | REPEATABLE READ(可重复读)     | 确保事务可以从一个字段中读取相同的值，这个事务持续期间，禁止其他事务对这个字段进行更新，可以避免脏读和不可重复读，但幻读仍然存在。 |
  | SERIALIZABLE(串行化)          | 确保事务可以从一个表中读取相同的行，这个事务持续期间，禁止其他事务对该表执行插入，更新和删除操作，所有并发问题都可以避免，但性能十分低下。 |

- `Mysql`支持四种事务隔离级别，`Mysql`默认的事务隔离级别为：`REPEATABLE READ`

- 查看事务的隔离级别

  ```mysql
  #5.0
  SELECT @@tx_isolation
  
  #8.0
  SELECT @@transaction_isolation;
  ```

- 设置当前会话隔离级别

  ```mysql
  SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
  ```

### 视图

- 含义：虚拟表，和普通的表一样使用。是一种虚拟存在的表，行和列的数据来自定义视图的查询中使用的表，并且是在使用视图时动态生成的，只保存了sql逻辑，不保存查询结果

- 优点

  重用sql语句

  简化复杂的sql操作，不必知道它的查询细节

  保护数据，提高安全性

- 创建视图

  语法：

  ```mysql
  # 封装sql语句为一个视图
  CREATE VIEW 视图的名字
  AS 
  sql语句;
  
  # 调用视图
  SELECT * FROM 视图 筛选条件
  ```

  案例：

  查询姓名中包含a字符的员工名、部门名和工种信息

  ```mysql
  # 创建
  CREATE VIEW v 
  AS SELECT
  	last_name,
  	department_name,
  	job_title 
  FROM
  	employees e
  	INNER JOIN departments d ON e.department_id = d.department_id
  	INNER JOIN jobs j ON e.job_id = j.job_id;
  	
  # 使用
  SELECT * FROM v WHERE last_name LIKE '%a%';
  ```

- 修改视图

  方式一

  ```mysql
  CREATE OR REPLACE VIEW 视图名
  AS
  查询语句;
  ```

  方式二

  ```mysql
  ALTER VIEW 视图名
  AS
  查询语句;
  ```

- 删除视图

  ```mysql
  DROP VIEW 视图名,视图名,...;
  ```

- 查看视图

  ```mysql
  DESC 视图名;
  
  SHOW CREATE VIEW 视图名;
  ```

- 视图的更新

  具备如下特点的视图不允许更新

  1. 包含关键字`分组函数`,`distinct`,`group by`,`having`,`union`或者`union all`
  2. 常量视图
  3. `select`中包含子查询
  4. `join`能`update`
  5. `from`一个不能更新的视图
  6. `where`子句的子查询引用了子句中的表

  插入

  ```mysql
  INSERT INTO 视图名(字段名) VALUES(值);
  ```

  修改

  ```mysql
  UPDATE 视图名 SET 字段='值' WHERE 筛选条件;
  ```

  删除

  ```mysql
  DELETE FROM 视图名 WHERE 筛选条件;
  ```

## 五.变量

### 系统变量

含义：变量由系统提供，不是用户定义的，属于服务器层面

#### 全局变量

- 作用域：服务器每次启动将为所有的系统变量赋初始值，针对于所有的会话(连接有效)，重启重置。

- 查看全局变量

  ```mysql
  # 查看全局变量
  SHOW GLOBAL VARIABLES;
  ```

- 查看满足条件的部分全局变量

  ```mysql
  SHOW GLOBAL VARIABLES LIKE '变量名';
  ```

- 查看指定的某个全局变量的值

  ```mysql
  SELECT @@GLOBAL.变量名; 
  ```

- 为某个全局变量赋值

  ```mysql
  SET GLOBAL 系统变量名 = 值;
  
  SET @@GLOBAL.系统变量名=值
  ```

- 注意：如果是全局级别，需要加`global`，如果是会话级别需要加`session`，如果不写，则默认`session`

#### 会话变量

- 作用域：仅仅针对于当前会话连接有效

- 查看会话变量

  ```mysql
  SHOW [SESSION] VARIABLES;
  ```

- 查看部分的会话变量

  ```mysql
  SHOW [SESSION] VARIABLES LIKE '变量名';
  ```

- 查看某个指定的某个会话变量

  ```mysql
  SELECT @@[SESSION.]变量名;
  ```

- 为某个会话变量赋值

  ```mysql
  SET @@SESSION.变量名;
  
  SET SESSION 变量名='值';
  ```

  

### 自定义变量

变量是用户自定义的，不是由系统提供的

使用：声明，赋值，使用(查看、比较、运算)

#### 用户变量

- 作用域：针对于当前会话(连接)有效。应用在任何地方，也就是`begin end`里面或`begin end`外面

- 声明并初始化

  ```mysql
  # 方式1
  SET @用户变量名=值;
  
  # 方式2
  SET @用户变量名:=值;
  
  # 方式3
  SELECT @用户变量名:=值;
  ```

- 赋值更新用户变量的值

  ```mysql
  # 方式1与声明相同
  SET @用户变量名=值;
  SET @用户变量名:=值;
  SELECT @用户变量名:=值;
  
  # 方式2 SELECT INTO
  SELECT 字段 INTO @变量名 FROM 表
  ```

- 使用(查看用户变量的值)

  ```mysql
  SELECT @用户变量名;
  ```

#### 局部变量

- 作用域：仅仅在带你故意它的`begin end`中有效,仅用于`begin end`中的第一句话

- 声明

  ```mysql
  DECLARE 变量名 类型;
  
  DECLARE 变量名 类型 DEFAULT 值;
  ```

- 赋值

  ```mysql
  # 方式1与声明相同
  SET 局部变量名=值;
  SET 局部变量名:=值;
  SELECT @局部变量名:=值;
  
  # 方式2 SELECT INTO
  SELECT 字段 INTO 局部变量名 FROM 表
  ```

- 使用

  ```mysql
  SELECT 局部变量名;
  ```

## 六.存储过程和函数

### 存储过程

- 存储过程和函数：类似于方法，是一组预先编译好的SQL语句的集合

- 优点：

  1. 提高代码的重用性
  2. 简化操作
  3. 减少了编译次数并且减少了和数据库服务器的连接次数，提高了效率

- 创建语法

  ```mysql
  CREATE PROCEDURE 存储过程名(参数列表)
  BEGIN
  	存储过程体(一组合法的SQL语句)
  END
  ```

  参数列表包含三部分，

  ```mysql
  参数模式，参数名，参数类型;
  ```

  参数模式

  ​	`IN`：该参数可以作为输入，需要调用方传入值

  ​	`OUT`：该参数可以作为输出，也就是该参数可以作为返回值

  ​	`INOUT`：该参数既可以作为输入又可以作为输出

  如果存储过程体仅仅只有一句话，`BEGIN END`可以省略

  存储过程体中的每条SQL语句的结尾要求必须加分号

  存储过程的结尾可以使用`DELIMITER`重新设置

  ```mysql
  DELIMITER 结束标记
  ```

- 调用

  ```mysql
  CALL 存储过程名(实参列表);
  ```

- 案例

  空参列表：插入`admin`表中五条记录

  ```mysql
  # 创建
  DELIMITER $
  CREATE PROCEDURE p () BEGIN
  	INSERT INTO admin ( username, `password` )
  	VALUES
  		( 'joh1', '111' ),
  		( 'joh2', '222' ),
  		( 'joh3', '333' ),
  		( 'joh4', '444' );
  
  END $
  
  # 调用
  CALL p();
  ```

  `IN`模式参数的存储过程

  根据女神名，查询对应的男神名

  ```mysql
  DELIMITER $
  CREATE PROCEDURE myp2(IN beautyName VARCHAR(20))
  BEGIN 
  	SELECT bo.* FROM boys bo
  	RIGHT JOIN beauty b ON bo.id = b.boyfriend_id
  	WHERE b.name=beautyName;
  END $
  
  CALL myp2('柳岩');
  ```

  `out`模式的存储过程

  根据女神名，返回对应的男神名

  ```mysql
  # 定义
  DELIMITER $
  CREATE PROCEDURE myp3(IN beautyName VARCHAR(20), OUT boyName VARCHAR(20))
  BEGIN
  	SELECT bo.boyName INTO boyName
  	FROM boys bo
  	INNER JOIN beauty b ON bo.id = b.boyfriend_id
  	WHERE boyName=b.name;
  END $
  # 定义变量 可省略
  SET @bName='';
  CALL myp3('小昭', @bName);
  # 输出变量
  SELECT @bName;
  ```

  `inout`模式参数的存储过程

  传入a和b两个值，最终a和b都乘2返回

  ```mysql
  CREATE PROCEDURE myp4(INOUT a INT, INOUT b INT)
  BEGIN
  	SET a=a*2;
  	SET b=b*2;
  END 
  
  SET @a=10;
  SET @b=20;
  CALL myp4(@a,@b);
  SELECT @a,@b;
  ```

- 存储过程的删除

  ```
  DROP PROCEDURE 存储过程名;
  ```

- 查看存储过程的信息

  ```mysql
  SHOW CREATE PROCEDURE 存储过程名;
  ```

### 函数

- 函数与存储过程的区别：

  存储过程：可以没有返回值，也可以有多个返回值

  函数：有且仅有一个返回值

- 函数的创建

  ```mysql
  CREATE FUNCTION 函数名(参数列表) RETURNS 返回类型
  BEGIN 
  	函数体
  END
  
  # 参数列表包含两部分 参数名 参数类型
  # 函数体：要由return语句，如果return语句没有放在函数体的最后也不会报错 不建议这样使用
  ```

- 调用

  ```mysql
  SELECT 函数名(参数列表);
  ```

- 案例

  无参有返回

  返回公司的员工个数

  ```mysql
  CREATE FUNCTION myf1 () RETURNS INT 
  BEGIN
  	# 定义变量
  	DECLARE c INT DEFAULT 0;
  	SELECT
  		COUNT(*) INTO c 
  	FROM
  		employees;
  	RETURN c;
  END 
  ```

  有参有返回

  根据员工名，返回它的工资

  ```mysql
  DELIMITER $
  CREATE FUNCTION myf2(empName VARCHAR(20)) RETURNS DOUBLE
  BEGIN 
  	DECLARE sal DOUBLE DEFAULT 0;
  	SELECT salary 
  	INTO sal
  	FROM employees
  	WHERE last_name=empName;
  	RETURN sal;
  END $
  
  SELECT myf2('Kochhar')$
  ```

  两数之和

  ```mysql
  DELIMITER $
  CREATE FUNCTION myf3(a FLOAT, b FLOAT) RETURNS FLOAT
  BEGIN
  	DECLARE c FLOAT DEFAULT 0;
  	SET c = a + b;
  	RETURN c;
  END $
  
  SELECT myf3(1.2, 1.3) $
  ```

- 查看函数

  ```mysql
  SHOW CREATE FUNCTION 函数名;
  ```

- 删除函数

  ```mysql
  DROP FUNCTION 函数名;
  ```

## 七.流程控制结构

### 分支结构

#### if函数

- 功能：实现简单的双分支

- 语法：

  ```mysql
  IF(表达式1, 表达式2, 表达式3)
  # 如果表达式1成立，则IF函数返回表达式2的值，否则返回表达式3的值
  ```

#### case结构

- 情况1：类似于`switch`,一般用于实现等值判断

  ```mysql
  CASE 变量|表达式|字段
  WHEN 要判断的值 THEN 返回的值1或语句1;
  WHEN 要判断的值 THEN 返回的值2或语句2;
  ...
  ELSE 要返回的值n或语句n;
  END CASE;
  ```

- 情况2：类似于多重`IF`,一般用于实现区间判断

  ```mysql
  CASE
  WHEN 要判断的条件1 THEN 返回的值1或语句1;
  WHEN 要判断的条件2 THEN 返回的值2或语句2;
  ...
  ELSE 要返回的值n或语句n;
  END CASE;
  ```

- 特点：

  可以作为表达式，嵌套其他语句中使用，可以放在任何地方，`BEGIN END`中或`BEGIN END`的外面

  可以作为对立的语句去使用，只能放在`BEGIN END`中

  如果`WHEN`中的值满足或条件成立，则执行对应的`THEN`后面的语句，并且结束`CASE`入宫都不满足则执行`ELSE`中的语句或值

  `ELSE`可以省略，如果`ELSE`省略了，并且所有`WHERE条件都不满足`,则返回`NULL`

- 案例

  创建存储过程，根据传入的成绩，来显示等级，比如传入的成绩：`90-100`显示A，`80-90`显示B，`60-80`显示C，其余显示D。

  ```mysql
  DELIMITER $
  CREATE PROCEDURE test(IN score INT)
  BEGIN
  	CASE 
  	WHEN score BETWEEN 90 AND 100 THEN SELECT 'A';
  	WHEN score BETWEEN 80 AND 90 THEN SELECT 'B';
  	WHEN score BETWEEN 60 AND 80 THEN SELECT 'C';
  	ELSE SELECT 'D';
  	END CASE;
  END $
  
  CALL test(95) $
  ```

#### if结构

- 功能：实现多重分支

- 语法

  ```mysql
  if 条件1 then 语句1;
  elseif 条件2 then 语句2;
  ...
  else 语句n; # 可省略
  end if;
  ```

  应用在`begin end`中

- 案例

  创建存储过程，根据传入的成绩，来显示等级，比如传入的成绩：`90-100`返回A，`80-90`返回B，`60-80`返回C，其余返回D。

  ```mysql
  DELIMITER $
  CREATE FUNCTION test(score INT) RETURNS CHAR
  BEGIN
  	IF score>=90 AND score<=100 THEN RETURN 'A';
  	ELSEIF score>=80 THEN RETURN 'B';
  	ELSEIF score>=60 THEN RETURN 'C';
  	ELSE RETURN 'D';
  	END IF;
  END $
  SELECT test(95) $
  ```

### 循环结构

- 分类

  `while`、`loop`、`repeat`都需要放在`BEGIN END`里面

- 循环控制

  `iterate`类似于`continue`,结束本次循环，继续下一次

  `leave`类似于`break`,结束当前所在的循环

- `while`

  ```mysql
  [标签:]WHILE 循环条件 DO
  	循环体;
  END WHILE [标签];
  ```

- `loop`

  ```mysql
  [标签:]LOOP
  	循环体;
  END LOOP [标签];
  
  # 需搭配leave使用
  ```

- `repeat`

  ```mysql
  [标签:]REPEAT
  	循环体;
  UNTIL 循环结束的条件
  END REPEAT [标签];
  ```

- 案例

  批量插入，根据次数插入到`admin`，最多插入20条

  ```mysql
  DELIMITER $
  CREATE PROCEDURE pro(IN insertCount INT)
  BEGIN 
  	DECLARE i INT DEFAULT 1;
  	a:WHILE i <= insertCount DO
  		INSERT INTO admin(username, `password`) VALUES('12', '测试');
  		IF i >= 20 THEN LEAVE a;
  		END IF;
  		SET i=i+1; 
  	END WHILE a;
  END $
  
  CALL pro(100) $
  ```

  