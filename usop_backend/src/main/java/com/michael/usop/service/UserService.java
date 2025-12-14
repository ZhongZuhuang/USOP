package com.michael.usop.service;

import com.michael.usop.entity.Users;
import com.michael.usop.mapper.UsersMapper;
import org.springframework.stereotype.Service; // 必须加这个注解！

// @Service：让 Spring 扫描并管理这个类，才能注入 userMapper
@Service
public class UserService {

    private final UsersMapper userMapper;
    public UserService(UsersMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Users getUserById(Integer id) {
        try {
            return userMapper.selectById(id);
        } catch (NullPointerException e) {
            return null;
        }
    }

    public int insertUser(Users user) {
        userMapper.insert(user);
        return user.getId();
    }

    public String deleteUserById(Integer id) {
        try {
            String username = userMapper.selectById(id).getUsername();
            userMapper.deleteById(id);
        return username;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public Integer updateUserById(Integer id, Users user) {
        user.setId(id);
        userMapper.updateById(user);
        return id;
    }

}