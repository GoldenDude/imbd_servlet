<%--
  Created by IntelliJ IDEA.
  User: edana
  Date: 17/02/2020
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.setAttribute("logged", false);
    session.setAttribute("userName", null);
    response.sendRedirect("login.jsp");
%>
</body>
</html>
