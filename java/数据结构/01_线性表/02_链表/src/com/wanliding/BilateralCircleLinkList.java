package com.wanliding;

public class BilateralCircleLinkList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;
    private Node<E> current;  // 用于指向某个节点
    private final int ELEMENT_NOT_FOUND = -1;
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;
        public Node(Node<E> prev, E element, Node<E> next){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
        public String toString(){
            StringBuilder strBu = new StringBuilder();
            if (prev != null) {
                strBu.append(prev.element);
            } else {
                strBu.append("null");
            }
            strBu.append("_").append(element).append("_");
            if (next != null) {
                strBu.append(next.element);
            } else {
                strBu.append("null");
            }
            return strBu.toString();
        }
    }
    // 将current重新指向头节点
    public void reset(){
        current = first;
    }
    // 让current指向下一个元素，并返回下一个元素存储的值
    public E next(){
        if (current == null) {
            return null;
        }
        current = current.next;
        return current.element;
    }
    // 删除current所对应的节点，并将current指向下一个节点
    public E remove(){
        if (current == null) {
            return null;
        }
        Node<E> next = current.next;
        E element = remove(current);
        if (size == 0) {
            current = null;
        } else {
            current = next;
        }
        return element;
    }
    // 删除链表
    public void clear() {
        size = 0;
        first = null;
        last = null;
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
        if (index == size) {
            Node<E> oldNode = last;
            last = new Node<>(oldNode, element, first);
            if (oldNode == null) {
                first = last;
                first.next = first;
                first.prev = first;
            } else {
                oldNode.next = last;
                first.prev = last;
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> newNode = new Node<>(prev, element, next);
            next.prev = newNode;
            prev.next = newNode;
            if (index == 0){ // next == first
                first = newNode;
            }
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
        return remove(node(index));
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
    public int size(){
        return size;
    }
    private E remove(Node<E> node) {
        if(size == 1) {
            first = null;
            last = null;
        } else {
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;
            if (node == first) {
                // 删除的是第一个节点
                first = next;
            }
            if (node == last) {
                // 删除最后一个节点
                last = prev;
            }
        }
        size--;
        return node.element;
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
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++){
                node = node.next;
            }
            return node;
        }
        Node<E> node = last;
        for (int i = size - 1; i > index; i--){
            node = node.prev;
        }
        return node;
    }
    /*
     * Override方法重写
     * 自定义打印格式
     * */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("size = ").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++){
            if (i != 0){
                sb.append(", ");
            }
            sb.append(node);
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
    /*
     * gc root对象
     * 被栈指针指向的对象
     * */
}
