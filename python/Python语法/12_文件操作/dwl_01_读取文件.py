# 1.打开文件
file = open("README")

# 2.读取文件
# read函数默认返回文件的全部内容
text = file.read()
print(text, end="")

# 3.关闭文件
file.close()
