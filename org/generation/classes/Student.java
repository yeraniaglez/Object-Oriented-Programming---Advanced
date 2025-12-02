package org.generation.classes;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String id;
    private int age;
    private final List<Course> courseList = new ArrayList<>();

    public Student(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public List<Course> getCourseList() {
        return courseList;
    }
}