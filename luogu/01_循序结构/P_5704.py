# ord() 将字符转换为ASCII字符 打印出来为数字
char = ord(input().strip())

# 重新将数字转换为字符
print(chr(char - 32), end = '')