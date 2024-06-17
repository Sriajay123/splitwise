package com.project.splitwise.repositories;

import com.project.splitwise.models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupExpenseRepository extends JpaRepository<GroupExpense,Integer> {

    List<GroupExpense> findAllByGroupId(int groupId);

}
