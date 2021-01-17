'''
    实现基础绘图功能
'''

import matplotlib.pyplot as plt
import random

# 1. 准备数据
x = range(60)
y = [random.uniform(15, 18) for i in x]

# 2.创建画布
plt.figure(figsize=(20, 10), dpi=60)

# 3. 绘制图像
plt.plot(x, y)

# 3.1 添加x，y轴刻度
x_ticks_table = ["11点{}分".format(i) for i in x]
y_ticks = range(40)
# 修改x，y轴坐标刻度显示
plt.xticks(x[::5], x_ticks_table[::5])
plt.yticks(x[::5])


# 4.图像显示
plt.show()