package com.crazy_ataman.University.Dean;

import com.crazy_ataman.University.Students.*;

import java.util.ArrayList;

public interface IDean {
    public void countStudentsByCourses (ArrayList<Student> students);


    public ArrayList<Student> selectionStudentsCourse(ArrayList<Student> students, Student.Course course);

    public ArrayList<Student> selectionStudentsAcademicPerf(ArrayList<Student> students);

    public void sortStudentsByCourses(ArrayList<Student> students);

    public void sortStudentsBySurname(ArrayList<Student> students);

}
