<%--
  Created by IntelliJ IDEA.
  User: edana
  Date: 20/02/2020
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="com.azranozeri.usermanagement.models.User" language="java" %>

<html>
<%
    boolean logged = false;
    String answer1 = null, answer2 = null, answer3 = null;
    if(session.getAttribute("logged") != null || session.getAttribute("answer1") != null ||
            session.getAttribute("answer2") != null || session.getAttribute("answer3") != null){
        logged = (boolean) session.getAttribute("logged");
        answer1 = (String) session.getAttribute("answer1");
        answer2 = (String) session.getAttribute("answer2");
        answer3 = (String) session.getAttribute("answer3");
    }

    if(!logged){
        response.sendRedirect("logout.jsp");
    }
%>
<head>
    <title>Movies Average Rating</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
    <div class="limiterVisual">
        <div class="answerHolder">
            <span class="login100-form-title p-b-33">You thought the highest average rating movies have a budget of <b><%=answer1%></b>million USD.</span>
            <span class="login100-form-title p-b-33">You thought the highest average rating movies are <b><%=answer2%></b> minutes long.</span>
            <span class="login100-form-title p-b-33">You thought the highest average rating movies were released in <b><%=answer3%></b>.</span>
        </div>
        <div class='tableauPlaceholder' id='viz1582612676047' style='position: relative'>
            <noscript><a href='#'><img alt=' '
                                       src='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;M3&#47;M3D7JMHMB&#47;1_rss.png'
                                       style='border: none'/></a></noscript>
            <object class='tableauViz' style='display:none;'>
                <param name='host_url' value='https%3A%2F%2Fpublic.tableau.com%2F'/>
                <param name='embed_code_version' value='3'/>
                <param name='path' value='shared&#47;M3D7JMHMB'/>
                <param name='toolbar' value='yes'/>
                <param name='static_image'
                       value='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;M3&#47;M3D7JMHMB&#47;1.png'/>
                <param name='animate_transition' value='yes'/>
                <param name='display_static_image' value='yes'/>
                <param name='display_spinner' value='yes'/>
                <param name='display_overlay' value='yes'/>
                <param name='display_count' value='yes'/>
            </object>
        </div>
        <script type='text/javascript'>
            let divElement = document.getElementById('viz1582612676047');
            let vizElement = divElement.getElementsByTagName('object')[0];
            vizElement.style.width = '1016px';
            vizElement.style.height = '991px';
            let scriptElement = document.createElement('script');
            scriptElement.src = 'https://public.tableau.com/javascripts/api/viz_v1.js';
            vizElement.parentNode.insertBefore(scriptElement, vizElement);
    </script>
    </div>
</body>
</html>
