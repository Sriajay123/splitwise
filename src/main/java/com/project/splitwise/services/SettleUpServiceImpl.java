package com.project.splitwise.services;

import com.project.splitwise.exceptions.InvalidRequestException;
import com.project.splitwise.models.*;
import com.project.splitwise.repositories.GroupExpenseRepository;
import com.project.splitwise.repositories.GroupRepository;
import com.project.splitwise.strategies.settle_up.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SettleUpServiceImpl implements SettleUpService{
    
    private GroupRepository groupRepository;
    private GroupExpenseRepository groupExpenseRepository;
    private SettleUpStrategy settleUpStrategy;
    
    @Override
    public List<Transaction> settleGroup(int groupId) throws InvalidRequestException {

     Group group=groupRepository.findById(groupId).orElseThrow(() ->new InvalidRequestException("Invalid group id"));
        List<GroupExpense> groupExpenses = groupExpenseRepository.findAllByGroupId(groupId);
        List<Expense> expenses = groupExpenses.stream().map(GroupExpense::getExpense).toList();

        Map<User, Double> userTotal = new HashMap<>();

        for(Expense exp:expenses) {
            for (ExpenseUser expenseUser : exp.getExpenseUsers()) {
                userTotal.put(expenseUser.getUser(),userTotal.getOrDefault(expenseUser.getUser(),0D)+
                        ((expenseUser.getExpenseType().equals(ExpenseType.PAID) ? 1:-1))* expenseUser.getAmount());

            }

        }



        return settleUpStrategy.settleUp(userTotal);
    }
}
