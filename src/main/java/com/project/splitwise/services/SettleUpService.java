package com.project.splitwise.services;

import com.project.splitwise.exceptions.InvalidRequestException;
import com.project.splitwise.models.Transaction;

import java.util.List;

public interface SettleUpService {
    List<Transaction> settleGroup(int groupId) throws InvalidRequestException;
}
