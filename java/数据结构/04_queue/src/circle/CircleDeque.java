package circle;
import list.BilateralLinkList;

// 双向队列
public class CircleDeque<E> {
    // 队头下标
    private int front;
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleDeque(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    // 清空队列
    public void clear(){
        for(int i = 0; i < size; i++){
            elements[index(i)] = null;
        }
        size = 0;
        front = 0;
    }

    // 返回队列的大小
    public int size(){
        return size;
    }

    // 队列是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 从队尾入队
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }
    // 从队尾出队
    public E deQueueRear() {
        int rearIndex = index(size - 1);
        E rear = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return rear;
    }
    // 从队头入队
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        front = index(-1);
        elements[front] = element;
        size++;
    }
    // 从队头出队
    public E deQueueFront(){
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }
    // 获取队头
    public E front(){
        return elements[front];
    }
    // 获取队尾
    public E rear(){
        return elements[index(size - 1)];
    }

    // 打印
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("size = ").append(size).append(", ").append("front = ").append(front).append(", ").append("[");
        for(int i = 0; i < elements.length; i++){
            sb.append(elements[i]);
            if (i < elements.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // 扩容
    public void ensureCapacity(int capacity){
        if (elements.length > capacity) {
            return;
        }
        E[] newElements = (E[])new Object[elements.length + (elements.length >> 1)];
        for(int i = 0; i < size; i++){
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        front = 0;
    }

    // 封装映射
    private int index(int index) {
        index += front;
        if (index < 0) {
            return index + elements.length;
        }
        return index - (index >= elements.length ? elements.length : 0);
    }
}
