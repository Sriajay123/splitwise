package com.project.splitwise.strategies.settle_up;

import com.project.splitwise.models.Transaction;
import com.project.splitwise.models.User;

import java.util.List;
import java.util.Map;

public interface SettleUpStrategy {

    List<Transaction> settleUp(Map<User,Double> userTotal);
}
