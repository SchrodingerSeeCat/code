package runtimexception;
// 常见异常
import java.util.Date;

public class ExceptionTest {
    public static void main(String[] args) {
//        test1();
//        test2();
    }

    // 空指针
    // NullPointerException
    public static void test1(){
        int arr[] = null;
        System.out.println(arr[0]);
    }

    // 数组越界
    // ArrayIndexOutOfBoundsException
    public static void test2(){
        int arr[] = new int[1];
        System.out.println(arr[1]);
    }

    // 类型转换错误
    // ClassCastException
    public static void test3(){
        Object obj = new Date();
        String str = (String)obj;
    }
}
