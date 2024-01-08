package com.ExpenseTrackingProject.ExpenseTrackingSystem.DTOs;

import com.ExpenseTrackingProject.ExpenseTrackingSystem.Startegy.Transaction;

import java.util.List;

public class SettleUpGroupResponseDto {
    String message;
    String status;
    List<Transaction> transactions;
}
