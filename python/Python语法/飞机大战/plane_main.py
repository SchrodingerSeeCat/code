import pygame
from plane_sprites import *


class PlaneGame(object):
    """飞机大战主游戏类"""
    def __init__(self):
        # 创建游戏的窗口
        # 创建游戏的时钟
        # 调用私有方法创建精灵和精灵组
        self.screen = pygame.display.set_mode(SCREEN_RECT.size)
        self.clock = pygame.time.Clock()
        self.__create_sprites()

        # 设置定时器事件 每1s创建敌机
        pygame.time.set_timer(CREATE_ENEMY_EVENT, 1000)
        pygame.time.set_timer(HERO_FIRE_EVENT, 500)

    def start_game(self):
        # 游戏循环
        while True:
            # 设置刷新率
            self.clock.tick(FRAME_PER_SEC)
            # 事件监听
            self.__event_handler()
            # 碰撞检测
            self.__check_collide()
            # 更新/绘制精灵组
            self.__update_sprites()
            # 更新显示
            pygame.display.update()

    def __create_sprites(self):
        # 创建背景精灵和精灵组
        bg1 = Background()
        bg2 = Background(True)
        self.back_group = pygame.sprite.Group(bg1, bg2)

        # 创建敌机的精灵组
        self.enemy_group = pygame.sprite.Group()

        # 创建英雄
        self.hero = Hero()
        self.hero_group = pygame.sprite.Group(self.hero)

    def __event_handler(self):
        # 事件监听
        for event in pygame.event.get():
            # 判断事件类型是否是退出事件
            if event.type == pygame.QUIT:
                self.__game_over()
            elif event.type == CREATE_ENEMY_EVENT:
                # 创建敌机精灵
                enemy = Enemy()
                self.enemy_group.add(enemy)
            elif event.type == HERO_FIRE_EVENT:
                self.hero.fire()
                # 捕获键盘按键
            # elif event.type == pygame.KEYDOWN and event.type == pygame.K_RIGHT:

            # 键盘模块，如果在按下键盘时，不抬起手指，事件会被一直触发
            keys_pressed = pygame.key.get_pressed()
            if keys_pressed[pygame.K_RIGHT] == 1 or keys_pressed[pygame.K_d] == 1:
                self.hero.speed = 2
            elif keys_pressed[pygame.K_LEFT] == 1 or keys_pressed[pygame.K_a] == 1:
                self.hero.speed = -2
            else:
                self.hero.speed = 0

    def __check_collide(self):
        # 碰撞检测
        # 子弹摧毁敌机 groupcollide 两个精灵组之间的碰撞检测
        pygame.sprite.groupcollide(self.hero.bullet_group, self.enemy_group, True, True)

        # 敌机摧毁英雄 spritecollide 某一个精灵和精灵组之间的碰撞检测 True表示碰撞后销毁精灵组中被碰撞的精灵
        # 返回被碰撞的精灵的列表
        enemies = pygame.sprite.spritecollide(self.hero, self.enemy_group, True)
        if len(enemies) > 0:
            # 让英雄牺牲
            self.hero.kill()
            # 结束游戏
            PlaneGame.__game_over()

    def __update_sprites(self):
        # 更新/绘制精灵组
        # 背景精灵组
        self.back_group.update()
        self.back_group.draw(self.screen)

        # 敌机精灵组
        self.enemy_group.update()
        self.enemy_group.draw(self.screen)

        # 英雄
        self.hero_group.update()
        self.hero_group.draw(self.screen)

        # 子弹精灵组
        self.hero.bullet_group.update()
        self.hero.bullet_group.draw(self.screen)

    @staticmethod
    def __game_over():
        # 游戏结束
        pygame.quit()
        exit()


if __name__ == '__main__':
    # 创建游戏对象
    game = PlaneGame()

    # 游戏启动
    game.start_game()

    input()
