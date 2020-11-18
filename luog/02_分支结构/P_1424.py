x, n = map(int, input().split())
kilo = 0
if x > 5:
    kilo = (n - 8 + x) // 7 * 5
else:
    kilo = ((6 - x) + (n - 8 + x) // 7 * 5)
if (n - 8 + x) % 7 > 5:
    kilo = kilo + 5
else:
    kilo = kilo + (n - 8 + x) % 7
print(kilo * 250)