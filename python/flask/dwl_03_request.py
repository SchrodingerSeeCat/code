from flask import Flask, request

app = Flask(__name__)
app.config['JSON_AS_ASCII'] = False

@app.route("/index", methods=["GET", "POST"])
def index():
    # request中包含了前端发送过来的所有请求数据
    # 通过request.form可以直接提取请求体中的表单格式的数据，是一个类字典的对象
    name = request.form.get("name", "匿名用户")
    name_list = request.form.getlist("name")
    age = request.form.get("age", "未知")
    gender = request.args.get("gender", "未知")
    print("request.data %s" % request.data)
    print("Hello %s %s %s" %(name, age, gender))
    return "Hello %s %s %s" %(name, age, gender)



if __name__ == "__main__":
    app.run(debug=True)