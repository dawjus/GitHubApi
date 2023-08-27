package com.example.recruitment.exceptions;
import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException( String userName){

        super( "Error 404 " +
                "\nUser: " + userName + " not found");
    }

}
