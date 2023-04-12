package assignment1.q2;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GenerateUsername {
    private String name;
    private String dob;
    private String aadhar;

    GenerateUsername(String name, String dob, String aadhar){
        this.name=name;
        this.dob=dob;
        this.aadhar=aadhar;
    }
    
    public static boolean isValidAadhar(String aadhar){
        if(aadhar ==null || aadhar.length()!=12 || !aadhar.matches("[0-9]+")) 
            throw new InvalidInputException("Not a valid input. Please enter 12 digit aadhar number");
        return true;
    }
    public static boolean isValidDob(String dob){
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
        format.parse(dob);
        }catch(Exception e)
        {
            throw new InvalidInputException("Not a valid format. Please enter dd-mm-yyyy format");
        }
        return true;
    }

    public static boolean isValidName(String name) {
        if (name.length()==0 || !name.matches( "[A-Z][a-zA-Z]*" ))
            throw new InvalidInputException("Not a valid input.Please enter full name");
        return true;
    }


    public String userName(){
        String username="";

        for(int i=0;i<name.length();i++)
        {   if(name.charAt(i)==' ')
                continue;
            if(username.length()==4)
                break;
            username+=name.charAt(i);
        }
        username+= dob.substring(0,2);
        username+=dob.substring(6);
        username+= aadhar.substring(8);
        
        return username;

    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        
        System.out.println("Enter your full name :");
        String name=s.nextLine();
        isValidName(name.trim());
    
        System.out.println("Enter your dob in dd-mm-yyyy format :");
        String dob=s.nextLine();
        isValidDob(dob);

        System.out.println("Enter your aadhar number :");
        String aadhar=s.nextLine();
        isValidAadhar(aadhar);
           
        s.close();
        GenerateUsername generateUsername= new GenerateUsername(name, dob, aadhar);
        System.out.println("Username is:"+ generateUsername.userName());
        }
       
}
