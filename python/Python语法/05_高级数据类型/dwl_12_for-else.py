for v in [1, 2, 3]:
    print(v)
    if v == 2:
        break
else:
    # 如果for循环的内部使用了break跳出了循环则else的内容不会被执行
    print("我执行了")