import list.ArrayList;

public class Stack<E>{
    private ArrayList<E> list = new ArrayList<>();
    // 清空栈
    public void clear() {
        list.clear();
    }
    // 元素入栈
    public void push(E element) {
        list.add(element);
    }
    // 元素出栈
    public E pop() {
        return list.remove(list.size() - 1);
    }
    // 查看栈顶元素
    public E top() {
        return list.get(list.size() - 1);
    }
    // 查看栈是否为空
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
