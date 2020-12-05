package fluxmono;

import org.springframework.web.server.WebHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FluxTest {
    public static void main(String[] args) {

        // just方法直接声明
        Flux.just(1, 2, 3, 4).subscribe(System.out::println);
        Mono.just(1);

        // 数组方法
        Integer[] arr = {1, 2, 3};
        Flux.fromArray(arr);

        // 集合方式
        List<Integer> list = Arrays.asList(arr);
        Flux.fromIterable(list);

        // 流方式
        Stream<Integer> stream = list.stream();
        Flux.fromStream(stream);
    }
}
