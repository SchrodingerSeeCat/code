package list;

public class BilateralLinkList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;
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
    // 删除链表
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }
    // 返回链表长度
    public int size() {
        return size;
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
            last = new Node<>(oldNode, element, null);
            if (oldNode == null) {
                first = last;
            } else {
                oldNode.next = last;
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> newNode = new Node<>(prev, element, next);
            next.prev = newNode;
            if (prev == null){
                first = newNode;
            } else {
                prev.next = newNode;
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

        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (prev == null) {
            // 删除的是第一个节点
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
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
