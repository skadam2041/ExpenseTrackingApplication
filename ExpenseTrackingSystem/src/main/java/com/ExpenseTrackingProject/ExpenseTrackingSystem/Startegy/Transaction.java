package com.ExpenseTrackingProject.ExpenseTrackingSystem.Startegy;

import com.ExpenseTrackingProject.ExpenseTrackingSystem.Models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private User from;
    private User to;
    private Integer amount;
}