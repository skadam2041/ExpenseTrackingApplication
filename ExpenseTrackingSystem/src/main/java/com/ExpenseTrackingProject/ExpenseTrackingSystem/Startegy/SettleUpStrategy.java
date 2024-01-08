package com.ExpenseTrackingProject.ExpenseTrackingSystem.Startegy;

import com.ExpenseTrackingProject.ExpenseTrackingSystem.Models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    public List<Transaction> settleUp(List<Expense> expenses);
}
