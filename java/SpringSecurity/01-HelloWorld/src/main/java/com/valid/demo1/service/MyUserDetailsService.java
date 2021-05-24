package com.valid.demo1.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.valid.demo1.entity.Users;
import com.valid.demo1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        Users user = mapper.selectOne(wrapper);

        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_sale");
        return new User(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), auths);
    }
}
