import io.netty.util.NettyRuntime;
import org.junit.Test;

public class NettyTest {
    @Test
    public void test1() {
        // Netty NioEventLoopGroup默认线程数量是CPU核心的2倍
        System.out.println(NettyRuntime.availableProcessors());
    }
}
