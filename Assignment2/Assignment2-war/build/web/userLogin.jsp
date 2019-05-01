<%-- 
    Document   : userLogin
    Created on : Apr 26, 2019, 3:15:07 PM
    Author     : Zeting Luo ID:16938158
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Assignment2.DBCheck"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>user login page</title>
    </head>
    <body>
        <form name="form" method="POST">
            <h1>user login to server</h1>
            userLogin<input type="text" name ="userID">
            password:<input type="text" name="password">
            <input type="submit" name="DBcheck">
            <a href="./index.html"><button type="button">Go Back</button></a> </form>

        <%
            if (request.getParameter("DBcheck") != null) {
                DBCheck bean = new DBCheck();
                bean.connect();
                String UID = request.getParameter("userID");
                String password = request.getParameter("password");
                if (bean.checkUserVaild(UID, password)) {
                    HttpSession user = request.getSession(true);
                    user.setAttribute("UID", request.getParameter("userID"));
                    ResultSet set = bean.getUserInfo(UID);
                    set.next();                  
                    user.setAttribute("UNAME", set.getString("USERNAME"));
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());
                    user.setAttribute("TIME", date.toString());
        %>
        <h1>Login success, welcome back</h1>
        <a href="chatRoom.jsp"><button>Chat login </button></a>
        <%} else {%>
        <h1>login failed, please check your username, password and your user type</h1>
        <%}
            }
        %>
    </body>
</html>
