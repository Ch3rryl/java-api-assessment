package com.cbfacademy.apiassessment.Model;

import java.util.UUID;

public class Employee {

    private final UUID id; 
    private String name;
    private String jobTitle;
    private double salary; 
    private Boolean trainingComplete;

    public Employee(String name, String jobTitle, double salary, Boolean trainingComplete) {

        this.id = UUID.randomUUID();
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.trainingComplete = trainingComplete;
    }


// autogenerated id so only a getter required
public UUID getId() {
    return id;
}

public String getName() {
    return name; 
}

public void setName(String newName) {
    this.name = newName;
}

public String getJobTitle() {
    return jobTitle;
}

public void setJobtitle(String newJobTitle) {
    this.jobTitle = newJobTitle; 
}

public double getSalary() {
    return salary;
}

public void setSalary(String newSalary) {
    this.salary = newSalary;
}

public boolean getTrainingComplete() {
    return trainingComplete;
}

public void setTrainingComplete(boolean newTrainingComplete) {
    this.trainingComplete = newTrainingComplete; 
}





}

// keys: name, id, job title, salary, training complete, 
