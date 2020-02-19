<%--
  Created by IntelliJ IDEA.
  User: edana
  Date: 19/01/2020
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<form action = "addUser" method="post">--%>
<%--    <label>--%>
<%--        Please choose a user name--%>
<%--        <input type="text" name="userName" required/>--%>
<%--    </label><br>--%>

<%--    <label>--%>
<%--        Please enter your email--%>
<%--        <input type="text" name="email" required/>--%>
<%--    </label><br>--%>

<%--    <label>--%>
<%--        Please choose a password--%>
<%--        <input type="text" name="password" required/>--%>
<%--    </label><br>--%>

<%--    <input type="submit" value="Register">--%>
<%--</form>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>IMDB Ratings</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
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
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
            <form class="login100-form validate-form" action = "addUser" method="post">
					<span class="login100-form-title p-b-33">
						Account Register
					</span>

                <div class="wrap-input100">
                    <input class="input100" type="text" name="userName" placeholder="User Name" required>
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>

                <div class="wrap-input100">
                    <input class="input100" type="email" name="email" placeholder="Email" required>
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>

                <div class="wrap-input100 rs1">
                    <input class="input100" type="password" name="password" placeholder="Password" required>
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>

                <div class="container-login100-form-btn m-t-20">
                    <input type="submit" class="login100-form-btn" value="Sign up"/>
                </div>
            </form>
        </div>
    </div>
</div>



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

</body>
</html>