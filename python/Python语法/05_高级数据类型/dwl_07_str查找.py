hello_str = "hello world"

# 判断是否以指定字符串开始
print(hello_str.startswith("hello"))

# 判断是否以指定字符串结束
print(hello_str.endswith("world"))

# 查找指定字符串和index方法类似，当查找不存在的字符串时会返回-1
print(hello_str.find("a"))

# 替换字符串,replace方法会返回替换之后的新字符串，不会修改原字符串
print(hello_str.replace("o", "ppp"))