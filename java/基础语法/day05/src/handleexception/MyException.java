package handleexception;

public class MyException extends RuntimeException{
    static final long serialVersionUID = -70348766939L;
    public MyException(){
    }
    public MyException(String s){
        super(s);
    }
}
