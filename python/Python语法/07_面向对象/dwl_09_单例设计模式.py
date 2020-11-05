# 单例设计模式 保证在创建的对象中永远只有一个实例
# __new__ 在内存中为对象分配内存空间 返回对象的引用
# 解释器获得对象的引用后，将引用作为第一个参数，传递给__init__方法
# 重写new方法一定要 return supper().__new__(cls)
class MusicPlayer(object):
    # 保存实例的引用
    instance = None
    # 确保init方法只会执行一次
    init_flag = False

    def __new__(cls, *args, **kwargs):
        # 创建对象时new方法会被自动调用
        print("创建对象分配空间")

        # 为对象分配空间,先判断是否存在类的实例
        if cls.instance is None:
            cls.instance = super().__new__(cls)
            cls.init_flag = True
        # 返回对象的引用
        return cls.instance
        
    def __init__(self):
        if MusicPlayer.init_flag:
            return
        print("播放器初始化...")


player1 = MusicPlayer()
player2 = MusicPlayer()
print(id(player1))
print(id(player2))

