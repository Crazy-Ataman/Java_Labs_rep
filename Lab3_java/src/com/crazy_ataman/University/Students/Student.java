package com.crazy_ataman.University.Students;

import java.util.*;

abstract public class Student {

    private String name;
    private String surname;
    private String form_of_ed;

    public enum Course {
        undefined,
        first,
        second,
        third,
        fourth,
        fifth
    }

    private Course course;
    private int academic_perf;
    private int missed_hours;
    private int scholarship;

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

    public String getForm_of_ed() {
        return form_of_ed;
    }

    public void setForm_of_ed(String form_of_ed) {
        this.form_of_ed = form_of_ed;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getAcademic_perf() {
        return academic_perf;
    }

    public void setAcademic_perf(int academic_perf) throws Exception {
        if (academic_perf < 0)
            throw new Exception("[Exception] Academic perfection cannot be less then zero!");
        this.academic_perf = academic_perf;
    }

    public int getMissed_hours() {
        return missed_hours;
    }

    public void setMissed_hours(int missed_hours) throws Exception {
        if (missed_hours < 0)
            throw new Exception("[Exception] Missed hours cannot be less then zero!");
        this.missed_hours = missed_hours;
    }

    public int getScholarship() {
        return scholarship;
    }

    public void setScholarship(int scholarship) throws Exception {
        if (scholarship < 0)
            throw new Exception("[Exception] Scholarship cannot be less then zero!");
        this.scholarship = scholarship;
    }

    public Student(String name, String surname, String form_of_ed, Course course, int academic_perf, int missed_hours, int scholarship) throws Exception {
        setName(name);
        setSurname(surname);
        setForm_of_ed(form_of_ed);
        setCourse(course);
        setAcademic_perf(academic_perf);
        setMissed_hours(missed_hours);
        setScholarship(scholarship);
    }

    // Needed for XMLEncoder, otherwise doesn't work
    public Student() {}

    @Override
    public String toString() {
        return "Student:" +
                "\nname: " + name +
                "\nsurname: " + surname +
                "\nform_of_ed: " + form_of_ed +
                "\ncourse: " + course +
                "\nacademic_perf: " + academic_perf +
                "\nmissed_hours: " + missed_hours +
                "\nscholarship: " + scholarship + "$";
    }

    public static Comparator<Student> SurnameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student st1, Student st2) {
            return st1.getSurname().compareTo(st2.getSurname());
        }
    };

    public static Comparator<Student> CourseComparator = new Comparator<Student>() {
        @Override
        public int compare(Student st1, Student st2) {
            return st1.course.ordinal() - st2.course.ordinal();
        }
    };
}
