from flask import Blueprint


# 创建蓝图对象，蓝图就是一个小模块的抽象的概念
app_blue_print = Blueprint("blue_print", __name__)

@app_blue_print.route("/index")
def get_index():
    return "blue page"