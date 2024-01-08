package com.ExpenseTrackingProject.ExpenseTrackingSystem.Services;

import com.ExpenseTrackingProject.ExpenseTrackingSystem.Models.Expense;
import com.ExpenseTrackingProject.ExpenseTrackingSystem.Models.Group;
import com.ExpenseTrackingProject.ExpenseTrackingSystem.Models.User;
import com.ExpenseTrackingProject.ExpenseTrackingSystem.Models.UserExpense;
import com.ExpenseTrackingProject.ExpenseTrackingSystem.Repositories.ExpenseRepository;
import com.ExpenseTrackingProject.ExpenseTrackingSystem.Repositories.GroupRepository;
import com.ExpenseTrackingProject.ExpenseTrackingSystem.Repositories.UserExpenseRepository;
import com.ExpenseTrackingProject.ExpenseTrackingSystem.Repositories.UserRepository;
import com.ExpenseTrackingProject.ExpenseTrackingSystem.Startegy.SettleUpStrategy;
import com.ExpenseTrackingProject.ExpenseTrackingSystem.Startegy.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private UserRepository userRepository;
    private UserExpenseRepository userExpenseRepository;
    private SettleUpStrategy settleUpStrategy;
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(UserRepository userRepository,
                          UserExpenseRepository userExpenseRepository,
                          SettleUpStrategy settleUpStrategy,
                          GroupRepository groupRepository,
                          ExpenseRepository expenseRepository) {
        this.userRepository = userRepository;
        this.userExpenseRepository = userExpenseRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.expenseRepository = expenseRepository;
        this.groupRepository = groupRepository;
    }

    public List<Transaction> settleUpUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        List<UserExpense> userExpenses = userExpenseRepository.findAllByUser(userOptional.get());

        List<Expense> expensesInvolvingUser = new ArrayList<>();
        for (UserExpense userExpense: userExpenses) {
            expensesInvolvingUser.add(userExpense.getExpense());
        }

        List<Transaction> transactions = settleUpStrategy.settleUp(expensesInvolvingUser);

        List<Transaction> filteredTransactions = new ArrayList<>();

        for (Transaction transaction: transactions) {
            if (transaction.getFrom().equals(userOptional.get()) || transaction.getTo().equals(userOptional.get())) {
                filteredTransactions.add(transaction);
            }
        }

        return filteredTransactions;
    }

    public List<Transaction> settleUpGroup(Long groupId) {
        Optional<Group> groupOptional = groupRepository.findById(groupId);

        if (groupOptional.isEmpty()) {
            // throw nexception
            return null;
        }

        List<Expense> expenses = expenseRepository.findAllByGroups(groupOptional.get());

        List<Transaction> transactions = settleUpStrategy.settleUp(expenses);

        return transactions;
    }


}
