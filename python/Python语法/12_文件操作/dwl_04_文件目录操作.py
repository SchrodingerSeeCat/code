import os
# 文件和目录的操作都支持 相对路径 和 绝对路径
# 文件重命名 源文件名 目标文件名
try:
    os.rename("test.txt", "rename.txt")
except Exception as result:
    print("此文件不存在或已重命名")

# 文件删除
try:
    os.remove("rename.txt")
except Exception as result:
    print("此文件不存在或已删除")

# 查看目录信息返回一个列表 . 表示查看当前目录信息
dirs = os.listdir(".")
for value in dirs:
    if os.path.isdir(value):
        print("%s 是文件夹" % value)
    else:
        print("%s 是文件" % value)
# 创建目录
os.mkdir("dir")
# 删除目录
os.rmdir("dir")
