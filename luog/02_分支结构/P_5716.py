year, month = map(int, input().split())
array = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
if month == 2:
    if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0):
        array[1] += 1
print(array[month - 1])