package com.wanliding;
public class Main {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        for(int i = 0; i < 35; i++){
            list.remove(list.size() - 1);
        }
        System.out.println(list.size());
    }
}
