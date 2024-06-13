package com.project.splitwise.services;

import com.project.splitwise.exceptions.RegisterUserException;
import com.project.splitwise.models.User;

public interface UserService {

    public User registerUser(String userName, String password, String phoneNumber) throws RegisterUserException;
}
