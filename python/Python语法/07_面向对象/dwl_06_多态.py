class Dog(object):
    def __init__(self, name="流浪狗"):
        self.name = name

    def game(self):
        print("%s 自己玩耍" % self.name)


class XiaoTianQuan(Dog):
    def game(self):
        print("%s 飞到天上去玩耍" % self.name)


class Person(object):
    def __init__(self, name="无名氏"):
        self.name = name

    def game_with_dog(self, dog):
        print("%s 和 %s 玩耍.." % (self.name, dog.name))

        # 让狗玩耍
        dog.game()


wangcai = Dog("旺财")
xiaoming = Person("小明")
xiaoming.game_with_dog(wangcai)

dahuang = XiaoTianQuan("大黄")
xiaoming.game_with_dog(dahuang)




