package com.wanliding;
import java.lang.Object;

public class ArrayList<E> {
    java.util.ArrayList<Integer> arr = new java.util.ArrayList<>();
    // 数组的数量
    private int size;
    // 存放元素
    private E[] elements;

    // 默认容量
    private static final int DEFAULT_CAPATICY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    // 数组越界处理
    private void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index：" + index + ", Size：" + size);
    }
    private void rangeCheck(int index){
        if (index < 0 || index >= size){
            outOfBounds(index);
        }
    }
    private void rangeCheckForAdd(int index){
        if (index < 0 || index > size){
            outOfBounds(index);
        }
    }
    // 保证有capacity的容量
    private void ensureCapaticy(int capaticy){
        if (elements.length >= capaticy) {
            return;
        }
        // 扩容数组的容量为原来的1.5倍
        E []newElements = (E[])new Object[elements.length + (elements.length >> 1)];
        for(int i = 0; i < size; i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    // 数组缩容
    // 如果数组的容量过大需要进行容量缩小操作
    // 注意：扩容的倍数乘于缩容的倍数不能等于1，否则会造成复杂度震荡
    private void trim(){
        int newCapacity = elements.length >> 1;
        if (size >= (newCapacity) || size <= DEFAULT_CAPATICY) {
            return;
        }
        E []newElements = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newElements[i] = elements[i];
        }
    }
    public ArrayList(int capaticy){
        if (capaticy < DEFAULT_CAPATICY) {
            capaticy = DEFAULT_CAPATICY;
        }
        elements = (E[])new Object[capaticy];
    }
    public ArrayList(){
        this(DEFAULT_CAPATICY);
    }
    /*
    * 清除所有元素
    * */
    public void clear(){
        // 将数组置空再重新创建比较浪费性能
        for(int i = 0; i < size; i++){
            elements[i] = null;
        }
        trim();
        size = 0;
    }
    /*
    * 返回元素的数量
    * */
    public int size(){
        return size;
    }
    /*
    * 判断是否为空
    * */
    public boolean isEmpty(){
        return size == 0;
    }
    /*
    * 返回指定索引的元素
    * */
    public E get(int index){
        rangeCheck(index);
        return elements[index];
    }
    /*
    * 修改指定索引的值
    * */
    public E set(int index, E element){
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }
    /*
    * 查找指定元素的索引
    * */
    public int indexOf(E element){
        if (element == null){
            for(int i = 0; i < size; i++){
                if (elements[i] == null){
                    return i;
                }
            }
        } else {
            for(int i = 0; i < size; i++){
                if (element.equals(elements[i])){
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }
    /*
    * 是否包含某个元素
    * */
    public boolean contains(E element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /*
    * Override方法重写
    * 自定义打印格式
    * */
    public String toString(){
        // size = 3,[1, 2, 3]
        StringBuilder string = new StringBuilder();
        string.append("size = ").append(size).append(", [");
        for (int i = 0; i < size; i++){
            if (i != 0){
                string.append(", ");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
    /*
    * 添加元素
    * */
    public void add(E element){
        add(size, element);
    }
    /*
    * 添加指定元素到指定索引
    * */
    public void add(int index, E element){
        rangeCheckForAdd(index);
        ensureCapaticy(size + 1);
        for (int i = size - 1; i >= index; i--){
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }
    /*
    * 删除指定索引的数据
    * @return 删除元素的值
    * */
    public E remove(int index){
        rangeCheck(index);
        E element = elements[index];
        while(index < size) {
            elements[index] = elements[++index];
        }
        elements[--size] = null;
        trim();
        return element;
    }
    /*
    * 删除指定的元素的值
    * 返回删除元素的索引
    * */
    public int remove(E element){
        int index = indexOf(element);
        remove(index);
        return index;
    }
}
