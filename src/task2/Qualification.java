package task2;


abstract class Qualification {
    private String name;
    private SwimStudent student;
    private Instructor instructor;

    public Qualification(String name, SwimStudent student, Instructor instructor) {
        this.name = name;
        this.student = student;
        this.instructor = instructor;
    }

    public String getName() {
        return name;
    }

    public SwimStudent getStudent() {
        return student;
    }

    public Instructor getInstructor() {
        return instructor;
    }
}

// Subclass representing a distance swim qualification
class DistanceSwim extends Qualification {
    private int distance;

    public DistanceSwim(String name, SwimStudent student, Instructor instructor, int distance) {
        super(name, student, instructor);
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}

// Subclass representing a personal survival qualification
class PersonalSurvival extends Qualification {
    private String category;

    public PersonalSurvival(String name, SwimStudent student, Instructor instructor, String category) {
        super(name, student, instructor);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

}

