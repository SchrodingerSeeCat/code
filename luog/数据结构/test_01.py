def partition(a, left, right):
    temp = a[left]
    while left < right:
        while (left < right) & (a[right] > temp):
            right = right - 1
        a[left] = a[right]
        while (left < right) & (a[left] < temp):
            left = left + 1
        a[right] = a[left]
    a[left] = temp
    return left


def quicksort(a, left, right):
    if left < right:
        post = partition(a, left, right)
        quicksort(a, left, post - 1)
        quicksort(a, post + 1, right)


num = input()
a = input()
a = [int(n) for n in a.split()]
quicksort(a, 0, len(a)-1)
for i in range(len(a)):
    print(a[i],end="")