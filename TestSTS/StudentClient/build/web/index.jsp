<%-- 
    Document   : index
    Created on : 31/05/2019, 5:04:15 AM
    Author     : MY PHU NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Web Client</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="http://localhost:8080/StudentClient/NewServlet" method="GET">
            <input type="hidden" name="userDemand" value="listStudent" />
            <button type="submit">List Student</button>
        </form>
        <br>
        <form action="http://localhost:8080/StudentClient/NewServlet" method="GET">
            <input type="hidden" name="userDemand" value="addStudent" />
            <button type="submit">Add a Student</button>
        </form>
        <br>
        <form action="http://localhost:8080/StudentClient/NewServlet" method="GET">
            <input type="hidden" name="userDemand" value="toALl" />
            <button type="submit">Announce to All Students</button>
        </form>
        <br>
        <form action="http://localhost:8080/StudentClient/NewServlet" method="GET">
            <input type="hidden" name="userDemand" value="toOne" />
            <button type="submit">Announce to One Student</button>
        </form>
        <br>
    </body>
</html>
