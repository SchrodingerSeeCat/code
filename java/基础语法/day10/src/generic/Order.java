package generic;

import java.util.ArrayList;
import java.util.List;

public class Order<E> {
    private String orderName;
    private int orderId;
    private E orderE;

    public Order(){}
    public Order(String orderName, int orderId, E orderE) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderE = orderE;
    }

    public E getOrderE(){
        return orderE;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderE=" + orderE +
                '}';
    }
}

class subClass extends Order<Integer> {

}

class subClass1<E> extends Order<E> {
    int capacity = 10;
    E[] arr = (E[])new Object[capacity];

    // 泛型方法
    public <T> List<T> example(T element){
        return new ArrayList<T>();
    }
}

interface test<E>{
    void show();
}

abstract class Person<E>{
    abstract void show();
}

class Student implements test<Student> {

    @Override
    public void show() {

    }
}

class teacher extends Person<teacher> {

    @Override
    void show() {

    }
}


