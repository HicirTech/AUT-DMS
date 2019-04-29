<%-- 
    Document   : adminSelection
    Created on : Apr 29, 2019, 1:07:13 PM
    Author     : Zeting luo ID:16938158
--%>

<%@page import="Assignment2.CurrentUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin entry selection page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            HttpSession user = request.getSession();
            CurrentUser cu = new CurrentUser();
            cu.makeup(user.getAttribute("UID").toString(), user.getAttribute("TIME").toString());
            out.println("<h1>Welcome back admin " + cu.getUserName() + ", you login time is " + cu.getLoginTime() + "</h1>");
        %>
        <p>what would you want to do?</p>
        <form method="GET" action="http://localhost:8080/Assignment2-war/adminManage">
            <button name='' type='submit'>review a user</button></form>
        <form method="POST" action="http://localhost:8080/Assignment2-war/adminManage">
            <button name='' type='submit'>Delete a user</button></form>   
        <br><a href="http://localhost:8080/Assignment2-war/"><button>Go back to home page</button>

    </body>
</html>
