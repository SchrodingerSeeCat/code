import pygame
import screen
pygame.init()


class Game(object):
    """封装游戏的基本操作"""
    def __init__(self):
        # 创建游戏的窗口
        # 创建游戏的时钟
        # 调用私有方法创建精灵和精灵组
        self.screen = pygame.display.set_mode(screen.SCREEN_RECT.size)
        self.clock = pygame.time.Clock()
        # self.__create_sprites()

    def start_game(self):
        # 游戏循环
        while True:
            # 设置刷新率
            self.clock.tick(screen.FRAME_PER_SEC)
            # # 事件监听
            # self.__event_handler()
            # # 碰撞检测
            # self.__check_collide()
            # # 更新/绘制精灵组
            # self.__update_sprites()
            # # 更新显示
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit()
                    exit()
            pygame.display.update()

    @staticmethod
    def game_over(self):
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                exit()


if __name__ == "__main__":
    game = Game()
    game.start_game()
