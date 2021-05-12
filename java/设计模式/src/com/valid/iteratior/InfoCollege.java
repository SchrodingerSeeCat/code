package com.valid.iteratior;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class InfoCollege implements College<Department>{
    private final List<Department> departments;

    public InfoCollege() {
        departments = new LinkedList<>();
        addDepartment("信息安全", "信息安全专业");
        addDepartment("网络安全", "网络安全专业");
        addDepartment("服务器安全", "服务器安全专业");
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        departments.add(new Department(name, desc));
    }

    @Override
    public Iterator<Department> iterator() {
        return new InfoCollegeIterator(departments);
    }
}
