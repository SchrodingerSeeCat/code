import java.util.ArrayList;
import java.util.Scanner;

public class P_3613 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int q = reader.nextInt();
        int[][] store = new int[q][];

        answer(reader, list, store, n, q);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static void answer(Scanner reader,ArrayList<Integer> list, int[][] store, int n, int q){
        for(int i = 0; i < q; i++){
            int first = reader.nextInt();
            if (first == 1) {
                store[i] = new int[4];
                store[i][0] = first;
                scanner(reader, store[i], 4);
                if (store[i][3] == 0) {
                    for(int j = 0; j < i; j++){
                        if (store[j][0] == 1 && store[j][1] == store[i][1] && store[j][2] == store[i][2]) {
                            store[j][0] = 0;
                        }
                    }
                }
            } else {
                store[i] = new int[3];
                store[i][0] = first;
                scanner(reader, store[i], 3);
                for(int j = 0; j < i; j++){
                    if (store[j][0] == 1 && store[j][1] == store[i][1] && store[j][2] == store[i][2]) {
                        list.add(store[j][3]);
                    }
                }
            }
        }
    }
    public static void scanner(Scanner read, int[] score, int size) {
        for(int i = 1; i < size; i++){
            score[i] = read.nextInt();
        }
    }
}
