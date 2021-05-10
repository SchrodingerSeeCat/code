package com.valid.flyweight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("测试享元模式")
    public void test() {
        WebSiteFactory factory = new WebSiteFactory();

        // 发布新闻网站
        WebSite news = factory.getWebSiteCategory("news");
        news.use(new User("tom"));

        // 发布博客
        WebSite blog = factory.getWebSiteCategory("blog");
        blog.use(new User("jack"));

        // 获取总数
        System.out.println(factory.getWebSiteSize()); // 2

    }
}
