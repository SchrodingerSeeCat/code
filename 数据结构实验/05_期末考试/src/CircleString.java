import java.util.Scanner;

public class CircleString {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        var str = reader.next();
        for(int i = 0, j = str.length() - 1; i < str.length(); i++, j--) {
            if(str.charAt(i) != str.charAt(j)){
                System.out.println("不是回文函数");
                return;
            }
        }
        System.out.println("是回文函数");
    }
}
