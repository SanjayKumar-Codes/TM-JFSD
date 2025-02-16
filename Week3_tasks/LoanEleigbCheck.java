package Consolidated_tasks;

import java.util.Scanner;

public class LoanEleigbCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking employee details as input
        System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Employee Name: ");
        String empName = scanner.nextLine();

        System.out.print("Enter Monthly Salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Enter Years of Experience: ");
        int experience = scanner.nextInt();

        // Creating Employee Object
        Employee emp = new Employee(empId, empName, salary, experience);

        // Displaying Employee Details & Loan Eligibility
        emp.getEmployeeDetails();

        scanner.close();
    }
}

