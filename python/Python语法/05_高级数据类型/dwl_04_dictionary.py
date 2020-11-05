# 字典是一个无序的数据集合
xiaoming = {
    "name": "小明",
    "gender": "男",
    "age": 18
}

# 取值 如果key不存在则会报错
print(xiaoming["name"])

# 修改
xiaoming["age"] = 20

# 增加
xiaoming["hobby"] = "写代码"

# 删除 不存在的key则会报错
xiaoming.pop("gender")

# len函数 统计键值对的数量
print(len(xiaoming))

# update方法 合并字典
# 如果合并的字典中含有与原字典中相同的key则会覆盖
temp_dic = {
    "height": 1.75
}
xiaoming.update(temp_dic)

# clear方法 清空字典
# xiaoming.clear()
print(xiaoming)

# 遍历
for key in xiaoming:
    print(xiaoming[key])