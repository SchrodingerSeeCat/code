# 异常的传递
# 当函数/方法执行出现异常时，会将异常传递给函数/方法的调用一方
# 如果异常传递给主程序时，仍然没有异常处理，程序才会终止
# 在开发中推荐只在主程序中增加异常捕获的语句
def demo1():
    return int(input("请输入一个整数："))


def demo2():
    return demo1()


try:
    print(demo2())
except:
    print("程序出错")
