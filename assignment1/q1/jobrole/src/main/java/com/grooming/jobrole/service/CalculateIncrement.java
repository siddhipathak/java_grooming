package com.grooming.jobrole.service;

import com.grooming.jobrole.enums.TechStack;
import com.grooming.jobrole.exception.InvalidInputException;

public class CalculateIncrement {
    public static TechStack isValidTech(String jobRole) {
        TechStack result=null;
    for (TechStack tech : TechStack.values()) {
        if (tech.name().equalsIgnoreCase(jobRole)) {
            result = tech;
            break;
        }
    }
    if(result==null)
        throw new InvalidInputException("Tech Stack not found");
    return result;
}

    public static float isValidExperience(TechStack tech, float experience){
        if(tech.getMinExperience()> experience)
            throw new InvalidInputException("Minimum expericence for the job did not match the criteria!");
        return experience;
    }

    public static double expectedSalary(TechStack jobRole,Long currentSalary){
        double salary= (currentSalary +(currentSalary* jobRole.getIncrement()));
        return salary;
    }

    public static Long isValidSalary(Long currentSalary) {
        
        return null;
    }
    
}