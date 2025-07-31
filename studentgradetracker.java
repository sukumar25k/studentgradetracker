import java.util.ArrayList;
import java.util.Scanner;

public class studentgradetracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> gradeList = new ArrayList<>();
        int userChoice;

        System.out.println("=== Welcome to the Student Grade Tracker ===");

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1 -> addGrade(scanner, gradeList);
                case 2 -> computeAndDisplayAverage(gradeList);
                case 3 -> displayHighestGrade(gradeList);
                case 4 -> displayLowestGrade(gradeList);
                case 5 -> displayAllGrades(gradeList);
                case 6 -> System.out.println("Thank you for using the Student Grade Tracker. Goodbye!");
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }

        } while (userChoice != 6);

        scanner.close();
    }

    // Display the main menu
    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add a student grade");
        System.out.println("2. Compute average grade");
        System.out.println("3. Find highest grade");
        System.out.println("4. Find lowest grade");
        System.out.println("5. Display all grades");
        System.out.println("6. Exit");
    }

    // Add a grade to the list
    private static void addGrade(Scanner scanner, ArrayList<Integer> grades) {
        System.out.print("Enter the grade to add: ");
        int grade = scanner.nextInt();
        if (grade < 0 || grade > 100) {
            System.out.println("Please enter a valid grade between 0 and 100.");
        } else {
            grades.add(grade);
            System.out.println("Grade added successfully.");
        }
    }

    // Compute and print average
    private static void computeAndDisplayAverage(ArrayList<Integer> grades) {
        if (grades.isEmpty()) {
            System.out.println("No grades available to compute the average.");
            return;
        }
        double average = calculateAverage(grades);
        System.out.printf("The average grade is: %.2f%n", average);
    }

    // Display the highest grade
    private static void displayHighestGrade(ArrayList<Integer> grades) {
        if (grades.isEmpty()) {
            System.out.println("No grades available to find the highest grade.");
            return;
        }
        int highest = findHighest(grades);
        System.out.println("The highest grade is: " + highest);
    }

    // Display the lowest grade
    private static void displayLowestGrade(ArrayList<Integer> grades) {
        if (grades.isEmpty()) {
            System.out.println("No grades available to find the lowest grade.");
            return;
        }
        int lowest = findLowest(grades);
        System.out.println("The lowest grade is: " + lowest);
    }

    // Display all grades
    private static void displayAllGrades(ArrayList<Integer> grades) {
        if (grades.isEmpty()) {
            System.out.println("No grades to display.");
            return;
        }
        System.out.println("Student Grades: " + grades);
    }

    // Helper: Calculate average
    private static double calculateAverage(ArrayList<Integer> grades) {
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return (double) total / grades.size();
    }

    // Helper: Find highest
    private static int findHighest(ArrayList<Integer> grades) {
        int max = grades.get(0);
        for (int grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        return max;
    }

    // Helper: Find lowest
    private static int findLowest(ArrayList<Integer> grades) {
        int min = grades.get(0);
        for (int grade : grades) {
            if (grade < min) {
                min = grade;
            }
        }
        return min;
    }
}
