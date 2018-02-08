package com.bbd.pingpong;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name = null;
    private ArrayList<Student> students;
    private int capacity = 0;
    private static int numberOfCourses = 0;

    public Course(String name, int cap){
        numberOfCourses++;
        students = new ArrayList<>();

        this.name = name;
        this.capacity = cap;
    }

    public boolean enrollStudent(Student student){
        if (this.students.size() >= this.capacity)
            return (false);
        if (this.students.contains(student))
            return (false);
        return (this.students.add(student));
    }

    public boolean unenrollStudent(Student student){
        if (this.students.contains(student) == false)
            return (false);
        return (this.students.remove(student));
    }

    public String getName() {
        return name;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }
}
