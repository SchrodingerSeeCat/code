# 根据规范，全局变量尽量声明为g_变量名
g_num = 10


def demo():
    # 使用global关键字将num声明为全局变量，否则将会创建一个局部变量
    global g_num
    g_num = 99
    print("修改局部变量的值为 %d" % g_num)


demo()
print("全局变量的值为 %d" % g_num)
