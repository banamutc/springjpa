package com.example.springjpa.controller;

import com.example.springjpa.model.entity.Account;
import com.example.springjpa.model.request.AccountLogin;
import com.example.springjpa.model.request.AccountRequest;
import com.example.springjpa.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {
    @Autowired
    private IAccountService service;

    @PostMapping("/login")
    ResponseEntity<Account> login(@RequestBody AccountLogin request) {
        Account account = service.login(request);
        if (account == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(account);
    }

    @GetMapping("/ALL")
    ResponseEntity<List<Account>> getAll() {
        List<Account> accounts = service.getAll();
        return ResponseEntity.ok(accounts);
    }

    @PostMapping("/cre")
    ResponseEntity<Account> create(@RequestBody AccountRequest request) {
        Account account = service.create(request);
        return ResponseEntity.ok(account);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Account> update(@PathVariable(name = "id") Long id, @RequestBody AccountRequest request) {
        Account response1 = service.update(id, request);
        return ResponseEntity.ok(response1);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Account> delete(@PathVariable(name = "id") Long id, @RequestBody AccountRequest request) {
        Account response2 = service.delete(id,request);
        return ResponseEntity.ok(response2);
    }
}
