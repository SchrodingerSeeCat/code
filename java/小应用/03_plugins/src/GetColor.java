import java.awt.*;

public class GetColor {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();

        // 获取屏幕颜色
        Color color =  robot.getPixelColor(0, 0);
        System.out.println(color);
    }
}
