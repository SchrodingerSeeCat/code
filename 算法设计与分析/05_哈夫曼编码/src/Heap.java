import java.util.Arrays;
import java.util.Comparator;

public class Heap<E> {

    // 默认大根堆
    private boolean isMaxHeap = true;
    private int size = 0;
    private int capacity = 16;
    private E[] value;

    // 比较器
    private Comparator<E> comparator;

    public Heap(int capacity) {
        this.capacity = capacity + 1;
        value = (E[])new Object[this.capacity];
    }
    public Heap(int capacity, boolean isMaxHeap) {
        this(capacity);
        this.isMaxHeap = isMaxHeap;
    }
    public Heap(int capacity, Comparator<E> con) {
        this(capacity);
        this.comparator = con;
    }
    public Heap(int capacity, boolean isMaxHeap, Comparator<E> con) {
        this(capacity, con);
        this.isMaxHeap = isMaxHeap;
    }

    // 向堆中添加元素
    public boolean add(E element) {
        if (isFull()) return false;
        int i = size + 1;
        for(; i > 1 && compare(value[i / 2], element); i = i/2) {
            value[i] = value[i/2];
        }
        value[i] = element;
        size++;
        return true;
    }

    // 取出堆顶元素
    public E remove() {
        if (size == 0) return null;

        int i = 1, child;
        E last = value[size];
        E element = value[i];

        for(; i * 2 < size; i = child) {
            child = i * 2;
            if (child != size && compare(value[child], value[child + 1])) {
                child++;
            }
            if (compare(value[child], last)) {
                break;
            } else {
                value[i] = value[child];
            }
        }
        value[i] = last;
        size--;
        return element;
    }
    // 判断堆是否为满
    public boolean isFull() {
        return size + 1 == capacity;
    }
    // 判断堆是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 返回长度
    public int size() {
        return  size;
    }
    // 比较
    private boolean compare(E e1, E e2) {
        int cmp = 0;
        if (comparator != null) {
            cmp = this.comparator.compare(e1, e2);
        } else {
            cmp = ((Comparable<E>)e1).compareTo(e2);
        }
        return isMaxHeap ? cmp < 0 : cmp > 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }
}
