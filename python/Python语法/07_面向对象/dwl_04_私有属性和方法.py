class Women:
    def __init__(self, name):
        # 在变量 方法前面增加两个下划线，使其成为私有属性，外界不可访问
        # 实际上Python中没有绝对的私有属性和方法，只不过解释器会对有__开头的变量/方法进行特殊
        # 命名处理以__name为例会变成_Women__age
        self.__name = name
        self.__age = 18

    def __secret(self):
        print("%s 的年龄是 %d" % (self.__name, self.__age))


women = Women("小红")
# women.__secret()
# print(women.__name)
