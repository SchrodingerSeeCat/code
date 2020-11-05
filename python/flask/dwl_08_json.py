from flask import Flask, jsonify
# 上传文件
app = Flask(__name__)

# 返回响应头信息
@app.route("/")
def index():
    # json就是字符串
    data = {
        "name": "python3",
        "age": 18
    }
    return jsonify(data)


if __name__ == "__main__":
    app.run(debug=True)