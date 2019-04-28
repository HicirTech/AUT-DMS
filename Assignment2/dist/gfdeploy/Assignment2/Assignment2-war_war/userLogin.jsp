<%-- 
    Document   : userLogin
    Created on : Apr 26, 2019, 3:15:07 PM
    Author     : luoze
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form" method="POST">
           <h1>userlogin login to server</h1>
           userLogin<input type="text" name ="userID">
           password:<input type="text" name="password">
           <input type="submit" name="addToDB">
           <a href="./index.html"><button type="button">Go Back</button></a>
    </body>
</html>
