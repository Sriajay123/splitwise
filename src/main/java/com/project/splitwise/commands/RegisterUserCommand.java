package com.project.splitwise.commands;

import com.project.splitwise.controllers.UserController;
import com.project.splitwise.dtos.RegisterUserRequestDto;
import com.project.splitwise.dtos.RegisterUserResponseDto;
import com.project.splitwise.dtos.ResponseType;
import com.project.splitwise.exceptions.InvalidCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserCommand implements Command{

    private static final String REGISTER_USER_KEY = "Register";

    UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
        CommandRegistry.getInstance().addCommand(REGISTER_USER_KEY,this);
    }

    @Override
    public void execute(String input) throws InvalidCommandException {



        String[] split = input.split(" ");

        if(split.length!=4){
            throw new InvalidCommandException("Register user command not in correct format");
        }

        RegisterUserRequestDto requestDto=new RegisterUserRequestDto();
        requestDto.setUserName(split[1]);
        requestDto.setPassword(split[3]);
        requestDto.setPhoneNumber(split[2]);
        RegisterUserResponseDto responseDto = userController.registerUser(requestDto);
        if(responseDto.getResponse().getType().equals(ResponseType.FAILURE)){
            System.out.println("Error : "+ responseDto.getResponse().getMessage());
        }
        else {
            System.out.println( responseDto.getUser());
        }



    }
}
