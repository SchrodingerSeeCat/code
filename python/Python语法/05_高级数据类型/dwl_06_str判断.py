# isspace 判断空白字符,只包含空白字符(\n \r \t)则会返回True
space_str = "   "
print(space_str.isspace())

# 判断字符串中是否只包含数字
# 三个方法都不能判断小数
num_str = "1"
print(num_str.isdecimal())
print(num_str.isdigit())  # 可以判断特殊数字，比如unicode
print(num_str.isnumeric())  # 可以判断汉字数字，比如一千零一