package Consolidated_tasks;

import java.util.*;

class Student {
    String name;
    List<Integer> marks;
    int totalMarks;
    double averageMarks;

    
    public Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = marks;
        this.totalMarks = calculateTotal();
        this.averageMarks = calculateAverage();
    }

    
    private int calculateTotal() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum;
    }

    
    private double calculateAverage() {
        return (double) totalMarks / marks.size();
    }

    
    @Override
    public String toString() {
        return "Name: " + name + ", Total Marks: " + totalMarks + ", Average: " + String.format("%.2f", averageMarks);
    }
}

public class StuAvgMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student's name: ");
            String name = scanner.nextLine();

            System.out.print("Enter number of subjects: ");
            int numSubjects = scanner.nextInt();
            List<Integer> marks = new ArrayList<>();

            System.out.println("Enter marks:");
            for (int j = 0; j < numSubjects; j++) {
                marks.add(scanner.nextInt());
            }
            scanner.nextLine(); 

            students.add(new Student(name, marks));
        }

       
        students.sort((s1, s2) -> s2.totalMarks - s1.totalMarks);

       
        System.out.println("\nSorted Student List (by Total Marks in Descending Order):");
        for (Student student : students) {
            System.out.println(student);
        }

        scanner.close();
    }
}
