# Python的数据类型
# Python中定义变量不需要指定变量的类型
# 程序运行时Python的计时器会根据复制语句等号右侧的数据自动推断类型
"""
姓名：小明
年龄：18
性别：是男
身高：1.75m
体重：75.0公斤
"""

# 字符串 str
name = "小明"

# 整型 int
age = 18

# 真假 bool 取值 True/False
gender = True

# 浮点型 float
height = 1.75
weight = 75.0

# type(变量名) 查看变量的类型
print(type(height))  # <class 'float'>

# python2 中整型之中除int之外还有long

# Python 之中字符串可以拼接
first_name = "三"
last_name = "张"
print(first_name + last_name)
