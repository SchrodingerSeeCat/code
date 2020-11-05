import circle.CircleDeque;

public class Main {
    public static void main(String[] args) {
        CircleDeque<Integer> queue = new CircleDeque<>();
        for(int i = 0; i < 10; i++) {
            queue.enQueueFront(i + 1);
            queue.enQueueRear(i + 100);
        }
        System.out.println("队头" + queue.rear());
        System.out.println(queue);
    }
}
