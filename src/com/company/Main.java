package com.company;

import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Creating arrays.
        ArrayList<Student> allStudents = new ArrayList<>();
        ArrayList<Teacher> allTeachers = new ArrayList<>();
        ArrayList<Course> allCourses = new ArrayList<>();

        //Creating pre-existing courses, teachers, and students.
        allCourses.add(new Course("123456", "Mathematics"));
        allCourses.add(new Course("23456", "Biology"));

        Teacher aTeacher = new Teacher("123456", "Dave", "Wolf");
        aTeacher.getCoursesTaught().add(findCourseById("123456", allCourses));
        allTeachers.add(aTeacher);

        aTeacher = new Teacher("123457", "Another", "Teacher");
        aTeacher.getCoursesTaught().add(findCourseById("23456", allCourses));
        allTeachers.add(aTeacher);

        Student aStudent = new Student("123456", "Joyce", "Luning", "email@email.com");
        allStudents.add(aStudent);

        aStudent = new Student("123458", "Sarah", "Smith", "otheremail@email.com");
        allStudents.add(aStudent);

        aStudent = findStudent("123458", allStudents);
        System.out.printf("The student's ID Number %s the student's first name: %s\n", aStudent.getIdNumber(), aStudent.getFirstName());

        aTeacher = findTeacher("123457", allTeachers);
        System.out.printf("The teacher's ID Number %s the teachers's first name: %s\n", aTeacher.getIdNumber(), aTeacher.getFirstName());

//      Display a menu
//      Menu options: Add a student, Add a teacher, Add a course, List students, List teachers, List courses
        int choice = 0;
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("Select an option number to continue:\n1.Add a student\n2.Add a teacher\n3.Add a course\n4.List students\n5.List teachers\n6.List courses\n7.Add a student or teacher to course\n8.Quit");
            choice = keyboard.nextInt();
            keyboard.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Add a student");
                    //  Get user input

                    String lastName;
                    String idNumber;
                    String emailAddress;
                    System.out.println("Enter student's first name");
                    String firstName = keyboard.nextLine();
                    System.out.println("Enter student's last name");
                    lastName = keyboard.nextLine();
                    System.out.println("Enter student's email ");
                    emailAddress = keyboard.nextLine();
                    System.out.println("Enter student's id Number ");
                    idNumber = keyboard.nextLine();
                    allStudents.add(new Student(idNumber, firstName, lastName, emailAddress));

                    //Create a new student
                    //Add student to list of courses
                    break;

                case 2:
                    System.out.println("Add a teacher");

                    System.out.println("Enter teacher's id Number ");
                    idNumber = keyboard.nextLine();
                    System.out.println("Enter teacher's first name");
                    firstName = keyboard.nextLine();
                    System.out.println("Enter teacher's last name");
                    lastName = keyboard.nextLine();

                    allTeachers.add(new Teacher(idNumber, firstName, lastName));
                    break;

                case 3:
                    System.out.println("Add a course");
//                    Get user input
                    System.out.println("Enter course name");
                    String courseName = keyboard.nextLine();

                    System.out.println("Enter course id number");
                    String courseId = keyboard.nextLine();

                    Course theNewCourse = new Course(courseId, courseName);
                    allCourses.add(theNewCourse);

                    String addStudentTeacher = "";
                    do {
//                        String addStudentTeacher, Scanner keyboard, ArrayList<Student> allStudents, ArrayList<Teacher> allTeachers, Course theNewCourse
                        addStudentTeacher = addStudentOrTeacherToCourse(addStudentTeacher,keyboard,allStudents,allTeachers,theNewCourse);
                    } while (!addStudentTeacher.equalsIgnoreCase("none"));
                    break;
                case 4:
                    System.out.println("List students");
                    for (Student student : allStudents) {
                        System.out.printf("ID Number:%s\nFirst Name:%s\nLast Name:%s\nE-mail Address:%s\n", student.getIdNumber(), student.getFirstName(), student.getLastName(), student.getEmail());
                    }
                    break;
                case 5:
                    System.out.println("List teachers");
                    for (Teacher teacher : allTeachers) {
                        System.out.printf("ID Number:%s\nFirst Name:%s\nLast Name:%s\n", teacher.getIdNumber(), teacher.getFirstName(), teacher.getLastName());
                    }
                    break;
                case 6:
                    System.out.println("List courses");
                    listCourses(allCourses,allStudents,allTeachers);
                    break;
                case 7:
                    System.out.println("Add student or teacher to existing course");
                    System.out.println("Enter a course ID");
                    courseId = keyboard.nextLine();
                    Course toFind = findCourseById(courseId,allCourses);
//                    public static String addStudentOrTeacherToCourse(String addStudentTeacher, Scanner keyboard, ArrayList<Student> allStudents, ArrayList<Teacher> allTeachers, Course theNewCourse) {
                    addStudentOrTeacherToCourse("",keyboard,allStudents,allTeachers,toFind);
                    break;
                case 8:
                    System.out.println("Quit");
                    break;
                default:
                    System.out.println("Don't get cute");
                    break;
            }
        } while (choice!= 8);

//      Create a new teacher

//      Create a new student

//      Create a new course


//
//        for(Course eachCourse : aTeacher.getCoursesTaught())
//        {
//            System.out.println(eachCourse.getIdNumber());
//            System.out.println(eachCourse.getCourseName());
//        }
//
//
//
//        ArrayList <Course> myCourses = (ArrayList) aStudent.getCoursesTaken();
//        myCourses.add(findCourseById("123456",allCourses));
//        aStudent.setCoursesTaken(myCourses);
    }


    public static Course findCourseById(String idNumber, ArrayList<Course> lookHere) {
        Course foundCourse = null;
        for (Course eachcourse : lookHere) {
            if (idNumber.equalsIgnoreCase(eachcourse.getIdNumber())) {
                foundCourse = eachcourse;
            }
        }
        return foundCourse;
    }

    public static Teacher findTeacher(String idNumber, ArrayList<Teacher> lookHere) {
        Teacher teacherToReturn = null;
        for (Teacher eachTeacher : lookHere){
            if (idNumber.equalsIgnoreCase(eachTeacher.getIdNumber())) {
                teacherToReturn = eachTeacher;
            }
        }
        return teacherToReturn;
    }

    public static Student findStudent(String idNumber, ArrayList<Student> lookHere) {
        Student studentToReturn = null;
        for (Student eachStudent : lookHere) {
            if (idNumber.equalsIgnoreCase(eachStudent.getIdNumber())) {
                studentToReturn = eachStudent;
            }
        }
        return studentToReturn;
    }

    public static void  listCourses(ArrayList <Course> allCourses, ArrayList<Student> allStudents, ArrayList<Teacher> allTeachers){

        for(Course eachCourse: allCourses) {
            System.out.printf("Course name: %s\n",eachCourse.getCourseName());

            System.out.println("Taught by");
            for (Teacher eachTeacher : allTeachers) {
                if(eachTeacher.getCoursesTaught().contains(eachCourse))
                {
                    System.out.println(eachTeacher.getFirstName()+" "+eachTeacher.getLastName());
                }
            }
            System.out.println();

            System.out.println("Taken by:");
            for (Student eachStudent:allStudents) {
                if(eachStudent.getCoursesTaken().contains(eachCourse)) {
                    System.out.println(eachStudent.getFirstName()+" "+eachStudent.getLastName());
                }
            }
        }
    }

    public static String addStudentOrTeacherToCourse(String addStudentTeacher, Scanner keyboard, ArrayList<Student> allStudents, ArrayList<Teacher> allTeachers, Course theNewCourse) {
        System.out.println("Would you like to add this course to a student or teacher?\nEnter student or teacher to select, 'none' to return to the main menu.");
        addStudentTeacher = keyboard.nextLine();
        if (!addStudentTeacher.equalsIgnoreCase("student") && !addStudentTeacher.equalsIgnoreCase("teacher") && !addStudentTeacher.equalsIgnoreCase("none")) {
            System.out.println("Enter a valid option!!");
        }

        if (!addStudentTeacher.equalsIgnoreCase("none")) {
            System.out.println("Enter the ID:");
            String teacherStudentID = keyboard.nextLine();
            if (addStudentTeacher.equalsIgnoreCase("student")) {
                Student foundStudent = findStudent(teacherStudentID, allStudents);
                foundStudent.addACourse(theNewCourse);
            } else {
                Teacher foundTeacher = findTeacher(teacherStudentID, allTeachers);
                foundTeacher.addACourse(theNewCourse);
            }
        }
        return addStudentTeacher;
    }
}