package task2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Task2 {

    private static List<SwimStudent> students = new ArrayList<>();
    private static List<WaitingList> waitingList = new ArrayList<>();
    private static List<Instructor> instructors = new ArrayList<>();
    private static List<SwimClass> swimClasses = new ArrayList<>();
    

    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize all lists
        //give the list of instructor
        String[] instructorNames = {"Instructor A", "Instructor B", "Instructor C", "Instructor D", "Instructor E", "Instructor F", "Instructor G"};
        //initialize the list of all classes with timetable
        List<SwimClass> swimClasses = generateAllClasses(instructorNames);

        //initialize the list of instructors
        List<Instructor> instructors = generateInstructorList(swimClasses);

        //now create the student list by giving names, levels and distances
        String[] names = {"Alice", "Bob", "Charlie", "David", "Emma", "Kami", "Nomi", "Joseph", "Jennifer"};
        String[] levels = {"Novice", "Improver", "Advanced"};
        int[] distances = {5, 10, 20, 100, 200, 400, 800, 1500, 3000};

        List<SwimStudent> students = generateStudents(names, levels, distances, swimClasses);
        generateAwards(students, instructors);
        updateWaitingList();
        displayWaitingList();

        int choice;
        do {
            // Display main menu options
            displayMainMenu();

            // Get user input for menu choice
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    printStudentList(students, instructors);

                    break;
                case 2:
                    // Print the timetable
                    printTimetable(swimClasses);
                    break;
                case 3:
                    // Print the instructor list
                    printInstructorList(instructors, swimClasses);
                    break;
                case 4:
                    // Add a new student to the Novice class and update waiting list
                    addNewStudentToClass(scanner);
                    break;
                case 5:
                    // Display waiting list
                    displayWaitingList();

                    break;
                case 6:
                    // Update waiting list based on student awards
                    updateWaitingList();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }


    public static void displayMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. View Students List");
        System.out.println("2. View Swim Lesson Details");
        System.out.println("3. View Instructor List");
        System.out.println("4. Add New Student to Novice Class");
        System.out.println("5. Display Waiting List");
        System.out.println("6. Update Waiting List");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void addNewStudentToClass(Scanner scanner) {
        // Display available Novice classes
        System.out.println("Available Novice Classes:");
        for (SwimClass swimClass : swimClasses) {
            if (swimClass.getClassStatus().equals("Space Available") && swimClass.getClassName().contains("Novice")) {
                System.out.println(swimClass.getClassName() + " (" + swimClass.getClassStatus() + ")");
            }
        }

        // Get user input for class selection
        System.out.print("Enter the name of the class to add the new student: ");
        String className = scanner.next();

        // Find the selected class and add the new student if it's a Novice class
        for (SwimClass swimClass : swimClasses) {
            if (swimClass.getClassName().equalsIgnoreCase(className) && swimClass.getClassStatus().equals("Space Available") && swimClass.getClassName().contains("Novice")) {
                System.out.print("Enter student name: ");
                String name = scanner.next();

                // Add the new student to the Novice class
                SwimStudent newStudent = new SwimStudent(name, "Novice", 5, className, "", "");
                students.add(newStudent);

                // Update class status
                swimClass.setClassStatus("Full");

                System.out.println("New student added to class: " + className);
                return;
            }
        }

        System.out.println("Invalid class name or class is full. Please try again.");
    }

    public static void updateWaitingList() {
        // Check if any Novice or Improver students have taken awards and add them to the waiting list
        for (SwimStudent student : students) {
            String level = student.getStudentLevel();
            String qualificationAward = student.getQualificationAward();
            String personalSurvivalAward = student.getPersonalSurvivalAward();

            if ((level.equals("Novice") || level.equals("Improver")) && (!qualificationAward.isEmpty() || !personalSurvivalAward.isEmpty())) {
                waitingList.add(new WaitingList(student.getStudentName(), level, getNextLevel(level)));
            }
        }

        System.out.println("Waiting list updated successfully.");
    }

    public static String getNextLevel(String currentLevel) {
        if (currentLevel.equals("Novice")) {
            return "Improver";
        } else if (currentLevel.equals("Improver")) {
            return "Advanced";
        } else {
            return "";
        }
    }

    public static void displayWaitingList() {
        System.out.println("Waiting List:");
        for (WaitingList waitList : waitingList) {
            System.out.println("Name: " + waitList.getNameofWaiter());
            System.out.println("Current Level: " + waitList.getCurrentLevel());
            System.out.println("Required Level: " + waitList.getRequiredLevel());
            System.out.println("--------------------------");
        }
    }

private static List<Instructor> generateInstructorList(List<SwimClass> swimClasses) {
    List<Instructor> instructors = new ArrayList<>();
    Random random = new Random();
    String[] instructorNames = {"Instructor A", "Instructor B", "Instructor C", "Instructor D", "Instructor E", "Instructor F", "Instructor G"};

    for (String instructorName : instructorNames) {
        SwimClass swimClass = swimClasses.get(random.nextInt(swimClasses.size()));
        Instructor instructor = new Instructor(instructorName, swimClass.getClassName());
        swimClass.setClassInstructor(instructorName);
        instructors.add(instructor);
    }

    return instructors;
}

private static void printInstructorList(List<Instructor> instructors, List<SwimClass> swimClasses) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Instructor List (Alphabetical Order):");

    for (Instructor instructor : instructors) {
        System.out.println(instructor.getInstructorName());
    }

    System.out.print("Enter the name of the instructor to view details: ");
    String selectedInstructor = scanner.nextLine().trim();

    for (Instructor instructor : instructors) {
        if (instructor.getInstructorName().equalsIgnoreCase(selectedInstructor)) {
            System.out.println("Instructor Name: " + instructor.getInstructorName());
            System.out.println("Assigned Class: " + instructor.getCourseTaken());
            System.out.println("Assigned Classes for the Week:");

            // Store all classes for the selected instructor
            List<SwimClass> instructorClasses = new ArrayList<>();
            for (SwimClass swimClass : swimClasses) {
                if (swimClass.getClassInstructor().equalsIgnoreCase(selectedInstructor)) {
                    instructorClasses.add(swimClass);
                }
            }

            // Display all classes for the selected instructor
            for (SwimClass swimClass : instructorClasses) {
                System.out.println("Day: " + swimClass.getClassDay());
                System.out.println("Time: " + swimClass.getClassTime());
                System.out.println("Students in this class:");

                // Store all students in this class
                List<String> studentNamesInClass = swimClass.getStudentsAllocated();

                // Display names of students in this class
                for (String studentName : studentNamesInClass) {
                    System.out.println("Name: " + studentName);
                }
                System.out.println("-----------------------");  // Moved outside the loop
            }
            return;
        }
    }

    System.out.println("Instructor not found!");
}


private static List<SwimClass> generateAllClasses(String[] instructorNames) {
    List<SwimClass> swimClasses = new ArrayList<>();
    String[] days = {"Monday", "Wednesday", "Friday"};
    String[] levels = {"Novice", "Improver", "Advanced"};
    String[] times = {"17:00", "17:30", "18:00", "18:30", "19:00", "19:30"};
    int[] studentNumber = {1, 2, 3, 4};

    Random random = new Random();
    int classNumber = 1;
    for (String day : days) {
        for (String level : levels) {
            for (String time : times) {

                // Select instructor randomly from the provided list of instructor names
                String instructorName = instructorNames[random.nextInt(instructorNames.length)];
                String className = "C" + classNumber + " " + level + " Class ";
                int stNumber = studentNumber[random.nextInt(studentNumber.length)];
                String cStatus = (stNumber == 4) ? "Full" : "Space Available";
                swimClasses.add(new SwimClass(className, day, time, instructorName, new ArrayList<>(), stNumber, cStatus));
                classNumber++;
            }
        }
    }

    return swimClasses;
}


private static void printTimetable(List<SwimClass> swimClasses) {
    System.out.println("Timetable:");
    for (SwimClass swimClass : swimClasses) {
        System.out.println("Class Name: " + swimClass.getClassName());
        System.out.println("Day: " + swimClass.getClassDay());
        System.out.println("Time: " + swimClass.getClassTime());
        System.out.println("Instructor: " + swimClass.getClassInstructor());
        System.out.println("Number of students allocated: " + swimClass.getClassStNumbers());
        System.out.println("Class Status: " + swimClass.getClassStatus());
        System.out.println();
    }
}

// Method to generate a list of students
public static List<SwimStudent> generateStudents(String[] names, String[] levels, int[] distances, List<SwimClass> swimClasses) {
    List<SwimStudent> students = new ArrayList<>();
    Random random = new Random();

    for (String name : names) {
        String level = levels[random.nextInt(levels.length)];
        int distanceIndex = random.nextInt(distances.length);
        int swimDistance = distances[distanceIndex];

        // Randomly select a SwimClass from the provided list and assign it to the student
        SwimClass allocatedClass = swimClasses.get(random.nextInt(swimClasses.size()));

        SwimStudent student = new SwimStudent(name, level, swimDistance, allocatedClass.getClassName(), "", "");
        students.add(student);
    }

    return students;
}


public static void printStudentList(List<SwimStudent> students, List<Instructor> instructors) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Student List:");
    for (SwimStudent student : students) {
        System.out.println(student.getStudentName() + " - Level: " + student.getStudentLevel());
    }
    System.out.println("--------------------------");

    System.out.println();
    System.out.println();

    System.out.println("Enter student's name to view details:");
    String studentName = scanner.nextLine().trim();

    boolean found = false;
    for (SwimStudent student : students) {
        if (student.getStudentName().equalsIgnoreCase(studentName)) {
            found = true;
            System.out.println("Name: " + student.getStudentName());
            System.out.println("Level: " + student.getStudentLevel());
            System.out.println("Class: " + student.getAllocatedClass());
            System.out.println("Swim Distance: " + student.getSwimDistance());
            System.out.println("Qualification Award: " + student.getQualificationAward());
            System.out.println("Personal Survival Award: " + student.getPersonalSurvivalAward());

            String instructorName = showInstructorByClass(student.getAllocatedClass(), instructors);
            System.out.println("Instructor: " + instructorName);

            System.out.println("--------------------------");
            System.out.println();
            System.out.println();
            break; // Exit loop since we found the student
        }
    }

    if (!found) {
        System.out.println("Student not found!");
        System.out.println();
        System.out.println();
    }
}

public static String showInstructorByClass(String allocatedClass, List<Instructor> instructors) {
    for (Instructor instructor : instructors) {
        if (instructor.getCourseTaken().equalsIgnoreCase(allocatedClass)) {
            return instructor.getInstructorName();
        }
    }
    return "No instructor assigned for this class";
}
public static List<Qualification> generateAwards(List<SwimStudent> students, List<Instructor> instructors) {
    List<Qualification> awards = new ArrayList<>();
    Random random = new Random();

    for (SwimStudent student : students) {
        int swimDistance = student.getSwimDistance();
        String level = student.getStudentLevel();
        String studentName = student.getStudentName();

        // Get a random instructor from the provided list of instructors
        Instructor instructor = instructors.get(random.nextInt(instructors.size()));

        if (level.equals("Novice")) {
            String award = (swimDistance == 5) ? "5-metre award" : (swimDistance == 10) ? "10-metre award" : (swimDistance == 20) ? "20-metre award" : "";
            awards.add(new DistanceSwim(award, student, instructor, swimDistance));
            student.setQualificationAward(award);
        } else if (level.equals("Improver")) {
            String award = (swimDistance == 100) ? "100m award" : (swimDistance == 200) ? "200m award" : (swimDistance == 400) ? "400m award" : "";
            awards.add(new DistanceSwim(award, student, instructor, swimDistance));
            student.setQualificationAward(award);
        } else if (level.equals("Advanced")) {
            String award = (swimDistance == 800) ? "800m award" : (swimDistance == 1500) ? "1500m award" : (swimDistance == 3000) ? "3000m award" : "";
            awards.add(new DistanceSwim(award, student, instructor, swimDistance));
            student.setQualificationAward(award);

            if (swimDistance >= 800) {
                String survivalAward = (swimDistance >= 3000) ? "Gold" : (swimDistance >= 1500) ? "Silver" : "Bronze";
                awards.add(new PersonalSurvival("Personal Survival Award", student, instructor, survivalAward));
                student.setPersonalSurvivalAward(survivalAward);
            }
        }
    }

    return awards;
}




}