package com.valid.web.controller;

import com.valid.web.bean.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    // 获取指定的路径参数
//    @GetMapping("/car/{id}/owner/{username}")
//    public Map<String, Object> getCar(@PathVariable("id") Integer id, @PathVariable("username") String username) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("id", id);
//        map.put("username", username);
//
//        return map;
//    }

    // 获取所有的路径参数
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, String> getCar(@PathVariable Map<String, String> map) {
        return map;
    }


    // 获取指定的请求头
//    @GetMapping("/header")
//    public String getHeader(@RequestHeader("User-Agent") String userAgent) {
//        return userAgent;
//    }

    // 获取所有的请求头
    @GetMapping("/header")
    public Map<String, String>  getHeader(@RequestHeader Map<String, String> userAgent) {
        return userAgent;
    }

    // 获取请求参数
//    @GetMapping("/param")
//    public int getParam(@RequestParam("age") Integer age){
//        return age;
//    }

    // 获取全部请求参数
    @GetMapping("/param")
    public Map<String, String> getParam(@RequestParam Map<String, String> map){
        return map;
    }

    // 请求获得某一Cookie的值
//    @GetMapping("/cookie")
//    public String getCookie(@CookieValue("ga") String cookie) {
//        return cookie;
//    }

    // 获取Cookie的所有信息
    @GetMapping("/cookie")
    public Cookie getCookie(@CookieValue("ga")Cookie cookie) {
        return cookie;
    }

    // 获取请求体的信息
    @PostMapping("/body")
    public String getBody(@RequestBody String content) {
        return content;
    }

    // 矩阵变量
    // 请求地址 http://127.0.0.1:8080/cars/sell;low=34;brand=byd,audi,yd
    @GetMapping("/cars/{sell}")
    public Map<String, Object> carsSell(@MatrixVariable("low") Integer low, @MatrixVariable("brand") List<String> brand) {
        Map<String, Object> map = new HashMap<>();

        map.put("low", low);
        map.put("brand", brand);
        System.out.println("矩阵变量：" + map);
        return map;
    }


    @PostMapping("/saveuser")
    public String saveUser(Person person) {
        return person.toString();
    }
}
