package com.project.splitwise.dtos;

import com.project.splitwise.models.User;
import lombok.Data;


@Data
public class RegisterUserResponseDto {

    private User user;
    private Response response;




}
