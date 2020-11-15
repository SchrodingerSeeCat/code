package optional;

import org.junit.Test;

import java.util.Optional;
import java.util.zip.GZIPInputStream;

public class OptionalTest {
    @Test
    public void test() {
        // 不能为空
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);
    }

    @Test
    public void test1() {
        Girl girl = null;
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
    }

    public String getGirlName(Boy boy) {
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        Boy boy1 = optionalBoy.orElse(new Boy(new Girl("Alice")));

        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);

        Girl girl1 = girlOptional.orElse(new Girl("Anna"));

        return girl1.getName();
    }
}
