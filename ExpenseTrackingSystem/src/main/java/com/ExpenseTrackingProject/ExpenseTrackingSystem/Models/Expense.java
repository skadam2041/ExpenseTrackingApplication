package com.ExpenseTrackingProject.ExpenseTrackingSystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "expenses")
public class Expense extends BaseModel {
    private int totalAmpount;
    private String description;
    @ManyToOne
    private Group groups;
    @ManyToOne
    private User createdBy;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;


}