# eval函数可以将字符串解析为Python的执行语句并返回结果
# 基本的数学运算
print(eval("1 + 1"))

# 字符串重复
print(eval('"*" * 50'))

# 将字符串转换为列表
print(type(eval("[1, 2, 3, 4]")))

# 将字符串转换为字典
print(type(eval("{'name': '小明', 'age': 18}")))
