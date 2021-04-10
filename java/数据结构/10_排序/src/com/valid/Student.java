package com.valid;

public class Student implements Comparable<Student>{
    private int score;
    private int age;
    private String name;

    public Student(int score, int age, String name) {
        this.score = score;
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Student stu) {
        return this.score - stu.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
