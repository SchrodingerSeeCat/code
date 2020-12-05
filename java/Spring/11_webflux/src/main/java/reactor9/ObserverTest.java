package reactor9;

import java.util.concurrent.Flow;

public class ObserverTest {
    public static void main(String[] args) {
        // Publisher发布   subscriber订阅
        Flow.Publisher<String> publisher = subscriber -> {
            subscriber.onNext("1"); // 获取信号进行处理
            subscriber.onNext("2");
            subscriber.onError(new RuntimeException("出错"));
        };

        publisher.subscribe(new Flow.Subscriber<String>() {
            @Override
            public void onSubscribe(Flow.Subscription subscription) {

            }

            @Override
            public void onNext(String item) {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
