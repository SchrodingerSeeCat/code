import java.util.Scanner;

public class P_4715 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = (int)Math.pow(2, reader.nextInt());
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = reader.nextInt();
        }
        System.out.println(findSecond(array,0, array.length - 1).second);
    }

    public static Max findSecond(int[] array, int begin, int end) {
        if(end - begin == 0) {
            return new Max(array[begin], array[begin]);
        }

        if(end - begin == 1) {
            return new Max(Math.max(array[begin], array[end]), Math.min(array[begin], array[end]));
        }

        int mid = (end - begin) >> 1;
        Max left = findSecond(array, begin, mid);
        Max right = findSecond(array, mid + 1, end);

        return left.compare(right);
    }

    private static class Max{
        public int first;
        public int second;
        public Max(int first, int second) {
            this.first = first;
            this.second = second;
        }
        public Max compare(Max max){
            if(this.first > max.first) {
                return new Max(this.first, Math.max(this.second, max.first));
            } else {
                return new Max(max.first, Math.max(max.second, this.first));
            }
        }
    }
}
