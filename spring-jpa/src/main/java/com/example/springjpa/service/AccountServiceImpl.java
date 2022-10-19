package com.example.springjpa.service;

import com.example.springjpa.model.entity.Account;
import com.example.springjpa.model.request.AccountLogin;
import com.example.springjpa.model.request.AccountRequest;
import com.example.springjpa.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public Account getAccount(Long id) {
        return null;
    }

    @Override
    public List<Account> getAll() {
        return repository.findAll();
    }

    @Override
    public Account login(AccountLogin request) {
        Optional<Account> account = repository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (account.isEmpty()) {
            log.error("username and password are not match");
            return null;
        }
        return account.get();
    }

    @Override
    public Account create(AccountRequest request) {
        Account account = new Account();
        account.setName(request.getName());
        account.setUsername(request.getUsername());
        account.setPassword(request.getPassword());
        account.setProfileId(request.getProfileId());
        repository.save(account);
        return account;
    }

    @Override
    public Account delete(Long id,AccountRequest request) {
        Account accounts = repository.getReferenceById(Long.valueOf(id));
        accounts.hashCode();
        return new Account();
    }


    @Override
    public Account update(Long id, AccountRequest request) {
        Account accounts = repository.getReferenceById(id);
        accounts.setUsername(request.getUsername());
        accounts.setPassword(request.getPassword());
        accounts.setProfileId(request.getProfileId());
        accounts.setName(request.getName());
        repository.save(accounts);
        return new Account();
    }




}
