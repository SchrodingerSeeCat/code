# 将字符串中的空白字符全部去掉
# 再使用空格拼接成一个整齐的字符串
poem_str = "登鹳雀楼\t王之涣\t白日依山尽\t\n黄河入海流\t\t欲穷千里目\t更上一层楼"

# split 拆分字符串返回一个字符串列表
pome_list = poem_str.split()

# join合并
result = " ".join(pome_list)
print(result)
