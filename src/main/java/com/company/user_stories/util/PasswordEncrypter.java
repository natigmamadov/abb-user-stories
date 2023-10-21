package com.company.user_stories.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncrypter {
    public static String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
