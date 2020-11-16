import list.LinkList;

// 队列
public class Queue<E> {
    private LinkList<E> list = new LinkList<>();

    // 返回队列的大小
    public int size() {
        return list.size();
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // 入队
    public void enQueue(E element) {
        list.add(element);
    }

    // 出队
    public E deQueue() {
        return list.remove(0);
    }

    // 查看队头元素
    public E front() {
        return list.get(0);
    }

    // 清空队列
    public void clear(){
        list.clear();
    }
}
