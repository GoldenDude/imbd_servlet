package com.azranozeri.usermanagement.dao;

import com.azranozeri.usermanagement.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao userDao;

    @BeforeEach
    void setUp() {
        userDao = new UserDao();
    }

    @AfterEach
    void tearDown() {
        userDao = null;
    }

    @Test
    void saveUser() {
        User expect = new User("testUnit", "testPassword", "test@email.com");
        User actual = userDao.getUser("testUnit");

        assertNull(actual);

        userDao.saveUser(expect);
        actual = userDao.getUser("testUnit");
        assertEquals(expect.getUserName(), actual.getUserName());
        assertEquals(expect.getPasswordHash(), actual.getPasswordHash());
        assertEquals(expect.getEmail(), actual.getEmail());

        userDao.deleteUser("testUnit");
    }

    @Test
    void updateUser() {
        User dummy = new User("testUnit", "testPassword", "test@email.com");
        User expect = new User("testUnit", "testPasswordUpdatedPass", "test@email.com");
        User actual;

        userDao.saveUser(dummy);
        actual = userDao.getUser("testUnit");
        assertEquals(dummy.getUserName(), actual.getUserName());
        assertEquals(dummy.getPasswordHash(), actual.getPasswordHash());
        assertEquals(dummy.getEmail(), actual.getEmail());

        userDao.updateUser(expect);
        actual = userDao.getUser("testUnit");
        assertEquals(expect.getUserName(), actual.getUserName());
        assertEquals(expect.getPasswordHash(), actual.getPasswordHash());
        assertEquals(expect.getEmail(), actual.getEmail());

        userDao.deleteUser("testUnit");
    }

    @Test
    void deleteUser() {
        User dummy = new User("testUnit", "testPassword", "test@email.com");
        User actual;

        userDao.saveUser(dummy);
        actual = userDao.getUser("testUnit");
        assertEquals(dummy.getUserName(), actual.getUserName());
        assertEquals(dummy.getPasswordHash(), actual.getPasswordHash());
        assertEquals(dummy.getEmail(), actual.getEmail());

        userDao.deleteUser("testUnit");
        actual = userDao.getUser("testUnit");
        assertNull(actual);
    }

    @Test
    void getUser() {
        User expect = new User("testUnit", "testPassword", "test@email.com");
        User actual;

        userDao.saveUser(expect);
        actual = userDao.getUser("testUnit");
        assertEquals(expect.getUserName(), actual.getUserName());
        assertEquals(expect.getPasswordHash(), actual.getPasswordHash());
        assertEquals(expect.getEmail(), actual.getEmail());

        userDao.deleteUser("testUnit");
    }

    @Test
    void getAllUser() {
        int expect = userDao.getAllUser().size() + 3;;
        int actual;
        User dummy1, dummy2, dummy3;

        dummy1 = new User("testUnit1", "testPass1", "test@gmail.com");
        dummy2 = new User("testUnit2", "testPass2", "test@gmail.com");
        dummy3 = new User("testUnit3", "testPass3", "test@gmail.com");
        userDao.saveUser(dummy1);
        userDao.saveUser(dummy2);
        userDao.saveUser(dummy3);
        actual = userDao.getAllUser().size();

        assertEquals(expect, actual);

        userDao.deleteUser("testUnit1");
        userDao.deleteUser("testUnit2");
        userDao.deleteUser("testUnit3");

    }
}