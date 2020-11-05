list_1 = [1, 2]
list_2 = [3, 4]
# * 重复添加 字典不可重复
print(list_1 * 5)

# + 拼接 不支持字典
print(list_1 + list_2)

# in 判断元素是否在列表中 支持字典
print(1 in list_1)

# not in 判断元素是否不在列表中 支持字典
print(6 in list_1)