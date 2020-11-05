# FLASK

[TOC]

## 1. 安装

### 1.1 创建虚拟环境

```shell
mkdir 01_flask_hello
cd flask_hello
python3 -m venv venv
```

此时的文件夹中会生成一个`venv`文件夹，存放着当前项目所需要的依赖包等等。

### 1.2 激活虚拟环境

```shell
. venv/bin/activate
```

### 1.3 安装flask

```shell
pip install Flask==version
```

`pip`命令不要加`sudo`否则会安装到系统目录中

### 1.4 查看当前虚拟环境的包

```shell
pip freeze
```

输出

```shell
click==7.1.2
Flask==1.1.2
itsdangerous==1.1.0
Jinja2==2.11.2
MarkupSafe==1.1.1
Werkzeug==1.0.1
```

将当前依赖包输出到文件中

```shell
pip freeze > requirements.txt
```

安装当前项目缺失的依赖包

```shell
pip install -r requirements.txt
```

## 2. 快速上手

### 2.1 当前目录下新建hello.py

```python
# coding:utf-8

from flask import Flask

# 创建flask应用的对象
app = Flask(__name__)

@app.route("/")
def index():
    """定义视图函数"""
    return "hello flask"

if __name__ == '__main__':
    # 启动flask
    app.run()
```

### 2.2 启动falsk应用

```shell
# 启动应用
python3 hello.py
```

- `__name__`代表当前文件所在的模块的名字
- `flask`会以这个模块所在的目录为根目录，默认这个目录中的`static`为静态目录，`templates`为模板目录
- flask默认运行在`5000`端口

## 3. Flask创建app对象

### 3.1 初始化参数

```python
app = Flask(
    __name__,
    static_url_path="/python", # 访问静态资源的url前缀，默认值是static
    static_folder="static",  # 静态文件的目录，默认就是static
    template_folder="/templates",  # 模板文件的目录，默认是templates
)
```

### 3.2 配置参数

>  **对象配置参数**

```python
class Config(object):
    DEBUG = True

app.config.from_object(Config)
```

在视图函数中如果`app`是全局的可以直接导入

```python
app.config.get("DEBUG")
```

如果是其他的模块可以使用`current_app`

```python
current_app.config.get("DEBUG")
```

### 3.3 app.run()

`flask`应用通过`app.run()`来启动一个应用，默认的只能通过本地的回环地址进行访问

```shell
http://127.0.0.1:5000/
```

通过配置`host`和`port`可以实现全地址访问

```python
if __name__ == '__main__':
    app.run(host="0.0.0.0", port=8080)
```

## 4. 路由

### 4.1 app.url_map

`app.url_map`：保存着当前`flask`应用中的路由信息

```shell
Map([<Rule '/config' (OPTIONS, HEAD, GET) -> config>,
 <Rule '/' (OPTIONS, HEAD, GET) -> index>,
 <Rule '/python/<filename>' (OPTIONS, HEAD, GET) -> static>])
```

- `<Rule '/' (OPTIONS, HEAD, GET) -> index>`

- `/`：url路径

- `(OPTIONS, HEAD, GET)`：当前`url`路径可以使用的方法

- `index`：视图函数


 ### 4.2 修改访问方法

通过装饰器中的`method`字段自定义访问方法

```python
@app.route("/post_only", methods=["POST"])
def post_only():
    return
```

```shell
<Rule '/post_only' (OPTIONS, POST) -> post_only>
```

### 4.3 路由细节

- 如果有相同的路由相同的方法，最上面的视图函数会覆盖下面的视图函数

- 如果需要将两个`url`指向同一个视图函数，增加装饰器即可

  ```python
  @app.route("/")
  @app.route("/index")
  def index():
  	return "Hello World!"
  ```

- 路由重定向

  ```python
  from flask import redirect
  
  @app.route("/redirect")
  def need_redirect():
      # 第一种方式,直接将url写死
      return redirect("/")
  ```

  第二种方式：使用`url_for`的函数，通过视图函数的名字找到视图对应的`url`路径

  ```python
  def need_redirect():
      url = url_for("index")
      return redirect(url)
  ```

### 4.4 路由提取参数

`flask`提供了一套提取路由参数的方法，称为转换器（int）

```python
@app.route("/goods/<int:goods_id>")
def goods_detail(goods_id):
    return "goods detail page %d" % goods_id
```

如果不加转化器的类型，默认是普通字符串

转化器一共有三种

| 类型  | 功能                       |
| ----- | -------------------------- |
| int   | 接受整数                   |
| float | 同int，但是接受浮点数      |
| path  | 和默认的相似，但也接受斜线 |

> **实现自己的转换器**

1. 定义自己的转化器(类)

   ```python
   from werkzeug.routing import BaseConverter
   class RegexConverter(BaseConverter):
       # url_map 是路由映射表, regex是转换器传过来的正则表达式
       def __init__(self, url_map, regex):
           # 调用父类的初始化方法
           super().__init__(url_map)
           # 将正则表达式的参数保存到对象的属性中，flask会去使用这个属性来进行路由的正则匹配
           self.regex = regex
   ```

2. 将自定义的转化器添加到flask的应用中，以键值对的方式保存

   ```python
   app.url_map.converters["re"] = RegexConverter
   ```

3. *使用自定义的转化器*

   ```python
   @app.route("/send/<re(r'1[345678]\d{9}'):mobile>")
   def send_sms(mobile):
       return "send sms to %s" % mobile
   ```


> **可以直接将正则表达式卸载自定义的类的内部**

```python
class MobileConverter(BaseConverter):
    def __init__(self, url_map):
        super().__init__(url_map)
        self.regex = r'1[345678]\d{9}'
app.url_map.converters["mobile"] = MobileConverter

@app.route("/send2/<mobile:mobile2>")
def send_sms2(mobile2):
    return "send sms to %s" % mobile2
```

> **父类BaseConverter的方法**

`to_python(self, value)`

`to_python`方法将转换器匹配到到的路由参数`value`进一步加工，最后`to_python`返回的值作为视图函数的参数

```python
# value是在路径进行正则表达式匹配的时候提取的参数
# 定义为自定义的转化器类的方法
def to_python(self, value):
	return "Hello World"

@app.route("/send2/<mobile:mobile2>")
def send_sms2(mobile2):
    return "send sms to %s" % mobile2

# 最终的返回值
# send sms to Hello World
```

`to_url(self, value)`操作的是在进行`url_for`的操作之后对参数再次进行装饰

```python
# 定义为自定义的转化器类的方法
def to_url(self, value):
	return "hahahhahaha"

@app.route("/index")
def index():
    url = url_for("send_sms2", mobile2="13545678901")
    return redirect(url)

# 最终的访问的路径
# http://127.0.0.1:5000/send2/hahahhahaha
```

## 5. 参数处理

> **request对象**

`Flask`中表示当前请求的`request`对象，`request`对象中保存了一次`HTTP`请求的所有信息

常用属性

| 属性    | 说明                           | 类型           |
| ------- | ------------------------------ | -------------- |
| data    | 记录请求的数据，并转换为字符串 | *              |
| form    | 记录请求中的表单数据           | MultiDict      |
| args    | 记录请求中的查询参数           | MultiDict      |
| cookies | 记录请求中的cookie信息         | Dict           |
| headers | 记录请求中的报文头             | EnvironHeaders |
| method  | 记录请求使用的HTTP方法         | GET/POST       |
| url     | 记录请求的URL地址              | string         |
| files   | 记录请求上传的文件             | *              |

### 5.1 前端数据的提取

表单格式的数据

```
key1=value1&key2=value2
```

request中包含了前端发送过来的所有请求数据

通过request.form可以直接提取请求体中的表单格式的数据，是一个类字典的对象，第二个参数表明如果没有改字段的默认值

如果有重复的键值对，只拿取第一个

```python
name = request.form.get("name", "匿名用户")
age = request.form.get("age", "未知")
```

如果要拿取多个重复的字段，返回一个列表

```python
name_list = request.form.getlist("name")
```

非表单数据

```python
request.data
```

`query`参数

```python
gender = request.args.get("gender", "未知")
```

### 5.2 method和上传文件

`method`可以拿到用户的请求方法，根据不同的请求方法，使用不同的逻辑处理

```python
if request.method == "GET":
	pass
else:
	pass
```

`flies`取得用户上传的文件

第一种方式，`pic`是前端上传文件时所取的名字

```python
@app.route("/upload", methods=["POST"])
def upload():
    """接收前端传送过来的文件"""
    file_obj = request.files.get("pic")
    if file_obj is None:
        return "上传失败"
    
    # 将文件保存到本地
    # 1.创建一个文件
    f = open("./demo.jpg", "wb")
    # 2.向文件写内容
    data = file_obj.read()
    f.write(data)
    # 3.关闭文件
    f.close()
    
    return "上传成功"
```

第二种方式

```python
@app.route("/upload", methods=["POST"])
def upload():
    """接收前端传送过来的文件"""
    file_obj = request.files.get("pic")
    if file_obj is None:
        return "上传失败"
    
    # f.close()
    file_obj.save("./demo.png")
    return "上传成功"
```

### 5.3 with

`with open`上下文管理器，可以自动关闭文件

```python
with open("1.txt", "wb") as f:
    f.write(b"Hello flask")
```

对于`with`托管的对象可以实现一下俩个方法

```python
class Foo(object):
    def __enter__(self):
        """进入with语句时被调用"""
        print("enter called")

    def __exit__(self, exc_type, exc_val, exc_tb):
        """离开with语句的时候被调用"""
        print("exit called")
        print("exc_type: %s" % exc_type)  # 异常类型
        print("exc_val: %s" % exc_val)  # 异常信息
        print("exc_tb: %s" % exc_tb)  # 异常的追踪信息
```

使用`with`托管对象

```python
with Foo() as foo:
    print("Hello python")
```

执行结果

```shell
enter called
Hello python
exit called
exc_type: None
exc_val: None
exc_tb: None
```

### 5.4 abort函数

`abort`提前结束视图函数的执行，并返回给前端特定的信息

传递状态码

```python
from flask import Flask, request, abort
# 上传文件
app = Flask(__name__)

@app.route("/login", methods=["GET"])
def login():
    username = ""
    password = ""
    if username != "zhangsan" or password != "admin":
        abort(400)
    else:
        return "success"

if __name__ == "__main__":
    app.run(debug=True)
```

传送响应体信息

```python
from flask import Flask, request, abort, Response
# 上传文件
app = Flask(__name__)

@app.route("/login", methods=["GET"])
def login():
    username = ""
    password = ""
    if username != "zhangsan" or password != "admin":
        res = Response("login falied")
        abort(res)
    else:
        return "success"
```

### 5.5 自定义错误信息

当页面出现特定的状态码是会默认调用

```python
@app.errorhandler(404)
def handle_404_error(err):
    # 返回的数据作为最终页面的呈现的数据
    return "你访问的页面不存在 %s" % err
```

### 5.5 自定义Reponse信息

#### 5.5.1 使用元组或者字典

```python
@app.route("/")
def index():
    # 响应体 状态码 响应头
    #　使用元组，返回自定义的响应信息
    return "index1 page", 400, [("city", "xinyang"), ("coding", "valid")]
```

使用字典

```python
return "index2 page", 400, {"city": "xinyang", "coding": "valid"}
```

使用字典自定义状态码和描述信息

```python
return "index3 page", "666 itcast status", {"city": "xinyang", "coding": "valid"}
```

#### 5.5.2 使用`make_response`

```python
# 响应体
resp = make_response("index3 page")
# 状态码
resp.status = "999 itcast"
# 响应头
resp.headers["city"] = "xinyang"
return resp
```

或者

```python
return make_response(
    "index4 page",
    "999 itcast",
    {
    	"city": "xinyang",
    	"author": "valid"
    }
)
```

## 6 json

### 6.1 json的基础用法

`python`标准库提供了`json`模块用于处理`json`的数据

`json.dumps()`将字典转换为`json`字符串并返回这个字符串

```python
import json

data = {
    "name": "zhangsan",
    "age": 18
}
json_str = json.dumps(data)
```

`json.loads()`将`json`字符串转换为字典，并返回这个字典

```python
import json
a = '{"city": "xinyang", "country": "china"}'

d = json.loads(a)
print(d["city"])
```

### 6.2 flask返回json

如果从视图 返回一个 `dict` ，那么它会被转换为一个 JSON 响应。

```python
@app.route("/")
def index():
    # json就是字符串
    return {
        "name": "python3",
        "age": 18
    }
```

使用 `jsonify()` 函数。该函数会序列化任何支持的 JSON 数据类型，会将请求头中的`Content-Type`设置为`application/json`

```python
from flask import jsonify
@app.route("/")
def index():
    data = {
        "name": "python3",
        "age": 18
    }
    return jsonify(data)
```

也可以

```python
return jsonify(city="sz", country="china")
```

## 7 cookie

### 7.1 设置cookie

默认的`cookie`是在浏览器关闭即失效

```python
from flask import Flask, make_response
app = Flask(__name__)

@app.route("/set_cookie")
def set_cookie():
    resp = make_response("success")
    # 设置cookie
    resp.set_cookie("Itcast", "Python")
    return resp


if __name__ == "__main__":
    app.run(debug=True)
```

可以自定义`cookie`的有效期，单位是秒

```python
resp.set_cookie("Itcast2", "Python2", max_age=3600)
```

### 7.2 获取cookie

```python
@app.route("/get_cookie")
def get_cookie():
    return request.cookies.get("Itcast")
```

### 7.3 删除cookie

本质是将cookie的过期时间设置为与设置时间一样

```python
@app.route("/delete_cookie")
def delete_cookie():
    resp = make_response("del success")
    resp.delete_cookie("Itcast")
    return resp
```

## 8. session

### 8.1 定义`session`

```python
from flask import Flask, session
app = Flask(__name__)
# 指定session的密钥
app.config["SECRET_KEY"] = "MY_SECRET"
@app.route("/login")
def login():
    # 设置session数据
    session["name"] = "python"
    session["mobile"] = "17611111111"
    return "login success"
```

使用`session`之前必须指定密钥

```python
app.config["SECRET_KEY"] = "MY_SECRET"
```

`flask`默认将`session`加密保存到`cookie`中

### 8.2 拿取`session`

```python
@app.route("/index")
def index():
    name = session.get("name")
    return "hello %s" % name
```

## 9. 请求钩子 hook

### 9.1 请求钩子装饰器

`before_first_request`：在处理第一个请求之前运行

`before_request`：每次请求之前运行

`after_request(response)`：如果没有未处理的异常抛出，每次请求之后运行

`teardown_request(response)`：在每次请求后运行，即使有未处理的异常

### 9.2 定义请求钩子

```python
@app.route("/index")
def index():
    print("我是主页")
    return "我是主页"

@app.before_first_request
def handle_before_first_request():
    print("第一次请求之前被执行")

@app.before_request
def handle_before_request():
    print("每次请求之前都被执行")

@app.after_request
def handle_after_request(response):
    print("每次请求之后都被执行， 视图函数没有出现异常")
    return response

@app.teardown_request
def handle_teardown_request(response):
    print("每次请求之前都被执行， 无论视图函数是否出现异常都会执行")
    return response
```

输出结果

```python
# 第一次请求之前被执行
# 每次请求之前都被执行
# 我是主页
# 每次请求之后都被执行， 视图函数没有出现异常
# 每次请求之前都被执行， 无论视图函数是否出现异常都会执行
```

`@app.teardown_request`需要在生产模式下才会被执行，`app.run(debug=True)`不会被执行

可以使用`request.path`来区分不同的视图函数，从而实现不同的操作

```python
@app.after_request
def handle_after_request(response):
    print("每次请求之后都被执行， 视图函数没有出现异常")
    if request.path == url_for("index"):
        print("处理主页的逻辑")
    else:
        print("处理非主页的逻辑")
    return response
```

## 10. flask_script扩展

安装

```python
pip3 install flask_script
```

使用

```python
from flask import Flask
from flask_script import Manager

app = Flask(__name__)

# 创建Manager管理类的对象
manager = Manager(app)

@app.route("/index")
def index():
    return "我是主页"

if __name__ == "__main__":
    # 通过manager启动
    manager.run()
```

执行命令

```python
python3 模块名字 runserver
```

指定ip和端口

```python
python3 模块名 runserver -h 0.0.0.0 -p 8080
```

## 11. 数据库

### 11.1 数据库配置

`SQLAlchemy`是一个关系型数据库框架，它提供了高层的`ORM`和底层的原生数据库的操作。`flask_sqlalchemy`是一个简化了`SQLAlchemy`操作的`flask`扩展

安装`flask_sqlalchemy`

```shell
pip3 install flask_sqlalchemy
```

安装数据库驱动

```shell
pip3 install pymysql
```

创建数据库

```mysql
create databases test charset=utf8;
```

配置数据库基本信息

```mysql
class Mysql(object):
    """sqlalchemy的配置信息"""
    # 数据库链接
    SQLALCHEMY_DATABASE_URI = 'mysql+pymysql://root:123456@localhost:3306/test?charset=utf8'
    # 绑定数据库和模型类,自动更新数据库
    SQLALCHEMY_TRACK_MODIFICATIONS = True
    # 查询时显示原始SQL语句
    SQLALCHEMY_ECHO = True
```

导入配置

```mysql
app.config.from_object(Mysql)
```

连接数据库

```python
from flask_sqlalchemy import SQLAlchemy
# 创建数据库sqlalchemy工具对象
db = SQLAlchemy(app)
```

### 11.2 数据库模型

常用的`SQLAlchemy`字段类型

| 类型名       | python类型        | 说明                                                |
| ------------ | ----------------- | --------------------------------------------------- |
| integer      | int               | 普通整数，一般32为                                  |
| Smallinteger | int               | 取值范围小的整数，一般16位                          |
| Biginteger   | int或long         | 不限精度的整数                                      |
| Float        | float             | 浮点数                                              |
| Numeric      | decimal.Decimal   | 普通整数，一般32位                                  |
| String       | str               | 变长字符串                                          |
| Text         | str               | 变长字符串，对较长或不限长度的字符串做了优化        |
| Unicode      | unicode           | 变长Unicode字符串                                   |
| Unicode Text | unicode           | 变长Unicode字符串，对较长或不限长度的字符串做了优化 |
| Boolean      | bool              | 布尔值                                              |
| Date         | datetime.date     | 时间                                                |
| Time         | datetime.datetime | 日期和时间                                          |
| LargeBinary  | str               | 二进制文件                                          |

常用的`SQLAlchemy`列选项

| 选项名                     | 说明                                              |
| -------------------------- | ------------------------------------------------- |
| primary_key                | 如果为True，代表主键                              |
| unique                     | 如果为True，代表这列不允许出现重复的值            |
| index                      | 如果为True，为这列创建索引，提高查询效率          |
| nullable                   | 如果为True，允许有空值，如果为False，不允许有空值 |
| default                    | 为这列定义默认值                                  |
| db.ForeignKey("表名.字段") | 指定当前列的外键约束                              |

创建模型类

```python
# 创建模型类
class Role(db.Model):
    """用户表/身份表"""
    __tablename__ = "tbl_roles"
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(32), unique=True)

    # 返回User的对象
    users = db.relationship("User", backref="role")
    
    def __repr__(self):
        """自定义对象的打印结果"""
        return "Role object: name: %s" % self.name

class User(db.Model):
    """用户表"""
    # 数据库的表名
    __tablename__ = "tbl_user"
    # 表中的字段 类型 约束
    id = db.Column(db.Integer, primary_key=True) # 整型的主键，会默认设置为自增主键
    name = db.Column(db.String(64), unique=True)
    email = db.Column(db.String(32), unique=True)
    role_id = db.Column(db.Integer, db.ForeignKey("tbl_roles.id"))  # 外键
```

### 11.3 创建数据库表

```python
if __name__ == "__main__":
    # 清除数据库的所有数据
    db.drop_all()

    # 创建所有的表
    db.create_all()
```

如果出现以下错误

```shell
    raise RuntimeError("'cryptography' package is required for sha256_password or caching_sha2_password auth methods")
RuntimeError: 'cryptography' package is required for sha256_password or caching_sha2_password auth methods
```

安装`cryptography`

```shell
pip3 install cryptography
```

### 11.4 CRUD

#### 11.4.1 增加记录

初始化

```python
# 清除数据库的所有数据,删除表
db.drop_all()

# 创建所有的表
db.create_all()
```

添加数据

```python
# 创建对象
role = Role(name="admin")
# session 记录对象任务
db.session.add(role)
# 提交任务到数据库中
db.session.commit()

role2 = Role(name="stuff")
db.session.add(role2)
db.session.commit()

user1 =User(name="wang", email="123@163.com", password="123456", role_id=role.id)
user2 =User(name="jj", email="124556@163.com", password="123456", role_id=role.id)
user3 =User(name="kk", email="sdafs@163.com", password="123456", role_id=role2.id)
user4 =User(name="ll", email="1jui23@163.com", password="123456", role_id=role2.id)

# 一次保存多条数据
db.session.add_all([user1, user2, user3, user4])
db.session.commit()
```

#### 11.4.2 查询记录

- 查询所有记录，返回一个列表

  ```python
  roles = Role.query.all()
  print(roles[0].name)
  ```

- 查询第一条记录

  ```python
  r = Role.query.first()
  print(r.name)
  ```

- 查询指定主键的值

  ```python
  r = Role.query.get(2)
  print(r.name)
  ```

- 过滤`filter_by`

  ```python
  users = User.query.filter_by(name="wang").all()
  user = User.query.filter_by(name="wang").first()
  ```

  如果不存在则`user`为`None`

  添加多个过滤条件，多个条件之间为`and`关系

  ```python
  user = User.query.filter_by(name="wang", password="123456").first()
  ```

- 过滤`filter`

  `and`关系

  ```python
  user = User.query.filter(User.name=="wang", User.password=="123456").first()
  ```

  `or`关系

  ```python
  from sqlalchemy import or_
  users = User.query.filter(or_(User.name=="wang", User.email.endswith("163.com"))).all()
  ```
  
- 偏移`offset`

  ```python
  # 表示跳过前两条记录
  users = User.query.offset(2).all()
  ```

- 限制`limit`

  ```python
  # 跳过第一条，取两条
  users = User.query.offset(1).limit(2).all()
  ```

- 排序`order_by`

  ```python
  # 降序
  users = User.query.order_by(User.id.desc()).all()
  
  # 升序
  users = User.query.order_by(User.id.asc()).all()
  ```

- 分组`group_by`

  ```python
  # 导入数据库的函数
  from sqlalchemy import func
  result = db.session.query(User.role_id, func.count(User.role_id)).group_by(User.role_id).all()
  print(result)
  ```

  结果

  ```
  [(1, 2), (2, 2)]
  ```

- 常用的`SQLAlchemy`查询过滤器

  | 过滤器      | 说明                                             |
  | ----------- | ------------------------------------------------ |
  | filter()    | 把过滤器添加到原查询上，返回一个新查询           |
  | filter_by() | 把等值过滤器添加到原查询上，返回一个新查询       |
  | limit       | 使用指定值限定原查询返回的结果                   |
  | offset()    | 偏移原查询返回的结果，返回一个新查询             |
  | order_by()  | 根据指定条件对原查询结果进行排序，返回一个新查询 |
  | group_by()  | 根据指定条件对原查询结果进行分组，返回一个新查询 |

- 关联查询

  ```python
  ro = Role.query.get(1)
  # 通过事先在模型中定义的`db.relationship("User", backref="role")`来进行查询
  print(ro.users) 
  
  user = User.query.get(1)
  print(user.role.name)
  ```

#### 11.4.3 更新记录

- 第一种方式

  ```python
  user = User.query.get(1)
  user.name = "Python"
  db.session.add(user)
  db.session.commit()
  ```

- 第二种方式

  ```python
  User.query.filter_by(name="jj").update({"name": "666", "password": "7852634"})
  db.session.commit()
  ```

#### 11.4.4 删除记录

```python
user = User.query.get(1)
db.session.delete(user)
db.session.commit()
```

### 11.5 自动迁移

1. 使用`flask`管理工具

   ```python
   from flask_migrate import Migrate
   # 创建flask脚本管理对象
   manager = Manager(app)
   ```

2. 使用数据库迁移工具

   安装

   ```shell
   pip3 install flask_migrate
   ```

   创建迁移对象

   ```python
   from flask_migrate import Migrate, MigrateCommand
   Migrate(app, db)
   # 向manager对象中添加数据库的操作指令
manager.add_command("db", MigrateCommand)
   ```
   
   修改启动项为
   
   ```python
   if __name__ == "__main__":
   	manager.run()
   ```
   
3. 步骤

   初始化项目，除了自己定义的模式之外，会自动生成一个`alembic_version`来记录数据库的每一次修改的hash值

   ```python
   python3 模块.py db init
   ```

   生成迁移文件，可以使用`-m`指定描述信息

   ```python
   python3 模块.py db migrate
   ```

   提交更改

   ```python
   python3 模块.py db upgrade
   ```

   查看提交记录

   ```python
   python3 模块.py db history
   ```

   回滚

   ```python
   python3 模块.py db downgrade 哈希值
   ```


## 12. 蓝图

装饰器的特殊用法，实现模块分割

```python
def index():
    return "page index"

app.route("/")(index)
```

使用蓝图进行模块分割

- 导入蓝图类`blue_print.py`

  ```python
  from flask import Blueprint
  ```

- 创建蓝图对象：蓝图就是一个小模块的抽象的概念`blue_print.py`

  ```python
  app_blue_print = Blueprint("blue_print", __name__)
  ```

- 创建蓝图路由`blue_print.py`

  ```python
  @app_blue_print.route("/index")
  def get_index():
      return "blue page"
  ```

- 导入蓝图模块并使用`main.py`

  ```python
  from blue_print import app_blue_print
  app.register_blueprint(app_blue_print)
  ```

## 13. 部署

- 安装`gunicorn`

  ```shell
  pip3 install gunicorn
  ```

- 查看部署时可以指定的参数

  ```shell
  gunicorn -h
  ```

- 部署

  `-w`进程的数目，`-b`绑定`ip`和端口，`-D`以守护进程的方式执行`--access-logfile`指定日志文件`main:app`模块名和应用名

  ```shell
  gunicorn -w 4 -b 127.0.0.1:8080 -D --access-logfile ./logs/log main:app
  ```

  