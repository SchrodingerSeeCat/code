def demo(num, *args, **kwargs):
    """
    :param num:
    :param args: 一个 * 可以接受元组类型的参数
    :param kwargs: 两个 ** 可以接受字典类型的参数
    :return:
    """
    print(num)
    print(args)
    print(kwargs)


demo(1)
demo(1, 2, 3, 4)
demo(1, 2, 3, name="小明")
