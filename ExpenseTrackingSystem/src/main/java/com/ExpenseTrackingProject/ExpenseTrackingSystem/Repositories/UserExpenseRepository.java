package com.ExpenseTrackingProject.ExpenseTrackingSystem.Repositories;

import com.ExpenseTrackingProject.ExpenseTrackingSystem.Models.Expense;
import com.ExpenseTrackingProject.ExpenseTrackingSystem.Models.User;
import com.ExpenseTrackingProject.ExpenseTrackingSystem.Models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense, Long> {

    List<UserExpense> findAllByUser(User user);

    List<UserExpense> findAllByExpenseIn(List<Expense> expenses);
}