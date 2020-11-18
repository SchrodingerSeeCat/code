sum = int(input())
money = 0
if sum <= 150:
    money = sum * 0.4463
elif sum > 150 and sum <= 400:
    money = 150 * 0.4463 + (sum - 150) * 0.4663
else:
    money = 150 * 0.4463 + 250 * 0.4663 + (sum - 400) * 0.5663
print("%.1f" % money)