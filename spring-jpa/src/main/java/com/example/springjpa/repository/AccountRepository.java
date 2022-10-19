package com.example.springjpa.repository;

import com.example.springjpa.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.orm.jpa.vendor.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsernameAndPassword(String username, String password);
    Optional<Account> findAccountByUsername(String username);
    List<Account> findAll();

    List<Account> accounts = new ArrayList<>(){
    };

//    @Query("select *from account")


}
