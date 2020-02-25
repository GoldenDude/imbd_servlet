package com.azranozeri.httprequests;

import com.azranozeri.usermanagement.models.User;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * A microservice that saves user's answer to a nosql database (MongoDB)
 * It sends a request to an existing server written in node.js that is deployed on Heroku.
 */
public class saveAnswers extends HttpServlet {
    /**
     * @see javax.servlet.http.HttpServlet
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User)session.getAttribute("user");
        String answer1 = request.getParameter("answer1");
        String answer2 = request.getParameter("answer2");
        String answer3 = request.getParameter("answer3");

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        JsonObject jsonCont = new JsonObject();
        jsonCont.addProperty("userName", user.getUserName());
        jsonCont.addProperty("answer1", answer1);
        jsonCont.addProperty("answer2", answer2);
        jsonCont.addProperty("answer3", answer3);
        try {
            HttpPost requestPost = new HttpPost("https://imdb-service.herokuapp.com/addAnswers");
            StringEntity params =new StringEntity(jsonCont.toString());
            requestPost.addHeader("content-type", "application/json");
            requestPost.setEntity(params);
            CloseableHttpResponse responsePost = httpClient.execute(requestPost);
            HttpEntity entity = responsePost.getEntity();
            InputStream inStream = entity.getContent();
            String returnedJson = convertStreamToString(inStream);
            JsonObject json = JsonParser.parseString(returnedJson).getAsJsonObject();

            if(json.get("result").getAsString().equals("Success")){
                request.setAttribute("saved", true);
                response.sendRedirect("visualData.jsp");
                session.setAttribute("answer1", answer1);
                session.setAttribute("answer2", answer2);
                session.setAttribute("answer3", answer3);
            }
            else{
                request.setAttribute("saved", false);
                response.sendRedirect("index.jsp");
            }


        }catch (Exception ex) {
            request.setAttribute("saved", false);
            response.sendRedirect("index.jsp");
        } finally {
            httpClient.close();
        }
    }

    /**
     * Used to convert InputStream to String
     * @param is - input stream
     * @return string made from InputStream
     */
    private String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
