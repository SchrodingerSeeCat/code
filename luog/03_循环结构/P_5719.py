n, k = map(int, input().split())
A = 0
B = 0
i = 1
count_a = 0
count_b = 0
while i <= n:
    if i % k == 0:
        A += i
        count_a += 1
    else:
        B += i
        count_b += 1
    i += 1
print("%.1f %.1f" % ((A / count_a), (B /count_b)))