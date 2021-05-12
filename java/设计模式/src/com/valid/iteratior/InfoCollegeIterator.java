package com.valid.iteratior;

import java.util.Iterator;
import java.util.List;

public class InfoCollegeIterator implements Iterator<Department> {
    private final List<Department> departments;
    private int position = -1;

    public InfoCollegeIterator(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        return position < departments.size() - 1;
    }

    @Override
    public Department next() {
        return departments.get(++position);
    }

    @Override
    public void remove() {

    }
}
