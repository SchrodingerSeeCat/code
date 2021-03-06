# 全局变量、函数、类
# 直接执行代码不是向外界提供的工具

# 模块被导入时，能够直接执行的代码不需要被直接执行
def say_hello():
    print("Hello World")


# 如果直接执行模块，则__name__中保存的是 "__main__"
# 如果在导入的模块执行时则是 模块的名字
# 使用__name__判断会避免在别的模块中执行时，测试代码被执行
if __name__ == "__main__":
    print("小明开发的模块")
    say_hello()
