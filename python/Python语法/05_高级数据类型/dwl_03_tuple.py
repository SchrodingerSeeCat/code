# 元组，和列表相似
# 元组一旦定义数据不可更改
info_tuple = ("hah", "list", "problem")

# 空元组
empty_tuple = ()

# 只有一个元素的元组
single_tuple = (4,)

# count方法 统计指定元素出现的次数
print(info_tuple.count("problem"))

# index方法 返回指定元素第一次出现的下标
print(info_tuple.index("list"))

# 格式化字符串后面的 %()本质上是元组
print("%s %s %s" % info_tuple)

info_str = "%s 我是元组 %s %s" % info_tuple
print(info_str)

