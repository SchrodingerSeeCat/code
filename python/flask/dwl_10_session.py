from flask import Flask, session
# session

app = Flask(__name__)
app.config["SECRET_KEY"] = "MY_SECRET"
@app.route("/login")
def login():
    # 设置session数据
    session["name"] = "python"
    session["mobile"] = "17611111111"
    return "login success"

@app.route("/index")
def index():
    name = session.get("name")
    return "hello %s" % name


if __name__ == "__main__":
    app.run(debug=True)