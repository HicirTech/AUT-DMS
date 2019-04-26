<%-- 
    Document   : ViewStudentInfomation
    Created on : 30/03/2019, 10:25:11 PM
    Author     : Zeting Luo
--%>

<%@page import="Package.StudentBean"%>
<%@page import="Package.SingleStudent"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View students info</title>
    </head>
    <body>
        <h1>Assignment 1 Week4 E4</h1>
        <h1>Select student to view detail information</h1>
        <form name="form1" method="POST">
            <p>Select a student: 
                <select name="Selection">
                <%  StudentBean bean = new StudentBean();
                    bean.connect();
                ArrayList<SingleStudent> stu = bean.getAllStudent();
                for (int i = 0; i != stu.size(); i++) {%>                
                <option value="<%=stu.get(i).getStudentId()%>"><%=stu.get(i).toString()%></option>
                <%}%>
            </select>
            <input type="submit">
            </p>
         <%if(request.getParameter("Selection") != null){
            SingleStudent target = 
                    bean.SingleStudentInfo(
                            Integer.parseInt(
                                    request.getParameter("Selection")));
            bean.closeDBConnect();%>
            <br>
            The student you looking for: <%out.println(target.toString());%>
            <br>
            <a href="./index.html"><button type="button">Go Back</button></a>
        <%}%>
    </body>
</html>
