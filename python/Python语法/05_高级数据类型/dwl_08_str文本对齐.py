# 顺序并且居中对其输出以下内容
poem = [
    "登鹳雀楼",
    "王之涣",
    "白日依山尽",
    "黄河入海流",
    "欲穷千里目",
    "更上一层楼"
]
# ljust 左对齐
# center 居中对齐
# rjust 右对齐
for pome_str in poem:
    print("|%s|" % pome_str.center(10, "　"))