package com.grooming.jobrole.enums;

public enum TechStack{
    JAVA(8,"Manager",0.45),
    SAP(4,"Sr.Associate",0.3),
    QA(3,"Associate",0.2);
    
    private int minexperience;  
    private String position;
    private double increment;

    TechStack(int minexperience, String position,double increment){  
    this.minexperience=minexperience;  
    this.position=position;
    this.increment=increment;
    }  

    public int getMinExperience(){
        return this.minexperience;
    }

    public String getPosition(){
        return this.position;
    }

    public double getIncrement(){
        return this.increment;
    }

    
}
