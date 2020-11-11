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


def quickSort(array, begin, end):
    if end - begin < 2:
        return
    mid = findMid(array, begin, end)
    quickSort(array, begin, mid)
    quickSort(array, mid + 1, end)
    



if __name__ == "__main__":
    num = int(input())
    array = list(map(int, input().split()))
    quickSort(array, 0, num)
    i = 0
    while i < num:
        print(array[i], end=" ")
        i += 1
    print()