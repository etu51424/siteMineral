package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.UserRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.User;
import com.spring.henallux.firstSpringProject.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public User saveUser(User user){
        try {
            UserEntity userEntity = providerConverter.userModelToUserEntity(user);
            userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));
            userEntity.setAuthorities("ROLE_USER");
            userEntity.setAccountNonExpired(true);
            userEntity.setEnabled(true);
            userEntity.setAccountNonLocked(true);
            userEntity.setCredentialsNonExpired(true);
            userRepository.save(userEntity);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    public User updateUser(User user){
        try {
            UserEntity userEntity = providerConverter.userModelToUserEntity(user);

            if (!Utils.isBCryptHash(userEntity.getPassword())) {
                userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));
            }

            userRepository.save(userEntity);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return user;
    }
    public User findByUsername(String username){
        UserEntity userEntity = userRepository.findByUsername(username);
        User userModel = providerConverter.userEntityToUserModel(userEntity);
        return userModel;
    }

    public boolean isUsernameTaken(String username){
        UserEntity userEntity = userRepository.findByUsername(username);
        return userEntity == null;
    }
}
