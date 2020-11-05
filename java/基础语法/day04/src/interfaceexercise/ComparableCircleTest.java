package interfaceexercise;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(3.4);
        ComparableCircle c2 = new ComparableCircle(3.1);
        int value = c1.compareTo(c2);
        if(value > 0) {
            System.out.println("c1 > c2");
        } else if (value < 0){
            System.out.println("c1 < c2");
        } else {
            System.out.println("c1 == c2");
        }

        c1.compareTo(new String("hello"));
    }
}
