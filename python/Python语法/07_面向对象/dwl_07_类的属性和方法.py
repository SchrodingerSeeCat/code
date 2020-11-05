class Tool(object):
    # 使用赋值语句定义类属性，记录所有工具对象的数量
    count = 0

    def __init__(self, name):
        self.name = name
        # 通过类名来调用类属性
        Tool.count += 1

    @classmethod
    def show_tool_count(cls):
        # 定义类方法
        print("当前的工具的个数 %d " % cls.count)


tool1 = Tool("斧头")
# 调用类属性
print(Tool.count)
# 调用类方法
Tool.show_tool_count()
