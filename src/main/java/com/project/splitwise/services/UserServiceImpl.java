package com.project.splitwise.services;

import com.project.splitwise.exceptions.RegisterUserException;
import com.project.splitwise.models.User;
import com.project.splitwise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(String userName, String password, String phoneNumber) throws RegisterUserException {
        Optional<User> existingUserCheck = this.userRepository.findUserByuserNameEqualsOrPhoneNumber(userName, phoneNumber);
        if(existingUserCheck.isPresent()){
            throw new RegisterUserException("User already registered!");
        }
        User user=new User();
        user.setUserName(userName);
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String encoderPassword  = encoder.encode(password);
        user.setPassword(encoderPassword );
        user.setPhoneNumber(phoneNumber);
        return userRepository.save(user);
    }
}
