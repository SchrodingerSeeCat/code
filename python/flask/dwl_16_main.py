from flask import Flask
from dwl_16_blue_print import app_blue_print
app = Flask(__name__)

# 注册蓝图
app.register_blueprint(app_blue_print)

if __name__ == "__main__":
    app.run(debug=True) 