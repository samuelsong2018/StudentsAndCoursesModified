package com.company;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person
{
    private List<Course> coursesTaken;

    public Student() {
        coursesTaken = new ArrayList <Course>();

    }

    public Student(String idNumber, String firstName, String lastName, String emailAddress)
    {
        this.setIdNumber(idNumber);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(emailAddress);
        coursesTaken = new ArrayList<>();
    }



    public List<Course> getCoursesTaken() {
        return coursesTaken;
    }

    public void setCoursesTaken(List<Course> coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public void addACourse(Course existingCourse)
    {
        coursesTaken.add(existingCourse);
    }
}