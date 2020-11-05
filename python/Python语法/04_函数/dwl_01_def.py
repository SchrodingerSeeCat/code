# 函数定义的上方保持两个空行


def multiple_table():
    """函数注释 九九乘法表"""
    i, j = 1, 1
    while i <= 9:
        j = 1
        while j <= i:
            print("%d*%d=%d\t" %(j, i, i * j), end = '')
            j = j + 1
        print()
        i = i + 1


def sum(num1, num2):
    """ 求两数之和

    :param num1: 参数1
    :param num2: 参数2
    :return: 两数之和
    """
    return num1 + num2
