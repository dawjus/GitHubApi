package com.example.recruitment.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String userName){
        super("User: " + userName + " not found");
    }

}
