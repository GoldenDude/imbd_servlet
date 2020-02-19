<%--
  Created by IntelliJ IDEA.
  User: edana
  Date: 19/01/2020
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="com.azranozeri.usermanagement.models.User"%>
<html>
<%
  boolean logged = false;
  boolean saved = false;
  User userName = new User();
  if(session.getAttribute("logged") != null){
    logged = (boolean) session.getAttribute("logged");
    userName = (User) session.getAttribute("user");
  }

  if(request.getParameter("saved") != null){
    saved = !(boolean) request.getAttribute("saved");
  }

  if(!logged){
     response.sendRedirect("login.jsp");
  }
%>

<head>
  <title>IMDB Ratings</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!--===============================================================================================-->
  <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="css/util.css">
  <link rel="stylesheet" type="text/css" href="css/main.css">
  <!--===============================================================================================-->
</head>

<body>
  <div class="limiter">
    <div class="container-login100">
      <div class="wrap-question100 p-l-55 p-r-55 p-t-65 p-b-50">
        <form class="login100-form" action = "saveAnswers" method="post">
          <span class="login100-form-title p-b-33">
            Welcome <%=userName.getUserName()%>!
            </span>
          <span class="login100-form-title p-b-33">
              Please answer the following questions:
          </span>
          <label class="formLabel" for="rad1">Which budget has the highest rating average?</label>
          <div class="form-group" id="rad1">
            <div class="radio">
              <label><input type="radio" name="answer1" value="50" checked>less than 50 Million USD</label>
            </div>
            <div class="radio">
              <label><input type="radio" name="answer1" value="100">between 50 and 100 Million USD</label>
            </div>
            <div class="radio">
              <label><input type="radio" name="answer1" value="200">Over 200 Million USD</label>
            </div>
          </div>

          <label class="formLabel" for="rad2">Which length has the highest rating average?</label>
          <div class="form-group" id="rad2">
            <div class="radio">
              <label><input type="radio" name="answer2" value="50" checked>Less than 60 minutes</label>
            </div>
            <div class="radio">
              <label><input type="radio" name="answer2" value="120">between 60 and 120 minutes</label>
            </div>
            <div class="radio">
              <label><input type="radio" name="answer2" value="180">between 120 and 180 minutes</label>
            </div>
          </div>
          <div class="form-group">
            <label class="formLabel" for="sel1">Which year has the highest movies rating average?</label>
            <select class="editedFormControl" id="sel1" name="answer3">
              <%
                for(int i = 0; i < 20; ++i){
              %>
                  <option><%=2000 + i%></option>
              <%
                }
              %>
            </select>
          </div>
          <%
            if(saved){
          %>
          <label class="loginError">Failed to save answers. Please try again!</label>
          <%
            }
          %>

          <div class="container-login100-form-btn m-t-20">
            <input type="submit" class="login100-form-btn" value="Send Answers!"/>
          </div>
        </form>
      </div>
    </div>
  </div>


  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

  <!--===============================================================================================-->
  <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
  <!--===============================================================================================-->
  <script src="vendor/animsition/js/animsition.min.js"></script>
  <!--===============================================================================================-->
  <script src="vendor/bootstrap/js/popper.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
  <!--===============================================================================================-->
  <script src="vendor/select2/select2.min.js"></script>
  <!--===============================================================================================-->
  <script src="vendor/daterangepicker/moment.min.js"></script>
  <script src="vendor/daterangepicker/daterangepicker.js"></script>
  <!--===============================================================================================-->
  <script src="vendor/countdowntime/countdowntime.js"></script>
  <!--===============================================================================================-->
  <script src="js/main.js"></script>

  <a href = "logout.jsp">Logout</a>
</body>
</html>
