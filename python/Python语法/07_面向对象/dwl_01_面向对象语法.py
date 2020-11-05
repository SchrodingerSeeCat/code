class Cat:

    def __init__(self, name="小猫", age=0):
        # 自定义属性
        self.name = name
        self.age = age
        print("构造函数")

    def eat(self):
        print("%s爱吃鱼" % self.name)

    def drink(self):
        print("%s爱喝水" % self.name)

    def get_age(self):
        print("%s %d岁了" % (self.name, self.age))

    def __del__(self):
        """析构函数"""
        print("对象销毁")

    def __str__(self):
        """重写print函数"""
        return self.name + "__str__"


# 创建对象 变量名 = 类名()
tom = Cat(name="小花猫")
tom.eat()
tom.drink()
tom = Cat(age=12)
tom.get_age()
print(tom)