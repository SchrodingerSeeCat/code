//public class CarFactoryTest {
//    public static void main(String[] args) {
//        Car audi = CarFactory.getCar("奥迪");
//        Car byd = CarFactory.getCar("比亚迪");
//
//    }
//}
//
//interface Car{
//    void run();
//}
//
//class Audi implements Car{
//    public void run(){
//        System.out.println("奥迪在跑");
//    }
//}
//
//class BYD implements Car{
//    @Override
//    public void run() {
//        System.out.println("比亚迪在跑");
//    }
//}
//
//class CarFactory{
//    public static Car getCar(String type){
//        if("奥迪".equals(type)) return new Audi();
//        if("比亚迪".equals(type)) return new BYD();
//
//        return null;
//    }
//}
