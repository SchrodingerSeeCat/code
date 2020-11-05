# try:
#     num = int(input())
# except:
#     print("请输入一个整数")


# 捕获指定错误类型的异常
try:
    num = int(input("请输入一个整数："))
    result = 8 / num
    print(result)
# except ZeroDivisionError:
#     print("除数为0")
except ValueError:
    print("请输入正确的整数")
except Exception as res:
    # 捕获未知的错误
    print("未知的错误 %s" % res)
else:
    print("没有异常才会执行的代码")
finally:
    print("有没有异常都会执行的代码")
