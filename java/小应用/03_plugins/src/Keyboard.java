import java.awt.*;
import java.awt.event.KeyEvent;

/*
* 模拟键盘操作
* */
public class Keyboard {
    public static void main(String[] args) throws AWTException {

        // 创建一个Robot对象
        Robot robot = new Robot();

        // 延时5s执行
        robot.delay(5000);

        // 模拟键盘按下K键
        robot.keyPress(KeyEvent.VK_K);
        // 用户按下和弹起是需要时间的
        robot.delay(300);
        // 弹起K键
        robot.keyRelease(KeyEvent.VK_K);
    }
}
