package com.azranozeri.usermanagement.dao;

import java.util.List;

import com.azranozeri.usermanagement.models.User;
import com.azranozeri.usermanagement.util.HibernateUtil;
import com.azranozeri.usermanagement.exceptions.UserDaoException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * User CRUD database operations implementation
 * @author Edan Azran
 * @author Yuval Ozeri
 *
 */
public class UserDao implements UserInterfaceDao {

    /**
     * Save User
     * @param user - user to be added to the database
     */
    public void saveUser(User user) throws UserDaoException {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new UserDaoException("Unable to save user in the database");
        }
    }

    /**
     * Update User
     * @param user - user that will be updated with new data.
     */
    public void updateUser(User user) throws UserDaoException {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new UserDaoException("Unable to update user in the database");
        }
    }

    /**
     * Delete User
     * @param name - The name of the user that needs to be deleted
     */
    public void deleteUser(String name) throws UserDaoException {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, name);
            if (user != null) {
                session.delete(user);
                System.out.println("user is deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new UserDaoException("Unable to delete user from the database");
        }
    }

    /**
     * Get User By ID
     * @param name - The name of the user that needs to be returned
     * @return - requested user instance
     */
    public User getUser(String name) throws UserDaoException {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            user = session.get(User.class, name);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new UserDaoException("Unable to get user from the database");
        }
        return user;
    }

    /**
     * Get all Users
     * @return - list if all the users
     */
    public List<User> getAllUser() throws UserDaoException {

        Transaction transaction = null;
        List<User> listOfUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfUser = session.createQuery("from User", User.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new UserDaoException("Unable to get all users from the database");
        }

        return listOfUser;
    }
}
