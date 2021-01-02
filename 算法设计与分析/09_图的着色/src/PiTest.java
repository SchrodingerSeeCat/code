import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PiTest extends JFrame {
    JLabel jl1 = new JLabel("输入半径");
    JTextField jf1 = new JTextField(15);

    JLabel jl2 = new JLabel("计算结果");
    JTextField jf2 = new JTextField(15);

    JButton btn = new JButton("计算圆面积");
    public PiTest() {
        // 设置布局方式
        this.setLayout(new FlowLayout());

        // 添加输入框和JLabel
        this.add(jl1);
        this.add(jf1);

        this.add(jl2);
        this.add(jf2);

        // 添加按钮
        this.add(btn);

        // 添加计算圆面积的事件
        btn.addActionListener(e -> {
            double r = Double.parseDouble(jf1.getText());
            double area = Math.PI * r * r;
            jf2.setText(area + "");

            save(area);
        });
        this.setSize(250, 150);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 保存到磁盘
    public void save(double area) {
        OutputStream out = null;
        try {
            out = new FileOutputStream("save.dat");
            out.write((area + "").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class Test{
    public static void main(String[] args) {
        new PiTest();
    }
}
