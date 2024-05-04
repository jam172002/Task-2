package task2;

public class SwimStudent{
    private String studentName;
    private String studentLevel;
    private int swimDistance;
    private String allocatedClass;
    private String qualificationAward;
    private String personalSurvivalAward;

    //constructor for class

    public SwimStudent(String studentName, String studentLevel, int swimDistance, String allocatedClass, String qualificationAward, String personalSurvivalAward) {
        this.studentName = studentName;
        this.studentLevel = studentLevel;
        this.swimDistance = swimDistance;
        this.allocatedClass = allocatedClass;
        this.qualificationAward = qualificationAward;
        this.personalSurvivalAward = personalSurvivalAward;
    }

    //getter and setter for dataset

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    public int getSwimDistance() {
        return swimDistance;
    }

    public void setSwimDistance(int swimDistance) {
        this.swimDistance = swimDistance;
    }

    public String getAllocatedClass() {
        return allocatedClass;
    }

    public void setAllocatedClass(String allocatedClass) {
        this.allocatedClass = allocatedClass;
    }

    public String getQualificationAward() {
        return qualificationAward;
    }

    public void setQualificationAward(String qualificationAward) {
        this.qualificationAward = qualificationAward;
    }

    public String getPersonalSurvivalAward() {
        return personalSurvivalAward;
    }

    public void setPersonalSurvivalAward(String personalSurvivalAward) {
        this.personalSurvivalAward = personalSurvivalAward;
    }




}