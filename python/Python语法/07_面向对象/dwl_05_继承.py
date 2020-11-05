class Animal:

    def eat(self):
        print("吃")

    def dirnk(self):
        print("喝")

    def run(self):
        print("跑")

    def sleep(self):
        print("睡")


class Dog(Animal):
    # Dog(Animal)表示Dog类继承自Animal
    # 继承，子类拥有父类的所有属性和方法
    # 如果要实行多继承，只需用逗号隔开即可
    # Python中有新式类和旧式类之分，新式类提供有一些内置的属性方法，
    # 推荐如果(Python2.0)自定义的类中没有父类，一律继承自 object
    # Python3 默认类继承自object
    def bark(self):
        print("汪汪")


class XiaoTianQuan(Dog):
    def fly(self):
        print("我能飞")

    def bark(self):
        # 定义和父类相同名字的方法，会重写父类方法
        print("叫的向神一样...")

    def sleep(self):
        # 编写子类特有的功能
        print("哮天犬要睡觉了")

        # 调用父类的方法
        super().sleep()


er_lang_shen = XiaoTianQuan()
er_lang_shen.bark()
er_lang_shen.sleep()



