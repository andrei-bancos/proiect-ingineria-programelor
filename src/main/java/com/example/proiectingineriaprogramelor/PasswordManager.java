package com.example.proiectingineriaprogramelor;

import java.security.MessageDigest;
public class PasswordManager {
    /**
     * Cripteaza parola oferita ca argument
     * @param plain Parola
     * @return Returneaza parola criptata
     */
    public static String encryptSHA256(String plain) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(plain.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append(0);
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
