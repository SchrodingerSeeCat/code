import pygame
from plane_sprites import *

pygame.init()

# 创建游戏的主窗口 480 * 700
screen = pygame.display.set_mode((480, 700))

# 绘制背景图
# 1.加载图像数据
bg = pygame.image.load("./images/background.png")
# 2.blit 绘制图像 第一个参数接受一个已加载的图像对象，第二个参数表示绘制图像的位置
screen.blit(bg, (0, 0))

# 绘制英雄的飞机
hero = pygame.image.load("./images/me1.png")
screen.blit(hero, (189, 574))

# 在所有的图像绘制之后统一更新
# 3.update 更新屏幕的显示
pygame.display.update()

# 创建时钟对象
clock = pygame.time.Clock()

# 1> 定义一个Rect对象记录飞机的初始位置
hero_rect = pygame.Rect(150, 300, 102, 126)

# 创建敌机的精灵
enemy = GameSprite("./images/enemy1.png")
enemy1 = GameSprite("./images/enemy1.png", 2)
# 创建敌机的精灵组
enemy_Group = pygame.sprite.Group(enemy, enemy1)

# 游戏循环 ->游戏的开始
while True:
    # 设置游戏时钟(帧率) 指定游戏循环内部执行的频率
    clock.tick(60)

    for event in pygame.event.get():
        # 判断事件类型是否是退出事件
        if event.type == pygame.QUIT:
            pygame.quit()
            # 直接退出游戏
            exit()

    # 2> 修改飞机的位置
    if hero_rect.y > 0:
        hero_rect.y -= 1
    else:
        hero_rect.y = 700
    # 3> 调用blit方法绘制图像
    # 在飞机重新绘制之前重新绘制背景，覆盖之前飞机的图像
    screen.blit(bg, (0, 0))
    screen.blit(hero, hero_rect)

    # 让精灵组调用两个方法
    # update 让组中的所有精灵更新位置
    enemy_Group.update()
    # draw 在screen上绘制所有精灵
    enemy_Group.draw(screen)

    # 4> 调用update方法更新显示
    pygame.display.update()

    # 捕获事件 返回当前这一时刻所有的事件列表
    even_list = pygame.event.get()
    # print(even_list)
