package com.valid.iteratior;

import java.util.Iterator;
import java.util.List;

public class OutPutImpl {
    private List<College<Department>> list;

    public OutPutImpl(List<College<Department>> list) {
        this.list = list;
    }

    // 遍历学院
    public void printCollege() {
        Iterator<College<Department>> iterator = list.iterator();
        while (iterator.hasNext()) {
            College<Department> next = iterator.next();
            System.out.println("===" + next.getName() + "===");
            printDepartment(next.iterator());
        }
    }

    // 学院输出系
    public void printDepartment(Iterator<Department> iterator) {
        System.out.println("---"+ "系" +"---");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }
}
