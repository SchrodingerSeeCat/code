package com.valid.flyweight;

import java.util.HashMap;
import java.util.Map;

// 网站工厂类，根据需求返回一个网站
public class WebSiteFactory {
    // 网站池
    private final Map<String, ConcreteWebSite> pool = new HashMap<>();
    // 根据网站的类型，返回一个网站，如果没有就创建一个并放入到池中并返回
    public WebSite getWebSiteCategory(String type) {
        if (!pool.containsKey(type)) {
            pool.put(type, new ConcreteWebSite(type));
        }
        return pool.get(type);
    }

    // 获取网站分类的总数
    public int getWebSiteSize() {
        return pool.size();
    }
}
