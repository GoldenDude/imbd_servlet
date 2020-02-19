package com.azranozeri.httprequests;

import com.azranozeri.usermanagement.models.User;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class saveAnswers extends HttpServlet {
    /**
     * @see javax.servlet.http.HttpServlet
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        HttpURLConnection connection = null;
        HttpSession session = request.getSession();
//
        if(session.getAttribute("user") == null){
            //bad
        }

        User user = (User)session.getAttribute("user");
        String answer1 = request.getParameter("answer1");
        String answer2 = request.getParameter("answer2");
        String answer3 = request.getParameter("answer3");
//        try {
//            //Create connection
//            URL url = new URL("https://imdb-service.herokuapp.com/addAnswers");
//            connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Content-Type", "application/json; utf-8");
//            connection.setRequestProperty("Accept", "application/json");
//            String jsonInputString = "{\"userName\": \"" + user.getUserName() + "\", \"answer1\": \"" + answer1 +
//                    "\", \"answer2\": \"" + answer2 + "\", \"answer3\": \"" + answer3 +"\"}";
//            connection.setUseCaches(false);
//            connection.setDoOutput(true);
//
//            try(OutputStream os = connection.getOutputStream()) {
//                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
//                os.write(input, 0, input.length);
//            }
//
//            try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
//                StringBuilder responseString = new StringBuilder();
//                String responseLine = null;
//                while ((responseLine = br.readLine()) != null) {
//                    responseString.append(responseLine.trim());
//                }
//                JsonObject responseJson = JsonParser.parseString(responseString.toString()).getAsJsonObject();
//                System.out.println(responseJson.get("result").getAsString());
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (connection != null) {
//                connection.disconnect();
//            }
//        }
        CloseableHttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
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
            System.out.println(responsePost.getStatusLine());
        }catch (Exception ex) {
            // handle exception here
        } finally {
            httpClient.close();
        }
        }

}
