package com.example.springjpa.service;

import com.example.springjpa.model.entity.Account;
import com.example.springjpa.model.request.AccountLogin;
import com.example.springjpa.model.request.AccountRequest;

import java.util.List;

public interface IAccountService {
    Account getAccount(Long id);

    List<Account> getAll();

    Account login(AccountLogin request);

    Account create(AccountRequest request);


    Account update(Long id, AccountRequest request);

    Account delete(Long id, AccountRequest request);

}
