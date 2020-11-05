package factory;

public class Main {
    public static void main(String[] args) {
        Car audi = new AudiFactory().getCar();
        Car byd = new BYDFactory().getCar();

    }
}

interface Car{
    void run();
}

interface Factory{
    Car getCar();
}

class AudiFactory implements Factory{
    public Audi getCar(){
        return new Audi();
    }
}

class BYDFactory implements Factory{
    public BYD getCar(){
        return new BYD();
    }
}
class Audi implements Car{
    public void run(){
        System.out.println("奥迪在跑");
    }
}

class BYD implements Car{
    public void run() {
        System.out.println("比亚迪在跑");
    }
}


