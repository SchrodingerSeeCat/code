import math


def problem_1():
    """问题1"""
    print("I love Luogu!")


def problem_2():
    """问题2"""
    print("6 4")


def problem_3():
    """问题三"""
    print(14//4)
    print(14//4 * 4)
    print(14%4)


def problem_4():
    """问题四"""
    print("%.3f" % (500 / 3))


def problem_5():
    """问题五"""
    print(15)


def problem_6():
    """问题六"""
    print("%.4f" % math.sqrt(6 * 6 + 9 * 9))


def problem_7():
    """问题七"""
    money = 100
    money += 10
    print(money)

    money -= 20
    print(money)

    money -= money
    print(money)


def problem_8():
    """问题八"""
    r = 5.0
    pi = 3.141593
    # 周长
    print("%.4f" % (2 * pi * r))

    # 面积
    print("%.4f" % (pi * r * r))

    # 体积
    print("%.3f" % (4/3 * pi * r ** 3))


def problem_9():
    """问题九"""
    i = 0
    su = 1
    while i < 3:
        su = (su + 1) * 2
        i = i + 1
    print(su)


def problem_10():
    """
    设初始队列为x，单位时间增加的题数为y，10分钟完成设有z台机器
    (8 * 30)/(x + 30y) = (6 * 10)/(x + 6y) = (10 * z)/(x + 10y)
    以前两个等式求出 x = 2y
    以后两个等式求出 z = 9
    """
    print(9)


def problem_11():
    print("%.4f" % (100 / 3))


def problem_12():
    print(13)
    print("R")


def problem_13():
    l = math.pow(((4/3) * 3.141593 * (4 ** 3 + 10 ** 3)), 1/3)
    print("%.0f" % l)


def problem_14():
    print(50)


num = input()
if num == "1":
    problem_1()
elif num == "2":
    problem_2()
elif num == "3":
    problem_3()
elif num == "4":
    problem_4()
elif num == "5":
    problem_5()
elif num == "6":
    problem_6()
elif num == "7":
    problem_7()
elif num == "8":
    problem_8()
elif num == "9":
    problem_9()
elif num == "10":
    problem_10()
elif num == "11":
    problem_11()
elif num == "12":
    problem_12()
elif num == "13":
    problem_13()
else:
    problem_14()