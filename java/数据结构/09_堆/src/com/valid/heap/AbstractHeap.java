package com.valid.heap;

import java.util.Comparator;

public abstract class AbstractHeap<E> implements Heap<E>{
    protected int size;
    protected Comparator<E> comparator;

    public AbstractHeap(Comparator<E> comparator) {
        this.comparator = comparator;
        this.size = 0;
    }

    public AbstractHeap() {
        this(null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public abstract void clear();

    @Override
    public abstract void add(E element);

    @Override
    public abstract E get();

    @Override
    public abstract E remove();

    @Override
    public abstract E replace(E element);

    // 比较
    protected int compare(E e1, E e2) {
        return comparator != null ?
                comparator.compare(e1, e2) : ((Comparable<E> )e1).compareTo(e2);
    }
}
