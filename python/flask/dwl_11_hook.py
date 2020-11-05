from flask import Flask, request, url_for
# hook

app = Flask(__name__)

@app.route("/index")
def index():
    print("我是主页")
    return "我是主页"

# 定义钩子
@app.before_first_request
def handle_before_first_request():
    print("第一次请求之前被执行")

@app.before_request
def handle_before_request():
    print("每次请求之前都被执行")

@app.after_request
def handle_after_request(response):
    print("每次请求之后都被执行， 视图函数没有出现异常")
    if request.path == url_for("index"):
        print("处理主页的逻辑")
    else:
        print("处理非主页的逻辑")
    return response

@app.teardown_request
def handle_teardown_request(response):
    print("每次请求之前都被执行， 无论视图函数是否出现异常都会执行")
    return response

if __name__ == "__main__":
    app.run()