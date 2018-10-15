package com.company;

import java.util.ArrayList;

public class Teacher extends Person {


    private ArrayList<Course> coursesTaught;

    public Teacher() {
        coursesTaught = new ArrayList<Course>();
    }

    public Teacher(String idNumber, String firstName, String lastName){
        this.setIdNumber(idNumber);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        coursesTaught = new ArrayList<>();
    }

    public ArrayList<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(ArrayList<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    public void addACourse(Course theCourse)
    {
        coursesTaught.add(theCourse);
    }
}