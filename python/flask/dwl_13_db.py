from collections import UserString
from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy import or_
from sqlalchemy import func

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

# 创建模型类
class Role(db.Model):
    """用户表/身份表"""
    __tablename__ = "tbl_roles"
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(32), unique=True)

    # 返回User的对象
    users = db.relationship("User", backref="role")

    def __repr__(self):
        """自定义对象的打印结果"""
        return "Role object: name: %s" % self.name


class User(db.Model):
    """用户表"""
    # 数据库的表名
    __tablename__ = "tbl_user"
    # 表中的字段 类型 约束
    id = db.Column(db.Integer, primary_key=True) # 整型的主键，会默认设置为自增主键
    name = db.Column(db.String(64), unique=True)
    password = db.Column(db.String(64))
    email = db.Column(db.String(32), unique=True)
    role_id = db.Column(db.Integer, db.ForeignKey("tbl_roles.id"))  # 外键
    
    def __repr__(self):
        """自定义对象的打印结果"""
        return "User object: name: %s" % self.name
@app.route("/index")
def index():
    print("我是主页")
    return "我是主页"


if __name__ == "__main__":


    app.run(debug=True)

    # 清除数据库的所有数据
    # db.drop_all()

    # # 创建所有的表
    # db.create_all()


    # # 添加记录
    # # 创建对象
    # role = Role(name="admin")
    # # session 记录对象任务
    # db.session.add(role)
    # # 提交任务到数据库中
    # db.session.commit()

    # role2 = Role(name="stuff")
    # db.session.add(role2)
    # db.session.commit()

    # user1 =User(name="wang", email="123@163.com", password="123456", role_id=role.id)
    # user2 =User(name="jj", email="124556@163.com", password="123456", role_id=role.id)
    # user3 =User(name="kk", email="sdafs@163.com", password="123456", role_id=role2.id)
    # user4 =User(name="ll", email="1jui23@163.com", password="123456", role_id=role2.id)

    # # 一次保存多条数据
    # db.session.add_all([user1, user2, user3, user4])
    # db.session.commit()


    # 查询记录
    #查询所有记录
    # roles = Role.query.all()
    # print(roles[0].name)

    # 查询第一条记录
    # r = Role.query.first()
    # print(r.name)

    # 查询指定主键的值
    # r = Role.query.get(2)
    # print(r.name)

    # 过滤 filter_by
    # users = User.query.filter_by(name="wang").all()
    # user = User.query.filter_by(name="wang", password="123456345").first()

    # 过滤 filter
    # user = User.query.filter(User.name=="wang", User.password=="123456").first()
    # print(user.email)
    # users = User.query.filter(or_(User.name=="wang", User.email.endswith("163.com"))).all()

    # 偏移
    # users = User.query.offset(2).all()
    # print(users[0].email)

    # 限制
    # users = User.query.offset(1).limit(2).all()
    # print(users[0].email)

    # 排序
    # users = User.query.order_by(User.id.desc()).all()
    # print(users[0].email)

    # 分组
    # result = db.session.query(User.role_id, func.count(User.role_id)).group_by(User.role_id).all()
    # print(result)

    # 关联查询
    # ro = Role.query.get(1)
    # print(ro.users)
    # user = User.query.get(1)
    # print(user.role)




    # 修改记录
    # user = User.query.get(1)
    # user.name = "Python"
    # db.session.add(user)
    # db.session.commit()

    # User.query.filter_by(name="jj").update({"name": "666", "password": "7852634"})
    # db.session.commit()

    

    # 删除记录
    # user = User.query.get(1)
    # db.session.delete(user)
    # db.session.commit()