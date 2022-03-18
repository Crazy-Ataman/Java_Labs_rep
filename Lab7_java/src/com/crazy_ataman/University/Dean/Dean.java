package com.crazy_ataman.University.Dean;

import com.crazy_ataman.University.Students.*;

import java.util.*;

public class Dean implements IDean {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Dean(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // Needed for XMLEncoder, otherwise doesn't work
    public Dean() {}

    @Override
    public String toString() {
        return "Dean:" +
                "\nname: " + name +
                "\nsurname: " + surname;
    }

    public void countStudentsByCourses(ArrayList<Student> students) {
        int[] arr = new int[6];
        for (Student student : students) {
                switch (student.getCourse()) {
                    case undefined -> arr[0] += 1;
                    case first -> arr[1] += 1;
                    case second -> arr[2] += 1;
                    case third -> arr[3] += 1;
                    case fourth -> arr[4] += 1;
                    case fifth -> arr[5] += 1;
            }
        }
        System.out.println("Number of first year students:  " + arr[1]);
        System.out.println("Number of second year students: " + arr[2]);
        System.out.println("Number of third year students:  " + arr[3]);
        System.out.println("Number of fourth year students: " + arr[4]);
        System.out.println("Number of fifth year students:  " + arr[5]);
    }

    public ArrayList<Student> selectionStudentsCourse(ArrayList<Student> students, Student.Course course) {
        ArrayList<Student> res_students = new ArrayList<>();
        for (Student st : students) {
            if (st.getCourse() == course)
                res_students.add(st);
        }
        return res_students;
    }

    public ArrayList<Student> selectionStudentsAcademicPerf(ArrayList<Student> students) {
        ArrayList<Student> res_students = new ArrayList<>();
        for (Student st : students) {
            if (st.getAcademic_perf() > 6)
                res_students.add(st);
        }
        return res_students;
    }

    public void sortStudentsByCourses(ArrayList<Student> students) {
        students.sort(Student.CourseComparator);
    }

    public void sortStudentsBySurname(ArrayList<Student> students) {
        students.sort(Student.SurnameComparator);
    }
}
