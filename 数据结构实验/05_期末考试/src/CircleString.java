import java.util.Scanner;

public class CircleString {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        var str = reader.next();
        for(int i = 0, j = str.length() - 1; i < str.length(); i++, j--) {
            if(str.charAt(i) != str.charAt(j)){
                System.out.println("���ǻ��ĺ���");
                return;
            }
        }
        System.out.println("�ǻ��ĺ���");
    }
}
