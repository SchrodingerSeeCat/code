package com.valid;

public class ScalarReplace {
    public static class User{
        private int id;
        private String name;
    }

    public static void alloc() {
        User user = new User();
        user.id = 1;
        user.name = "标量替换";
    }
}
