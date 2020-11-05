def demo(*args, **kwargs):
    print(args)
    print(kwargs)


# 当需要把元组/字典直接传递到函数内部时就需要拆包
g_nums = (1, 2, 3)
g_dict = {"name": "小明", "age": 18}
demo(g_nums, g_dict)
demo(*g_nums, **g_dict)
