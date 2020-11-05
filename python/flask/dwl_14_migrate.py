from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_script import Manager
from flask_migrate import Migrate, MigrateCommand

class Mysql(object):
    """sqlalchemy的配置信息"""
    # 数据库链接
    SQLALCHEMY_DATABASE_URI = 'mysql+pymysql://root:123456@localhost:3306/test?charset=utf8'
    # 绑定数据库和模型类
    SQLALCHEMY_TRACK_MODIFICATIONS = True
    # 查询时显示原始SQL语句
    # SQLALCHEMY_ECHO = True

app = Flask(__name__)

# 导入数据库配置
app.config.from_object(Mysql)

# 创建数据库sqlalchemy工具对象
db = SQLAlchemy(app)

# 创建flask脚本管理对象
manager = Manager(app)

#创建数据库迁移管理工具
Migrate(app, db)

# 向manager对象中添加数据库的操作指令
manager.add_command("db", MigrateCommand)

# 创建模型类
class Role(db.Model):
    """用户表/身份表"""
    __tablename__ = "tbl_roles"
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(32), unique=True)
    emali = db.Column(db.String(32))
    mobile = db.Column(db.String(32))

    def __repr__(self):
        """自定义对象的打印结果"""
        return "Role object: name: %s" % self.name

@app.route("/index")
def index():
    print("我是主页")
    return "我是主页"


if __name__ == "__main__":

    # 清除数据库的所有数据
    # db.drop_all()

    # 创建所有的表
    db.create_all()

    # 通过manager启动程序
    manager.run()