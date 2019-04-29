<%-- 
    Document   : adminLogin
    Created on : Apr 26, 2019, 2:33:48 PM
    Author     : luoze
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Assignment2.DBCheck"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assignment2 admin login</title>
    </head>
    <body>
        <h1>Admin login to server</h1>
          <form name="form1" method="POST">
            AdminLogin:<input type="text" name ="adminID">
            password:<input type="text" name="password">
            <input type="submit" name="DBcheck">
            <a href="./index.html"><button type="button">Go Back</button></a>
        </form>
        <%
              if(request.getParameter("DBcheck") != null)
              {
                DBCheck bean = new DBCheck();
                bean.connect();
                String adminId = request.getParameter("adminID");
                String password = request.getParameter("password");
                if(bean.checkUserVaild(adminId,password))
                {
                    HttpSession user = request.getSession(true);
                    user.setAttribute("UID", request.getParameter("adminID"));
                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");  
                    Date date = new Date(System.currentTimeMillis()); 
                    user.setAttribute("TIME", date.toString());
                    %>
                    <h1>Login success, welcome admin</h1>
                     <a href="adminSelection.jsp"><button>admin login </button></a>
                <%}else{%>
                <h1>login failed, please check your username and password</h1>
                   <%}}
            %>
    </body>
</html>
