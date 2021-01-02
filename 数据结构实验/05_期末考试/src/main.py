def findMid(array, begin, end):
    end -= 1
    temp = array[begin]
    while begin < end:
        while begin < end:
            if array[end] > temp:
                end -= 1
            else:
                array[begin] = array[end]
                begin += 1
                break
        while begin < end:
            if array[begin] < temp:
                begin += 1
            else:
                array[end] = array[begin]
                end -= 1
                break
    array[begin] = temp
    return begin


def quickSort(array, begin, end, k):
    if end - begin < 2:
        return "NO RESULT" 	#没有找到的情况
    mid = findMid(array, begin, end)
    if k < mid:
        return quickSort(array, begin, mid, k) # 小于向左递归
    elif k > mid:
        return quickSort(array, mid + 1, end, k) # 大于向右递归

    return array[k]	#找到的情况直接返回

if __name__ == "__main__":
    num, k = map(int, input().split())
    array = list(map(int, input().split()))
    print(quickSort(array, 0, num - 1, k))