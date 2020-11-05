a, b, c = map(int, input().split())
if a < b and b > c:
    b, c = c, b
elif a > b and b < c:
    a, c = c, a
    a, b = b, a
elif a > b and b > c:
    a, c = c, a
i = 2
while i <= a:
    if a % i == 0 and c % i == 0:
        a = a // i
        c = c // i
    i += 1
print("%d/%d" % (a, c))