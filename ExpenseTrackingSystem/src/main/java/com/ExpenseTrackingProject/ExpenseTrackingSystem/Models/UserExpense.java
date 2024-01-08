package com.ExpenseTrackingProject.ExpenseTrackingSystem.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user_expenses")
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user;
    @ManyToOne
    private Expense expense;
    private int amount;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private UserExpenseType userExpenseType;
}
