package com.grooming.jobrole.model;

import com.grooming.jobrole.enums.TechStack;
import com.grooming.jobrole.service.CalculateIncrement;

public class Applicant {
    private TechStack jobRole;
    private float experience;
    private Long currentSalary;
    public Applicant(String jobRole, float experience, Long currentSalary) {
        setJobRole(jobRole);
        setExperience(experience);
        setCurrentSalary(currentSalary);
    }
    public TechStack getJobRole() {
        return jobRole;
    }
    public float getExperience() {
        return experience;
    }
    public Long getCurrentSalary() {
        return currentSalary;
    }
    public void setJobRole(String jobRole){
        this.jobRole=CalculateIncrement.isValidTech(jobRole);
            
    }
    public void setExperience(float experience){
        this.experience=CalculateIncrement.isValidExperience(jobRole,experience);
    }

    public void setCurrentSalary(Long currentSalary){
        this.currentSalary=CalculateIncrement.isValidSalary(currentSalary);
    }

    public double getExpectedSalary(){
        double expectedSalary= CalculateIncrement.expectedSalary(jobRole,currentSalary);
        return expectedSalary;
    }
}
