package com.ExpenseTrackingProject.ExpenseTrackingSystem.Exceptions;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
