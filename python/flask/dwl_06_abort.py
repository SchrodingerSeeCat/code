from flask import Flask, request, abort, Response
# 上传文件
app = Flask(__name__)

@app.route("/login", methods=["GET"])
def upload():
    username = ""
    password = ""
    if username != "zhangsan" or password != "admin":
        # 传递状态码信息，必须是标准的状态码
        # abort(400)

        # 传送响应体信息
        res = Response("login falied")
        abort(res)
    else:
        return "success"

@app.errorhandler(404)
def handle_404_error(err):
    """自定义的处理错误的方法"""
    return "你访问的页面不存在 %s" % err


if __name__ == "__main__":
    app.run(debug=True)