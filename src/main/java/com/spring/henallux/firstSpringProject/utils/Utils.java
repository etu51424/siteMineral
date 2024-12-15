package com.spring.henallux.firstSpringProject.utils;

import org.springframework.validation.BindingResult;

public class Utils {
    public static boolean isBCryptHash(String hash) {
        // Vérifie si la chaîne correspond au format général de BCrypt
        return hash != null && hash.matches("^\\$2[aby]?\\$\\d{2}\\$[./A-Za-z0-9]{53}$");
    }

    public static boolean verifyPasswordConfirmation(String password, String passwordConfirmation, BindingResult errors){
        if (password.equals(passwordConfirmation)){
            if (password.trim().length() >= 4) {
                return true;
            }
            else{
                errors.rejectValue("password", "password");
            }
        }
        else{
            errors.rejectValue("passwordConfirmation", "passwordConfirmation");
        }
        return false;
    }
}
