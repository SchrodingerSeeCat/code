package com.valid;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        getUrl("http://www.nipic.com/");
    }

    private static void getUrl(String url) {
        Map<String, Boolean> oldMap = new LinkedHashMap<>();
        String host = "";
        Pattern pattern = Pattern.compile("(https?://)?[^\\s]*"); // 提取主机信息
        Matcher m = pattern.matcher(url);
        if (m.find()) {
            host = m.group();
            System.out.println(host);
        }
        oldMap.put(url, false);
        crawLinkHost(host.substring(0, host.length() - 1), oldMap);
        oldMap.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }

    private static Map<String, Boolean> crawLinkHost(String host, Map<String, Boolean> oldMap) {
        Map<String, Boolean> newMap = new LinkedHashMap<>();
        String oldLink = "";
        for (Map.Entry<String, Boolean> entry : oldMap.entrySet()) {
            if (!entry.getValue()) {
                oldLink = entry.getKey();
                try {
                    URL url = new URL(oldLink);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    if (connection.getResponseCode() == 200) {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        Pattern p = Pattern.compile("<a.*?href=[\"']?((https?://)?/?[^\"']+)[\"']?.*?>(.+)</a>");
                        Matcher matcher = null;
                        String line = "";
                        while((line = reader.readLine()) != null) {
                            matcher = p.matcher(line);
                            if (matcher.find()) {
                                String newLink = matcher.group(1).trim();
                                if (!newLink.startsWith("http")) {
                                    if (newLink.startsWith("/")) { // 拼接域名
                                        newLink = host + newLink;
                                    } else {
                                        newLink = host + "/" + newLink;
                                    }
                                }
                                if (newLink.endsWith("/")) {
                                    newLink = newLink.substring(0, newLink.length() - 1); // 消除末尾斜线
                                }
                                if (!oldMap.containsKey(newLink)
                                    && !newMap.containsKey(newLink)
                                    && newLink.startsWith(host)) {
                                    System.out.println(newLink);
                                    newMap.put(newLink, false);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                oldMap.replace(oldLink, false, true); // 将url替换为已访问
            }
        }
        if(!newMap.isEmpty()) {
            oldMap.putAll(newMap);
            oldMap.putAll(crawLinkHost(host, oldMap));
        }

        return oldMap;
    }
}
