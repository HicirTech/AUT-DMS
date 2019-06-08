<%-- 
    Document   : studentList
    Created on : 31/05/2019, 5:23:44 PM
    Author     : MY PHU NGUYEN
--%>
<%@page import="webservicepackage.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student List</title>
    </head>
    <% ArrayList<Student> studentList= (ArrayList<Student>)request.getAttribute("STUDENT_LIST");%>
    <body>
        <h2>LIST STUDENTS</h2>
        <div>
            <table>
                <tr>
                    <th>Student ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                </tr>
                
                <% for (Student aStudent: studentList) {%>
                <tr>
                    <td> <%= aStudent.getStudentID()%> </td>
                    <td> <%= aStudent.getStudentName()%> </td>
                    <td> <%= aStudent.getAge()%> </td>
                    <td> <%= aStudent.getGender()%> </td>
                </tr>
                <%}%>
        
            </table>
        </div>
        <p><a href="index.jsp">Return to Home Page</a></p>
    </body>
</html>
