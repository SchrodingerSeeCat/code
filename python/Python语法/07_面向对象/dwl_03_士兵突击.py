class Gun:
    def __init__(self, model):
        # 1.枪的型号
        self.model = model
        # 2.子弹的数量
        self.bullet_count = 0

    def add_bullet(self, count):
        # 增加子弹的数量
        self.bullet_count += count
        print("装填了%d的子弹" % count)

    def shoot(self):
        # 1.判断子弹数量
        if self.bullet_count <= 0:
            print("[%s] 没有子弹了。。" % self.model)
            return
        # 2.发射子弹
        self.bullet_count -= 1

        # 3.提示信息
        print("[%s] 突突。。[%d]" % (self.model, self.bullet_count))


class Solider:
    def __init__(self, name):
        # 1.姓名
        self.name = name
        # 2.枪
        # 在Python中对于一个变量，如果在创建时不知道该如何给这个变量赋值，此时可以指定该变量的值为 None
        self.gun = None

    def fire(self):
        # 1.判断士兵是否有枪
        # if self.gun == None:
        # 对于None的判断应该使用is，is判断的是两个变量引用地址是否相等
        # == 判断的是两变量的值是否相等
        if self.gun is None:
            print("[%s]没有枪" % self.name)
            return
        # 2.添加子弹
        self.gun.add_bullet(50)

        # 3.射击
        self.gun.shoot()


xusanduo = Solider("许三多")
AK47 = Gun("AK47")
xusanduo.gun = AK47
xusanduo.fire()
