from flask import Flask, make_response
# 上传文件
app = Flask(__name__)

# 返回响应头信息
@app.route("/")
def index():
    # 响应体 状态码 响应头
    #　使用元组，返回自定义的响应信息
    # return "index page", 400, [("city", "xinyang"), ("coding", "valid")]

    # 使用字典
    # return "index2 page", 400, {"city": "xinyang", "coding": "valid"}
    
    # 自定义状态码
    # return "index2 page", "666 itcast status", {"city": "xinyang", "coding": "valid"}

    # # 使用make_response来构造响应信息
    # # 响应体
    # resp = make_response("index3 page")
    # # 状态码
    # resp.status = "999 itcast"
    # # 响应头
    # resp.headers["city"] = "xinyang"
    # return resp
    return make_response(
        "index4 page",
        "999 itcast",
        {
            "city": "xinyang",
            "author": "valid"
        }
    )

if __name__ == "__main__":
    app.run(debug=True)