import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.Arrays;

// 模拟鼠标操作
public class Mouse {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();

        // 鼠标移动
        robot.mouseMove(53, 18);

        // 按下鼠标左键
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        // 弹起鼠标左键
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
