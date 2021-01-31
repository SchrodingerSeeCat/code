package com.valid.admin.service.impl;

import com.valid.admin.bean.Account;
import com.valid.admin.mapper.AccountMapper;
import com.valid.admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    public Account getAccountById(Long id){
        return accountMapper.getAccountById(id);
    }
}
