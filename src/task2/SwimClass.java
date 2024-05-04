package task2;

import java.util.List;

public class SwimClass {
    private String className;
    private String classDay;
    private String classTime;
    private String classInstructor;
    private List<String> studentsAllocated;
    private int classStNumbers;
    private String classStatus;

    //the constructor of the class

    public SwimClass(String className, String classDay, String classTime, String classInstructor, List<String> studentsAllocated, int classStNumbers, String classStatus) {
        this.className = className;
        this.classDay = classDay;
        this.classTime = classTime;
        this.classInstructor = classInstructor;
        this.studentsAllocated = studentsAllocated;
        this.classStNumbers = classStNumbers;
        this.classStatus = classStatus;
    }


    //getter setter of data set


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDay() {
        return classDay;
    }

    public void setClassDay(String classDay) {
        this.classDay = classDay;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getClassInstructor() {
        return classInstructor;
    }

    public void setClassInstructor(String classInstructor) {
        this.classInstructor = classInstructor;
    }

    public List<String> getStudentsAllocated() {
        return studentsAllocated;
    }

    public void setStudentsAllocated(List<String> studentsAllocated) {
        this.studentsAllocated = studentsAllocated;
    }

    public int getClassStNumbers() {
        return classStNumbers;
    }

    public void setClassStNumbers(int classStNumbers) {
        this.classStNumbers = classStNumbers;
    }

    public String getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(String classStatus) {
        this.classStatus = classStatus;
    }
}
