package com.ufr.croissantshow.exception;

public class NullUserObject extends Exception{
    public NullUserObject(){
        super("User object null (NPE)");
    }
}
