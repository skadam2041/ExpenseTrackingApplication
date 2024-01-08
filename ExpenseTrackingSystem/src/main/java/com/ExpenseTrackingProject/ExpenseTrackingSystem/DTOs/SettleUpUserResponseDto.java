package com.ExpenseTrackingProject.ExpenseTrackingSystem.DTOs;

import com.ExpenseTrackingProject.ExpenseTrackingSystem.Startegy.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDto {
    String message;
    String status;
    List<Transaction> transactions;
}