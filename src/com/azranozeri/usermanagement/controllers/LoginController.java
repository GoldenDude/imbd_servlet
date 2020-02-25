package com.azranozeri.usermanagement.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azranozeri.usermanagement.exceptions.UserDaoException;
import com.azranozeri.usermanagement.models.User;

/**
 * Implementation of AbstractUserController.
 * A microservice that allows to identify and validate login attempts.
 *
 * @see com.azranozeri.usermanagement.controllers.AbstractUserController
 */
public class LoginController extends AbstractUserController {

    /**
     *
     * @see javax.servlet.http.HttpServlet
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     *
     * @see javax.servlet.http.HttpServlet
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");

        if(validate(userName, password)){
            User user = null;
            try {
                user = userDao.getUser(userName);
            } catch (UserDaoException e) {
                e.printStackTrace();
            }
            session.setAttribute("user", user);
            session.setAttribute("logged", true);
            session.setAttribute("validation", true);
        }
        else{
            session.setAttribute("logged", false);
            session.setAttribute("validation", false);
        }
        dispatcher.forward(request, response);
    }

    /**
     *
     * @param userName - the user name
     * @param password - user's password
     * @return if the hashed password matches the one in the database
     */
    private boolean validate(String userName, String password){
        String hashedPass = generateHash(password);
        User user = null;
        try {
            user = userDao.getUser(userName);
        } catch (UserDaoException e) {
            e.printStackTrace();
            return false;
        }
        if(user == null)
            return false;

        return hashedPass.equals(user.getPasswordHash());
    }

}