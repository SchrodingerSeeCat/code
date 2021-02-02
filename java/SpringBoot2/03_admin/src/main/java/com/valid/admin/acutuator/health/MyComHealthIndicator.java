package com.valid.admin.acutuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/*
 * 名字一定是HealthIndicator结尾
 * */
@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // 获取连接进行测试
        // 携带数据
        Map<String, Object> map = new HashMap<>();
        if(true) {
//            builder.up(); // 健康
            builder.status(Status.UP);

            // 连接成功返回的信息
            map.put("count", 1);
            map.put("ms", 100);
        } else {
            builder.down(); // 不健康
            map.put("error", "连接超时");
        }
        builder.withDetails(map);
    }
}
