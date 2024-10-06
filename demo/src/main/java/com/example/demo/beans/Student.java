package com.example.demo.beans;

import lombok.Data;

@Data
public class Student {
    private String fistName;
    private String lastName;
    
    public Student(String firstName, String lastName){
        super();
        this.fistName=firstName;
        this.lastName=lastName;

    }
    
    
}
