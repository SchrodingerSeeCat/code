import list.BilateralLinkList;

// 双向队列
public class Deque<E> {
    private BilateralLinkList<E> list = new BilateralLinkList<>();
    // 返回队列的大小
    public int size() {
        return list.size();
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // 从队尾入队
    public void enQueueRear(E element) {
        list.add(element);
    }
    // 从队尾出队
    public E deQueueRear() {
        return list.remove(list.size() - 1);
    }
    // 从队头入队
    public void enQueueFront(E element) {
        list.add(0, element);
    }
    // 从队头出队
    public E deQueueFront(){
        return list.remove(0);
    }
    // 获取队头
    public E front(){
        return list.get(0);
    }
    // 获取队尾
    public E rear(){
        return list.get(list.size() - 1);
    }
}
