package com.azranozeri.usermanagement.controllers;

import com.azranozeri.usermanagement.dao.UserDao;

import javax.servlet.http.HttpServlet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * An abstract class controller that extends HttpServlet.
 * has one implemented method for generating hash strings.
 * @see javax.servlet.http.HttpServlet
 */
public abstract class AbstractUserController extends HttpServlet {
    /**
     * User data access object.
     */
    static protected final UserDao userDao = new UserDao();
    /**
     * Returns a string that contains the hashing of the input.
     * Uses MessageDigest to get a hash byte array of the input.
     *
     * @see MessageDigest
     * @param input the input string to be hashed
     * @return hashed string
     */
    protected String generateHash(String input) {
        StringBuilder hash = new StringBuilder();

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(input.getBytes());
            char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                    'a', 'b', 'c', 'd', 'e', 'f' };
            for (byte b : hashedBytes) {
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hash.toString();
    }
}
