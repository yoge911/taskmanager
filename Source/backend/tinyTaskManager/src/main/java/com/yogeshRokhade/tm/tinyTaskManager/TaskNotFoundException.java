package com.yogeshRokhade.tm.tinyTaskManager;

public class TaskNotFoundException extends RuntimeException {
    public  TaskNotFoundException(String message){
        super(message);
    }
}
