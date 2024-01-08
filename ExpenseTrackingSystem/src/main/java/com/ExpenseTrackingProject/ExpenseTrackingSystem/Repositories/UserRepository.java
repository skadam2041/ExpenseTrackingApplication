package com.ExpenseTrackingProject.ExpenseTrackingSystem.Repositories;

import com.ExpenseTrackingProject.ExpenseTrackingSystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long aLong);

    Optional<User> findByPhone(String phone);
//    findByFirsName(String name);

    User save(User user);
}