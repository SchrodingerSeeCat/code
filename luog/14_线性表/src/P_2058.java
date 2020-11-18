import java.util.LinkedList;
import java.util.Scanner;

public class P_2058 {
    public static void main(String[] args){
        LinkedList<Integer> nationality = new LinkedList<>();
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[][] boats = new int[n][];
        for(int i = 0; i < n; i++){
            int time = reader.nextInt();
            int number = reader.nextInt() + 1;
            boats[i] = new int[number];
            boats[i][0] = time;
            for(int j = 1; j < number; j++){
                boats[i][j] = reader.nextInt();
            }
        }
        for(int i = 0; i < n; i++){

            for(int j = 1; j < boats[i].length; j++){
                if(nationality.indexOf(boats[i][j]) == -1) {
                    nationality.add(boats[i][j]);
                }
            }

            for(int j = 0; j < i; j++){
                if(boats[i][0] - boats[j][0] >= 86400) {
                    continue;
                }
                for(int k = 1; k < boats[j].length; k++){
                    if(nationality.indexOf(boats[j][k]) == -1) {
                        nationality.add(boats[j][k]);
                    }
                }
            }

            System.out.println(nationality.size());
            nationality.clear();
        }
    }
}
