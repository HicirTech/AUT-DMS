<%-- 
    Document   : DisplayStudent
    Created on : 30/03/2019, 10:24:40 PM
    Author     : Zeting Luo
--%>

<%@page import="Package.StudentBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make new student in database</title>
    </head>
    <body>
        <form name="form1" method="POST">
            <h1>Assignment 1 Week4 E3 E4</h1>
            Student ID:<input type="number" name ="studentID">
            First name:<input type="text" name="firstname">
            Last name:<input type="text" name="lastname">
            <input type="submit" name="addToDB">
            <a href="./index.html"><button type="button">Go Back</button></a>
        </form>
        <%
              if(request.getParameter("addToDB") != null)
              {
                StudentBean bean = new StudentBean();
                bean.connect();
                bean.insert(
                        Integer.parseInt(request.getParameter("studentID")), 
                        request.getParameter("firstname").toString(),
                        request.getParameter("lastname").toString());
                bean.closeDBConnect();
              }           
            %>
        
    </body>
</html>
