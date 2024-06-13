package com.project.splitwise.repositories;

import com.project.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface  UserRepository extends JpaRepository<User,Integer> {

  public  Optional<User> findUserByuserNameEqualsOrPhoneNumber(String username, String phoneNumber);




}
