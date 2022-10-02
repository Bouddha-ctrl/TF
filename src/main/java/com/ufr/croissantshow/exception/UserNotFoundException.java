package com.ufr.croissantshow.exception;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(){
        super("User not found");
    }
}
