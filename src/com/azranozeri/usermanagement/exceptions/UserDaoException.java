package com.azranozeri.usermanagement.exceptions;
/**
 * This class describes a custom exception thrown when an error occurred while accessing the database
 * @authors Edan Azran, Yuval Ozeri
 */
public class UserDaoException extends Exception{
    /**
     * Class constructor
     * @param message of type String
     */
    public UserDaoException(String message) {
        super(message);
    }
}
// hibernate exception
// checked exception