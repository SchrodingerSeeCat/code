# 与and 或or 非not

# 要求人的年龄在0-120之间
age = int(input("请输入年龄age: "))
if age >= 0 and age <= 120:
    print("是人类")
else:
    print("不是人类")

# 要求两个成绩只要有一个>60就合格
python_score = int(input("请输入python_score: "))
c_socre = int(input("请输入c_score: "))
if python_score > 60 or c_socre > 60:
    print("合格")
else:
    print("不合格")

# 判断不是本公司员工禁止入内
is_employee = True
if not is_employee:
    print("禁止入内")
else:
    print("可以入内")