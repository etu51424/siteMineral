package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.User;

public interface UserDataAccess {
    public User findByUsername(String username);
}
