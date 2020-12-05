package reactor8;

import java.util.Observable;

public class ObserverTest extends Observable {
    public static void main(String[] args) {
        ObserverTest observer = new ObserverTest();

        // 1. 添加观察者
        observer.addObserver((o, arg) -> {
            System.out.println("发生变化");
        });
        observer.addObserver((o, arg) -> {
            System.out.println("手动被观察者通知，准备改变");
        });

        observer.setChanged(); // 数据变化
        observer.notifyObservers(); // 通知
    }
}
