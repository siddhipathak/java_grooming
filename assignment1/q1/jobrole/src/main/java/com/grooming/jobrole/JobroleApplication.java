package com.grooming.jobrole;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grooming.jobrole.exception.InvalidInputException;
import com.grooming.jobrole.model.Applicant;

@SpringBootApplication
public class JobroleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobroleApplication.class, args);
		Scanner s=new Scanner(System.in);
        System.out.println("Enter your tech stack:");
        String tech=s.nextLine();
      
        System.out.println("Enter your experience in years :");
        float experience=s.nextInt();
      
        System.out.println("Enter your current salary :");
        Long currSalary= s.nextLong();
		s.close();
		try{
			Applicant applicant= new Applicant(tech, experience, currSalary);
			System.out.println("Expected salary for the job role is:"+applicant.getExpectedSalary());
		}catch(Exception e)
		{
			throw new InvalidInputException("Job details did not match the requirement!");
		}
		
	}

	}


