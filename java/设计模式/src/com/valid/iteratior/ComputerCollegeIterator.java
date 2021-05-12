package com.valid.iteratior;

import java.util.Iterator;

public class ComputerCollegeIterator implements Iterator<Department> {
    private final Department[] departments;
    private int position = 0; // 遍历的位置

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < departments.length && departments[position] != null;
    }

    @Override
    public Department next() {
        return departments[position++];
    }

    @Override
    public void remove() {
    }
}
