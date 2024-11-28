package com.spring.henallux.firstSpringProject.model;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {
    @NotNull
    private String username;
    @NotNull
    private String lastName;
    @NotNull
    private String firstName;
    @NotNull
    private String address;
    @NotNull
    private String email;
    @NotNull
    private String phoneNumber;
    private Character gender;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    @NotNull
    private String password;
    private String authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public User(){

    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Character getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
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
        return accountNonLocked;
    }
    public boolean getCredentialsNonExpired(){
        return credentialsNonExpired;
    }
    public boolean getEnabled(){
        return enabled;
    }
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
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

    @Override
    public String toString() {
        return getPassword();
    }
}
