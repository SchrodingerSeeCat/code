package com.wanliding;

public class SingleCircleLinked<E> {
    private int size;
    private Node<E> first;
    private final int ELEMENT_NOT_FOUND = -1;
    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(element).append("_").append(next.element);
            return sb.toString();
        }
    }
    // 删除链表
    public void clear() {
        size = 0;
        first = null;
    }

    // 获取index位置的节点数据
    public E get(int index) {
        return node(index).element;
    }

    // 将index位置的元素设置为element
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    // 添加element到index位置
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {
            Node<E> newFirst = new Node<>(element, first);
            // 拿到最后一个节点
            Node<E> last = (size == 0) ? newFirst : node(size - 1);
            last.next = newFirst;
            first = newFirst;
        } else {
            Node<E> preNode = node(index - 1);
            preNode.next = new Node<>(element, preNode.next);
        }
        size++;
    }

    // 添加元素到链表末尾
    public void add(E element) {
        add(size, element);
    }
    // 删除节点
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) {
            if (size == 1) {
                first = null;
            } else {
                Node<E> last = node(size - 1);
                first = first.next;
                last.next = first;
            }
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = prev.next.next;
        }
        size--;
        return node.element;
    }

    // 查找指定元素的索引
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++){
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    // 返回链表的长度
    public int size(){
        return size;
    }
    // 检查索引的合法性
    private void rangeCheck(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
    }
    private void rangeCheckForAdd(int index) {
        if(index > size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
    }
    // 获取index位置的节点
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }
    /*
     * Override方法重写
     * 自定义打印格式
     * */
    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("size = ").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++){
            if (i != 0){
                string.append(", ");
            }
            string.append(node);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
