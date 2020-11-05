import java.util.Scanner;

public class P_5727 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        problemAnswer(reader.nextInt());
    }
    public static void problemAnswer(int item){
        if (item == 1){
            System.out.printf("%d", item);
            return;
        } else if(item % 2 == 0) {
            problemAnswer(item/2);
        } else{
            problemAnswer(item * 3 + 1);
        }
        System.out.printf(" %d", item);
    }
}
