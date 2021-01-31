package com.valid.admin.mapper;


import com.valid.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    public Account getAccountById(Long id);
}
