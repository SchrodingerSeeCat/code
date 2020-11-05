package interfacetest;

public class InterfaceUse {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.transferData(new Flash());
        computer.transferData(new Printer());

        USB phone = new USB() {
            @Override
            public void start() {
                System.out.println("手机开始工作");
            }

            @Override
            public void stop() {
                System.out.println("手机停止工作");
            }
        };
        computer.transferData(phone);
    }
}

class Computer{
    public void transferData(USB usb) {
        usb.start();
        System.out.println("正在传输数据");
        usb.stop();
    }
}

interface USB{
    // 常量：定义了长、宽、最大最小传输速率

    void start();
    void stop();
}

class Flash implements USB{

    @Override
    public void start() {
        System.out.println("U盘开始工作");
    }

    @Override
    public void stop() {
        System.out.println("U盘结束工作");
    }
}

class Printer implements USB{

    @Override
    public void start() {
        System.out.println("打印机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束工作");
    }
}