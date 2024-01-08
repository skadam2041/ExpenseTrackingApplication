package com.ExpenseTrackingProject.ExpenseTrackingSystem.Repositories;


import com.ExpenseTrackingProject.ExpenseTrackingSystem.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Override
    Optional<Group> findById(Long aLong);
}