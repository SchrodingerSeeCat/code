import com.valid.impl.AliPay;
import org.valid.service.PayService;
import org.junit.Test;

public class MainTest {

    public static void main(String[] args) {
        PayService payService = new AliPay();
        payService.pay();
    }
}
