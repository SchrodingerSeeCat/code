import java.util.Scanner;

public class BinarySearchTest {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int num = reader.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = reader.nextInt();
        }

        System.out.println(binarySearch(arr, num, 0, arr.length));
    }

    public static int binarySearch(int[] arr, int num, int begin, int end) {
        if(end - begin < 1) {
            return -1;
        }
        int mid = (begin + end) >> 1;

        // 查找到则返回
        if(arr[mid] == num) {
            return mid + 1;
        } else if(arr[mid] > num) {
            // 如果中间值比要搜索的值大，则向左边搜素
            return binarySearch(arr, num, begin, mid);
        }

        // 如果中间值比要搜索的值小，则向右边搜索
        return binarySearch(arr, num, mid + 1, end);
    }
}
