package com.crazy_ataman.University.Students;

import java.util.ArrayList;

public class Student_Forest extends Student {
    ArrayList<Student_IT> students_Forest = new ArrayList<>();

    public Student_Forest(String name, String surname, String form_of_ed, Course course, int academic_perf, int missed_hours, int scholarship) {
        super(name, surname, form_of_ed, course, academic_perf, missed_hours, scholarship);
    }

    // Needed for XMLEncoder, otherwise doesn't work
    public Student_Forest() { super(); }

    @Override
    public void setScholarship(int scholarship) {
        if (getMissed_hours() >= 30 || getAcademic_perf() < 4) {
            super.setScholarship(0);
        } else if (getAcademic_perf() > 8) {
            super.setScholarship((int) (scholarship * 1.1));
        } else {
            super.setScholarship(scholarship);
        }
    }
}
