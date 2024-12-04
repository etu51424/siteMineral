package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="person")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="username", unique = true)
    private String username;
    @Column(name="last_name")
    private String lastName;
    @Column(name="first_name")
    private String firstName;
    @Column(name="address")
    private String address;
    @Column(name="email")
    private String email;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="gender")
    private Character gender;
    @Column(name="birth_date")
    private LocalDate birthDate;
    @Column(name="password")
    private String password;
    @Column(name="authorities")
    private String authorities;
    @Column(name="non_expired")
    private boolean accountNonExpired;
    @Column(name="non_locked")
    private boolean accountNonLocked;
    @Column(name="credentials_non_expired")
    private boolean credentialsNonExpired;
    @Column(name="enabled")
    private boolean enabled;

    public UserEntity(){

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
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

    public String getPassword() {
        return password;
    }

    public String getAuthorities() {
        return authorities;
    }
    public boolean getAccountNonLocked (){
        return accountNonLocked;
    }
    public boolean getAccountNonExpired (){
        return accountNonExpired;
    }
    public boolean getCredentialsNonExpired (){
        return credentialsNonExpired;
    }
    public boolean getEnabled (){
        return enabled;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountNonExpired(boolean AccountNonExpired) {
        this.accountNonExpired = AccountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
}
