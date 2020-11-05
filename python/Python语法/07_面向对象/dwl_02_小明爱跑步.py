class Person:

    def __init__(self, name, weight):
        self.name = name
        self.weight = weight

    def __str__(self):
        return "我的名字" + self.name + "体重" + str(self.weight)

    def run(self):
        print("%s爱跑步,跑步锻炼身体" % self.name)
        self.weight -= 0.5

    def eat(self):
        print("%s是吃货" % self.name)
        self.weight += 1


xiao_ming = Person("小明", 75)
print(xiao_ming)
xiao_ming.run()
xiao_ming.eat()
