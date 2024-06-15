package com.project.splitwise.repositories;

import com.project.splitwise.models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupExpenseRepository extends JpaRepository<GroupExpense,Integer> {

    List<GroupExpense> findAllByGroupid(int groupId);
}
