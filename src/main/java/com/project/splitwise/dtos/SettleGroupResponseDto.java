package com.project.splitwise.dtos;

import com.project.splitwise.models.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class SettleGroupResponseDto {

    private Response response;

    private List<Transaction> transactions;
}
