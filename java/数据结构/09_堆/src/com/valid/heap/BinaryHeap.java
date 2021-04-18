package com.valid.heap;

import java.util.Comparator;

public class BinaryHeap<E> extends AbstractHeap<E>{

    private E[] elements; // 存储元素
    private static final int DEFAULT_CAPACITY = 10; // 默认容量

    public BinaryHeap(Comparator<E> comparator) {
        this(null, comparator);
    }

    public BinaryHeap(E [] elements) {
        this(elements, null);
    }

    public BinaryHeap() {
        this(null, null);
    }

    public BinaryHeap(E []elements, Comparator<E> comparator) {
        super(comparator);
        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            // 保存数组
            this.elements = (E[]) new Object[Math.max(elements.length, DEFAULT_CAPACITY)];
            for(int i = 0; i < elements.length; i++) {
                this.elements[i] = elements[i];
            }
            size = elements.length;

            heapify();
        }
    }

    // 批量建堆
    private void heapify() {
        // 自下而上的下滤
        for(int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    @Override
    public void clear() {
        // 清空元素
        for(int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        // 检查元素是否为空, 二叉堆不允许插入null值
        elementNotNullCheck(element);
        // 检查数组容量
        ensureCapacity(size + 1);
        elements[size++] = element;
        siftUp(size - 1);
    }

    // 上滤
    private void siftUp(int index) {
        E element = elements[index];
        while(index > 0) {
            int parent = (index - 1) >> 1;

            // 小于父节点无需上滤
            if (compare(elements[parent], element) >= 0) break;

            // 将父元素放在index的位置
            elements[index] = elements[parent];
            index = parent;
        }
        // 将要添加的元素放在指定的位置
        elements[index] = element;
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    // 删除堆顶的元素
    @Override
    public E remove() {
        emptyCheck();

        E root = elements[0];
        elements[0] = elements[size - 1];
        elements[--size] = null;

        siftDown(0);
        return root;
    }

    private void siftDown(int index) {
        E element = elements[index];

        int half = size >> 1; // 非叶子节点的个数
        // 第一个叶子节点的索引 == 非叶子节点的个数
        // index应该是非叶子节点
        while (index < half) {
            // index 的节点有2种情况
            // 1. 只有左子节点
            // 2. 同时有左右子节点
            int child  = (index << 1) + 1; // 默认为左子节点

            // 选出最大子节点
            if (child + 1 < size && compare(elements[child], elements[child + 1]) < 0) {
                child++;
            }

            if (compare(element, elements[child]) >= 0) break; // 如果比子节点大，结束循环

            // 将子节点存放到index
            elements[index] = elements[child];
            // 重新设置index
            index = child;
        }
        elements[index] = element;
    }

    // 删除堆顶元素并插入一个元素
    @Override
    public E replace(E element) {
        elementNotNullCheck(element);

        E root = null;
        if (size != 0) {
            root = elements[0];
            elements[0] = element;
            siftDown(0);
        } else {
            elements[size++] = element;
        }
        return root;
    }

    // 检查heap是否为空
    private void emptyCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
    }

    // 检查元素是否为空
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Element is not null");
        }
    }

    // 数组扩容
    private void ensureCapacity(int capacity){
        if (elements.length >= capacity) {
            return;
        }
        // 扩容数组的容量为原来的1.5倍
        E []newElements = (E[])new Object[elements.length + (elements.length >> 1)];
        for(int i = 0; i < size; i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        for(int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
}
