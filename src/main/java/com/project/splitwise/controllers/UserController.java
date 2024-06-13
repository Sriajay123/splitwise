package com.project.splitwise.controllers;

import com.project.splitwise.dtos.RegisterUserRequestDto;
import com.project.splitwise.dtos.RegisterUserResponseDto;
import com.project.splitwise.dtos.Response;
import com.project.splitwise.exceptions.InvalidRequestException;
import com.project.splitwise.models.User;
import com.project.splitwise.services.UserService;
import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto requestDto){

        RegisterUserResponseDto responseDto=new RegisterUserResponseDto();
        try {
            validateRequest(requestDto);
            User user = userService.registerUser(requestDto.getUserName(), requestDto.getPassword(), requestDto.getPhoneNumber());
            responseDto.setUser(user);
            responseDto.setResponse(Response.getSuccessResponse());

        }
        catch (Exception e) {
           responseDto.setResponse(Response.getFailureResponse(e.getMessage()));
        }


        return  responseDto;

    }

    private void validateRequest(RegisterUserRequestDto requestDto) throws InvalidRequestException {
      if(requestDto.getUserName()==null ||requestDto.getPassword()==null ||requestDto.getPhoneNumber()==null){
          throw new InvalidRequestException("username or password or phone number cannot be null");
      }

    }


}
