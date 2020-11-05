import math
m, h = map(float, input().split())
BMI = m / (h ** 2)
if BMI < 18.5:
    print("Underweight")
elif BMI >= 18.5 and BMI < 24:
    print("Normal")
else:
    BMI = format(BMI, ".4f")
    B = str(BMI).strip("0")[:7]
    if B[len(B) - 1] == ".":
        B = B + "0"
    print(B)
    print("Overweight")