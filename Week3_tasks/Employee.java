package Consolidated_tasks;

import java.util.Scanner;

public class Employee {
    private int empId;
    private String empName;
    private double monthlySalary;
    private int yearsOfExperience;

    // Constructor
    public Employee(int empId, String empName, double monthlySalary, int yearsOfExperience) {
        this.empId = empId;
        this.empName = empName;
        this.monthlySalary = monthlySalary;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Method to get employee details
    public void getEmployeeDetails() {
        System.out.println("\nEmployee Details:");
        System.out.println("ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Monthly Salary: ₹" + monthlySalary);
        System.out.println("Experience: " + yearsOfExperience + " years");
        System.out.println("Loan Eligibility: Rs" + getLoanEligibility());
    }

    // Method to set new employee details
    public void setEmployeeDetails(int empId, String empName, double monthlySalary, int yearsOfExperience) {
        this.empId = empId;
        this.empName = empName;
        this.monthlySalary = monthlySalary;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Method to check loan eligibility
    public double getLoanEligibility() {
        double annualSalary = monthlySalary * 12;

        if (yearsOfExperience > 5) {
            if (annualSalary >= 1500000) {
                return 700000; 
            } else if (annualSalary >= 1000000) {
                return 500000;
            } else if (annualSalary >= 600000) {
                return 200000; 
            }
        }
        return 0; 
    }
}
