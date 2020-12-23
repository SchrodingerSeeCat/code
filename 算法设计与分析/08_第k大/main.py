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
        return "No RESULT"
    mid = findMid(array, begin, end)
    if k < mid:
        return quickSort(array, begin, mid, k)
    elif k > mid:
        return quickSort(array, mid + 1, end, k)

    return array[k]



if __name__ == "__main__":
    num, k = map(int, input().split())
    array = list(map(int, input().split()))
    print(quickSort(array, 0, num, k))