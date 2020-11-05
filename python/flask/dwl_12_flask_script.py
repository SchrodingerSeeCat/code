from flask import Flask
from flask_script import Manager

app = Flask(__name__)

# 创建Manager管理类的对象
manager = Manager(app)

@app.route("/index")
def index():
    print("我是主页")
    return "我是主页"


if __name__ == "__main__":
    # 通过manager启动
    manager.run()