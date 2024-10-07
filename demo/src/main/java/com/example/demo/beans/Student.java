package com.example.demo.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Student {
    private String fistName;
    private String lastName;
    
    public Student() {
        
    }

   
    @JsonCreator
    public Student(@JsonProperty("firstName") String firstName, 
                   @JsonProperty("lastName") String lastName) {
        this.fistName = firstName;
        this.lastName = lastName;
    }
    
    
}
