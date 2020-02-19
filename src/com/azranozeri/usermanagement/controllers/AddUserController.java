package com.azranozeri.usermanagement.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.azranozeri.usermanagement.exceptions.UserDaoException;
import com.azranozeri.usermanagement.models.User;

/**
 * An implementation of AbstractController.
 * A microservice that allows adding a user to the users database.
 *
 * @see AbstractUserController
 */
public class AddUserController extends AbstractUserController {

    /**
     * @see javax.servlet.http.HttpServlet
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        insertUser(request, response);
    }

    /**
     * @see javax.servlet.http.HttpServlet
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        insertUser(request, response);
    }

    /**
     * Inserts a new user to the database.
     * User information is withdrawn from the request parameters.
     *
     * @param request - request object from HttpServlet
     * @param response - response object from HttpServlet
     */
    private void insertUser(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String hashedPassword = generateHash(password);
        User newUser = new User(name, hashedPassword, email);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        try {
            userDao.saveUser(newUser);
        } catch (UserDaoException e){
            System.out.println("Here");
            request.setAttribute("registerResult", false);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException err) {
                err.printStackTrace();
            }
            return;
        }
        request.setAttribute("registerResult", true);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
