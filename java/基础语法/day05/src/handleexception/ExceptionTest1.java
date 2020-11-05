package handleexception;
/*
* 异常处理
* */
public class ExceptionTest1 {
    public static void main(String[] args){
        String str = "abc";
        try {
            int num = Integer.parseInt(str);
        } catch(NumberFormatException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("数值转换异常");
        }
        System.out.println("fffff");
    }
}
