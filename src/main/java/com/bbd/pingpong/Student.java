package com.bbd.pingpong;

public class Student {
    private String name = null;
    private int studentNumber = 0;
    private String dob = null;

    public Student(String name, int studentNumber, String dob){
        this.name = name;
        this.studentNumber = studentNumber;
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public String getName() {
        return name;
    }
}
