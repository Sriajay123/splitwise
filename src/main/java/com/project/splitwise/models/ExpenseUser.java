package com.project.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class ExpenseUser {
    @ManyToOne
    private Expense expense;
    @ManyToOne
    private User user;
    private double amount;
    @Enumerated(value = EnumType.ORDINAL)
    private ExpenseType expenseType;
}
