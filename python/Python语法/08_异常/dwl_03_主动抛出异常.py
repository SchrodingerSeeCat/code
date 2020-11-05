# Exception 异常类
# 创建一个Exception的对象
# 使用raise关键字抛出异常对象
def input_password():
    password = input("请输入密码：")
    if len(password) >= 8:
        return password
    # 密码小于8主动抛出异常
    else:
        # 创建异常对象,可以使用错误信息字符串作为参数
        exception = Exception("密码小于八位")

        # 主动抛出异常
        raise exception


try:
    print(input_password())
except Exception as result:
    print(result)
