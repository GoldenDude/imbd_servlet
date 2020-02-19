package com.azranozeri.usermanagement.dao;

import com.azranozeri.usermanagement.models.User;

import java.util.List;

/**
 * User CRUD database operations interface
 * @author Edan Azran
 * @author Yuval Ozeri
 *
 */
public interface UserInterfaceDao {
    /**
     * Save User
     * @param user - user to be added to the database
     */
    void saveUser(User user);

    /**
     * Update User
     * @param user - user that will be updated with new data.
     */
    void updateUser(User user);

    /**
     * Delete User
     * @param name - The name of the user that needs to be deleted
     */
    void deleteUser(String name);

    /**
     * Get User By ID
     * @param name - The name of the user that needs to be returned
     * @return - requested user instance
     */
    User getUser(String name);

    /**
     * Get all Users
     * @return - list if all the users
     */
    List<User> getAllUser();

}
