package com.spring.henallux.firstSpringProject.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class User implements UserDetails {
    @NotNull
    private String username;
    @NotNull
    private String last_name;
    @NotNull
    private String first_name;
    @NotNull
    private String address;
    @NotNull
    private String email;
    @NotNull
    private String phone_number;
    private char gender;
    private LocalDate birth_date;
    @NotNull
    private String password;
    private String authorities;
    private boolean accountNonExpired;
    private boolean accountNnonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public User(){

    }

    public String getUsername() {
        return username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }
    @Override
    public String getPassword() {
        return password;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grandedAuthorities = new ArrayList<>();
        if (authorities != null && !authorities.isEmpty()){
            String[] authoritiesArray = authorities.split(",");
            for (String authority : authoritiesArray){
                if (authority != null && !authority.isEmpty()){
                    grandedAuthorities.add(new SimpleGrantedAuthority(authority));
                }
            }
        }
        return grandedAuthorities;
    }
    public boolean getAccountNonExpired(){
        return accountNonExpired;
    }
    public boolean getAccountNonLocked(){
        return accountNnonLocked;
    }
    public boolean getCredentialsNonExpired(){
        return credentialsNonExpired;
    }
    public boolean getEnabled(){
        return enabled;
    }
    @Override
    public boolean isAccountNonLocked() {
        return accountNnonLocked;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNnonLocked(boolean accountNnonLocked) {
        this.accountNnonLocked = accountNnonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
