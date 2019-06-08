<%-- 
    Document   : AddStudentForm
    Created on : 3/06/2019, 12:48:15 AM
    Author     : MY PHU NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student Form</title>
    </head>
    <body>
        <h2>Please fill all fields</h2>
         <form action="http://localhost:8080/StudentClient/NewServlet" method="GET">
             <p>Enter your name:
                <input type="text" name="name"></p>
             <p>Enter your age:
            <input type="text" name="age"></p>
            <select name="gender">
                <option>Male</option>
                <option>Female</option>
            </select>
             <br>
            <input type="hidden" name="userDemand" value="add" />
            <button type="submit">Add the Student</button>
        </form>
        <p><a href="index.jsp">Return to Home Page</a></p>
    </body>
</html>
