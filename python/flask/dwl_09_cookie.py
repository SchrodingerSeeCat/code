from flask import Flask, make_response
from flask.globals import request
app = Flask(__name__)

@app.route("/set_cookie")
def set_cookie():
    resp = make_response("success")

    # 设置cookie
    resp.set_cookie("Itcast", "Python")
    # 设置cookie的有效期 单位秒
    resp.set_cookie("Itcast2", "Python2", max_age=3600)
    return resp

@app.route("/get_cookie")
def get_cookie():
    return request.cookies.get("Itcast")

@app.route("/delete_cookie")
def delete_cookie():
    resp = make_response("del success")
    resp.delete_cookie("Itcast")
    return resp

if __name__ == "__main__":
    app.run(debug=True)