package com.ExpenseTrackingProject.ExpenseTrackingSystem.Repositories;


import com.ExpenseTrackingProject.ExpenseTrackingSystem.Models.Expense;
import com.ExpenseTrackingProject.ExpenseTrackingSystem.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByGroups(Group group);
}