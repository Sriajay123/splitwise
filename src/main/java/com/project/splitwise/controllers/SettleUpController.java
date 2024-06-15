package com.project.splitwise.controllers;

import com.project.splitwise.dtos.Response;
import com.project.splitwise.dtos.SettleGroupRequestDto;
import com.project.splitwise.dtos.SettleGroupResponseDto;
import com.project.splitwise.exceptions.InvalidRequestException;
import com.project.splitwise.models.Transaction;
import com.project.splitwise.services.SettleUpService;

import java.util.List;

public class SettleUpController {

   private  SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    public SettleGroupResponseDto settleGroup(SettleGroupRequestDto requestDto){
        SettleGroupResponseDto responseDto=new SettleGroupResponseDto();

        try {
            if(requestDto.getGroupID()<0){
                throw new InvalidRequestException("Invalid group id");
            }
            List<Transaction> transactions = settleUpService.settleGroup(requestDto.getGroupID());
            responseDto.setTransactions(transactions);
            responseDto.setResponse(Response.getSuccessResponse());

        }
        catch (Exception e){
            Response response=Response.getFailureResponse(e.getMessage());
            responseDto.setResponse(response);
        }

        return responseDto;
    }
}
