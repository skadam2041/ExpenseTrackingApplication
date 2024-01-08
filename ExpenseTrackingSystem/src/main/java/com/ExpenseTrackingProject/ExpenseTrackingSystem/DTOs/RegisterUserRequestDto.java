package com.ExpenseTrackingProject.ExpenseTrackingSystem.DTOs;


import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    private String password;
    private String phoneNumber;
    private String userName;
}