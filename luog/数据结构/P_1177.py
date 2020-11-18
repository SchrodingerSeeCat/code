def pivotIndex(num, begin, end):
    """
    确定轴点的位置
    :param begin: 开始位置
    :param end:  结束位置
    :return: 轴点的位置
    """
    temp = num[begin]
    end -= 1
    while begin < end:
        while begin < end:
            if temp < num[end]:
                end -= 1
            else:
                num[begin] = num[end]
                begin += 1
                break

        while begin < end:
            if temp > num[begin]:
                begin += 1
            else:
                num[end] = num[begin]
                end -= 1
                break
    num[begin] = temp
    return begin


def sort(num, begin, end):
    """
    对于[begin,end)范围内的元素排序
    :param begin: 排序起始位置(包含)
    :param end: 排序结束位置(不包含)
    :return:
    """
    # 元素数量小于2没有必要排序
    if (end - begin) < 2:
        return

    # 确定轴点的位置
    mid = pivotIndex(num, begin, end)

    # 对子序列进行排序
    sort(num, begin, mid)
    sort(num, mid + 1, end)


n = int(input())
num = []
num.extend(map(int, input().split()))

sort(num, 0, n)

for v in num:
    print(v, end=" ")

