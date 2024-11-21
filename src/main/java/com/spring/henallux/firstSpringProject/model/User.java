package com.spring.henallux.firstSpringProject.model;


import javax.validation.constraints.NotNull;
import java.util.Date;

public class User {
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
    private Date birth_date;
    @NotNull
    private String password;

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

    public Date getBirth_date() {
        return birth_date;
    }
    public String getPassword() {
        return password;
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

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
