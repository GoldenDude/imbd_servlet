package com.azranozeri.usermanagement.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @BeforeEach
    void setUp() {
        user = new User("testUnit", "testPassword", "test@email.com");
    }

    @AfterEach
    void tearDown() {
        user = null;
    }

    @Test
    void getUserName() {
        String expect = "testUnit";
        String actual = user.getUserName();

        assertEquals(expect, actual);
    }

    @Test
    void setUserName() {
        String expect = "testUnitChanged";
        user.setUserName("testUnitChanged");
        String actual = user.getUserName();

        assertEquals(expect, actual);
    }

    @Test
    void getPasswordHash() {
        String expect = "testPassword";
        String actual = user.getPasswordHash();

        assertEquals(expect, actual);
    }

    @Test
    void setPasswordHash() {
        String expect = "ChangedPassword";
        user.setUserName("ChangedPassword");
        String actual = user.getUserName();

        assertEquals(expect, actual);
    }

    @Test
    void getEmail() {
        String expect = "test@email.com";
        String actual = user.getEmail();

        assertEquals(expect, actual);
    }

    @Test
    void setEmail() {
        String expect = "changedEmail@email.com";
        user.setUserName("changedEmail@email.com");
        String actual = user.getUserName();

        assertEquals(expect, actual);
    }
}