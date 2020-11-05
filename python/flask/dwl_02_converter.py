from flask import Flask, redirect
from flask.helpers import url_for
from werkzeug.routing import BaseConverter, parse_converter_args

app = Flask(__name__)

# 提取路由参数
@app.route("/goods/<int:goods_id>")
def goods_detail(goods_id):
    print(type(goods_id))
    return "goods detail page %d" % goods_id


# 1.自定义转换器
class RegexConverter(BaseConverter):
    # url_map 是路由映射表, regex是转换器传过来的正则表达式
    def __init__(self, url_map, regex):
        # 调用父类的初始化方法
        super().__init__(url_map)
        # 将正则表达式的参数保存到对象的属性中，flask会去使用这个属性来进行路由的正则匹配
        self.regex = regex

    # BaseConverter的方法 to_python的返回值作为视图函数的参数
    # def to_python(self, value):
    #     print("to_python方法被调用")
    #     return "Hello World"


    def to_url(self, value):
        pass

class MobileConverter(BaseConverter):
    def __init__(self, url_map):
        super().__init__(url_map)
        self.regex = r'1[345678]\d{9}'
    
    def to_python(self, value):
        return "Hello World"
    
    def to_url(self, value):
        return "hahahhahaha"


# 2.将自定义的转化器添加到flask的应用中，以键值对的方式保存
app.url_map.converters["re"] = RegexConverter
app.url_map.converters["mobile"] = MobileConverter

# 3.使用自定义的转化器
@app.route("/send/<re(r'1[345678]\d{9}'):mobile>")
def send_sms(mobile):
    return "send sms to %s" % mobile


@app.route("/send2/<mobile:mobile2>")
def send_sms2(mobile2):
    return "send sms to %s" % mobile2

@app.route("/index")
def index():
    url = url_for("send_sms2", mobile2="13545678901")
    return redirect(url)


if __name__ == "__main__":
    print(app.url_map)
    app.run()