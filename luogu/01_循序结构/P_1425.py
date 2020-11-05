a, b, c, d = map(int,input().split())
hour, minute = 0, 0

if b != 0:
    a = a + 1
    hour = (60 - b + d) // 60

hour = hour + c - a
minute = (60 - b + d) % 60
print(hour, minute)