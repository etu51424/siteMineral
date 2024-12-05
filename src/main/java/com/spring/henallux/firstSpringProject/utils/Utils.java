package com.spring.henallux.firstSpringProject.utils;

public class Utils {
    public static boolean isBCryptHash(String hash) {
        // Vérifie si la chaîne correspond au format général de BCrypt
        return hash != null && hash.matches("^\\$2[aby]?\\$\\d{2}\\$[./A-Za-z0-9]{53}$");
    }
}
