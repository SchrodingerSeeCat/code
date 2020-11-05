# 实际情况中定义字符串使用双引号，如果字符串中含有双引号的则使用单引号定义
str = 'Hello "Python"'
print(str)

# len函数 统计字符串长度
print(len(str))

# count方法 统计指定字符串在在原字符串中出现的次数
print(str.count("o"))

# index方法 某一个字符串第一次出现的位置
# 如果这个字符串不存在的话则会报错
print(str.index("o"))