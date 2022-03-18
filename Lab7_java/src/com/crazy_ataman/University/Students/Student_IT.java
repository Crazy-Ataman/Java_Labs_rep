package com.crazy_ataman.University.Students;

import java.util.ArrayList;

public class Student_IT extends Student {

    public Student_IT(String name, String surname, String form_of_ed, Course course, int academic_perf, int missed_hours, int scholarship) {
        super(name, surname, form_of_ed, course, academic_perf, missed_hours, scholarship);
    }

    // Needed for XMLEncoder, otherwise doesn't work
    public Student_IT() { super(); }

    @Override
    public void setScholarship(int scholarship) {
        if (getMissed_hours() >= 18 || getAcademic_perf() < 4) {
            super.setScholarship(0);
        } else if (getAcademic_perf() > 8) {
            super.setScholarship((int) (scholarship * 1.3));
        } else {
            super.setScholarship(scholarship);
        }
    }

}
