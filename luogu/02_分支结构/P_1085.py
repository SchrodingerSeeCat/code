i = 0
unhappy_time = 0
while i < 7:
    school, tutor = map(int, input().split())
    time = school + tutor
    if time > 8 and time > unhappy_time:
        unhappy = i + 1
        unhappy_time = time
    i += 1
print(unhappy)