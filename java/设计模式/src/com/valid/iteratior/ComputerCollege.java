package com.valid.iteratior;

import java.util.Iterator;

public class ComputerCollege implements College<Department>{

    private final Department[] departments;
    private int size = 0; // 数组当前对象的个数

    public ComputerCollege() {
        departments = new Department[5];
        addDepartment("Java", "Java专业");
        addDepartment("PHP", "PHP专业");
        addDepartment("Python", "Python专业");
        addDepartment("前端", "JavaScript专业");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        departments[size++] = new Department(name, desc);
    }

    @Override
    public Iterator<Department> iterator() {
        return new ComputerCollegeIterator(departments);
    }
}
