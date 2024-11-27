package com.spring.henallux.firstSpringProject.dataAccess.util;

import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.model.User;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {
    private DozerBeanMapper dozerBeanMapper;

    public ProviderConverter(){
        this.dozerBeanMapper = new DozerBeanMapper();
    }

    public User userEntityToUserModel(UserEntity userEntity){
        User user = dozerBeanMapper.map(userEntity, User.class);
        user.setAccountNonExpired(userEntity.getAccountNonExpired());
        user.setAuthorities(userEntity.getAuthorities());
        user.setAccountNnonLocked(userEntity.getAccountNonLocked());
        user.setEnabled(userEntity.getEnabled());
        user.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
        return user;
    }
    public UserEntity userModelToUserEntity (User useModel){
        return dozerBeanMapper.map(useModel, UserEntity.class);
    }

    public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper) {
        this.dozerBeanMapper = dozerBeanMapper;
    }

    public DozerBeanMapper getDozerBeanMapper() {
        return dozerBeanMapper;
    }
}
