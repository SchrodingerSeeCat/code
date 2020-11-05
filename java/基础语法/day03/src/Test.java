import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String str = reader.nextLine();
        str = str.trim();
        int count = 0;
        for(int i = 0; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            if(c != ' ') {
                count++;
            }
            if (c == ' ' && str.charAt(i + 1) != ' ') {
                System.out.printf("%d ", count);
                count = 0;
            }
        }
        if(str.length() != 1) {
            System.out.printf("%d", count);
        }
    }
}
