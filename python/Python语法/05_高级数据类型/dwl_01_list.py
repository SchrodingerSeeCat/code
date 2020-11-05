test_list = ["zhangsan", "lisi", "wagnwu"]

# index方法 返回元素第一次出现的下标,没有则会报错
print(test_list.index("lisi"))

# append方法 末尾追加
test_list.append("haha")

# insert方法 在指定位置插入
test_list.insert(1, "haohao")

# extend方法 合并列表
temp_list = ["孙悟空", "二师兄"]
test_list.extend(temp_list)

# remove方法 删除第一次出现的指定的数据
test_list.remove("haohao")

# pop方法 无参弹出最后一个元素 有参弹出指定位置的元素
test_list.pop()
test_list.pop(1)

# clear方法 清空整个list
test_list.clear()

# del关键字 删除指定列表的值 del本质上是从内存中将数据删除
test_list.append("haha")
test_list.append("123")
test_list.append("xyu")
del test_list[1]

# count方法 统计一个列表中某一个数据出现的次数
print("xyu出现的次数%d：" % test_list.count("xyu"))

# len函数统计列表的数量
print(len(test_list))
print(test_list)

# sort方法
num_list = [8, 6, 5, 9, 2, 3, 7]
# num_list.sort()  # 升序
# num_list.sort(reverse=True)  # 降序

# reverse方法 反转列表
num_list.reverse()
print(num_list)
