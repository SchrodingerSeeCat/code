# coding:utf-8



from flask import Flask, current_app, redirect
from flask.helpers import url_for

# 创建flask应用的对象
app = Flask(
    __name__,
    static_url_path="/python", # 访问静态资源的url前缀，默认值是static
    static_folder="static",  # 静态文件的目录，默认就是static
    template_folder="/templates"  # 模板文件的目录，默认是templates
)

# 对象配置参数
class Config(object):
    DEBUG = True
    SKY_SCRET = "abcdert"

app.config.from_object(Config)

@app.route("/")
@app.route("/index")
def index():
    """定义视图函数"""

    # 全局直接调用app
    # print(app.config.get("SKY_SCRET"))
    # return app.config.get("DEBUG")

    # 其他模块使用current_app调用
    return current_app.config.get("SKY_SCRET")
    # return "hello flask"

@app.route("/config")
def config():
    return 


# 修改访问方法
@app.route("/post_only", methods=["POST"])
def post_only():
    return "POST"


# 重定向
@app.route("/redirect")
def need_redirect():
    # return redirect("/")
    # 使用url_for的函数，通过视图函数的名字找到视图对应的url路径
    url = url_for("index")
    return redirect(url)




if __name__ == '__main__':
    print(app.url_map)
    app.run(host="0.0.0.0", port=8080, debug=True)