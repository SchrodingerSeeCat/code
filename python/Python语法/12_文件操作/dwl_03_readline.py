# readline方法一次读取一行内容
# 方法执行后会把文件指针移动到下一行，准备再次读取
file = open("README")
while True:
    text = file.readline()
    # 判断是否读取到了内容
    if not text:
        break
    print(text, end="")
file.close()
