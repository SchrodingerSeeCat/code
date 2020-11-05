package handleexception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverrideTest {

}
class SuperClass{
    public void method() throws IOException{

    }
}
class Subclass extends SuperClass{
    public void method() throws FileNotFoundException {

    }
}
