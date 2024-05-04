package task2;

import java.util.List;

public class Instructor {
    private String InstructorName;
    private String courseTaken;

    public Instructor(String InstructorName, String courseTaken) {
        this.InstructorName = InstructorName;
        this.courseTaken = courseTaken;
    }
    public Instructor(){

    }

    //getter setter

    public String getInstructorName() {
        return InstructorName;
    }

    public void setInstructorName(String instructorName) {
        InstructorName = instructorName;
    }

    public String getCourseTaken() {
        return courseTaken;
    }

    public void setCourseTaken(String courseTaken) {
        this.courseTaken = courseTaken;
    }

}
