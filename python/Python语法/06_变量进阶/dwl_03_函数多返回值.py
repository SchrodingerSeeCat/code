def measure():
    """测量温度和湿度"""
    print("测量开始。。。")
    temp = 39
    wetness = 50
    print("测量结束。。。")
    # 函数返回多个值,以元组的形式返回
    return temp, wetness


# 函数返回的数据到一个元组变量中
result = measure()
print(result)

# 可以使用多个变量接受
g_temp, g_wetness = measure()
print(g_temp, g_wetness)