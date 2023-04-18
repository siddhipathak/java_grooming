package com.example.q1_;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.q1_.enums.EmployementType;
import com.example.q1_.enums.Status;
import com.example.q1_.models.Employee;
import com.example.q1_.service.EmployeeService;

@SpringBootApplication
public class Q1Application {

	public static void main(String[] args) {
		SpringApplication.run(Q1Application.class, args);
		try{
		Scanner s= new Scanner(System.in);
		EmployeeService employeeService= new EmployeeService();
		Employee e1= new Employee(1, "Siddhi", "25/07/1999",EmployementType.FULL_TIME,Status.ACTIVE,"developer");
		Employee e2= new Employee(2, "Sid", "25/07/2023",EmployementType.FULL_TIME,Status.ACTIVE,"devops");
		Employee e3= new Employee(3, "Sejal", "25/07/2021",EmployementType.FULL_TIME,Status.ACTIVE,"qa");

		//adding employee details
		employeeService.addEmployee(1,e1);
		employeeService.addEmployee(2,e2);
		employeeService.addEmployee(3,e3);
		// Printing all employees list
		employeeService.getEmployees();

		//changing status of employee
		System.out.println("Enter the employee ID of the employee you want to delete");
		int id= s.nextInt();
		System.out.println("Employee status has been changed to EXIT "+ employeeService.deleteEmployee(id));
		
		//changing employement type of employee
		System.out.println("Enter the employee id and and employement type that you want to change");
		System.out.println("Enter id");
		int empid=s.nextInt();
		s.nextLine();
		System.out.println("Enter enrollemnet type");
		String enType=s.nextLine();
		System.out.println(employeeService.updateEmployementType(empid, enType));
		
		// changing role of employee
		System.out.println("Enter the employee id and and role that you want to change");
		System.out.println("Enter id");
		int eid=s.nextInt();
		s.nextLine();
		System.out.println("Enter role");
		String role=s.nextLine();
		System.out.println(employeeService.updateRole(eid, role));

		//chnaging status of employee
		System.out.println("Enter the employee status that you are looking for");
		String status= s.nextLine();
		System.out.println(employeeService.getEmployeesStatus(status));
		
		//Printing senior most employee
		System.out.println("The senior most employee");
		employeeService.getSeniorEmployee();
		
		s.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
