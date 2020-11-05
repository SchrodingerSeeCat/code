# 如果一个类的方法
# 既不需要访问实例属性或者调用实例方法
# 也不需要访问类属性或者调用类方法
class Dog(object):
    # 静态方法不需要传入参数self
    @staticmethod
    def run():
        print("跑")


# 通过类名来调用静态方法
Dog.run()
