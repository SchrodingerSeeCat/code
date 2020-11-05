package handleexception;

public class ThrowTest {
    public static void main(String[] args) {
        Student s = new Student();
//        try {
//            s.register(-100);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        s.register(-100);
    }
}
class Student{
    private int id;
//    public void register(int id) throws Exception{
//        if(id > 0){
//            this.id = id;
//        } else {
////            throw new RuntimeException("输入数据非法");
////            throw new Exception("输入数据非法");
//        }
//    }

    public void register(int id){
        if(id > 0){
            this.id = id;
        } else {
            throw new MyException("不能输入负数");
        }
    }
}
