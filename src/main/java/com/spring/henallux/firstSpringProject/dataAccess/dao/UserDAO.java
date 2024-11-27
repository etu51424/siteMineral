package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.UserRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDAO implements UserDataAccess {
    private UserRepository userRepository;
    private ProviderConverter providerConverter;
    @Autowired
    public UserDAO(UserRepository userRepository, ProviderConverter providerConverter){
        this.userRepository = userRepository;
        this.providerConverter = providerConverter;
    }
    public User findByUsername(String username){
        UserEntity userEntity = userRepository.findByUsername(username);
        User userModel = providerConverter.userEntityToUserModel(userEntity);
        return userModel;
    }
}
