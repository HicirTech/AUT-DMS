<%-- 
    Document   : adminEntrySelection
    Created on : May 1, 2019, 9:53:27 PM
    Author     : luoze
--%>

<%@page import="Stateful.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%          
            String pass = "";
            try{
                   pass = request.getSession().getAttribute("PASS").toString();
               }catch(NullPointerException e){
                   System.out.println("[PASS IS NOT IN THE SESSION,NEW USER]");
               }            
            if(pass.equals("PASS")){
                try{
                    User user = (User)request.getSession().getAttribute("USER");
                    out.println("<h1>Welcome back admin " + user.getUserName() + ", you login time is " + user.getLoginTime() + "</h1>");
                     
        %>
        <p>what would you want to do?</p>
        <form method="GET" action="http://localhost:8080/Assignment2-R1-war/AdminManage">
            <button name='' type='submit'>review a user</button></form>
        <form method="POST" action="http://localhost:8080/Assignment2-R1-war/AdminManage">
            <button name='' type='submit'>Delete a user</button></form>   
        <%   }catch(NullPointerException e){
                       System.out.println("[PASS IS NOT IN THE SESSION,NEW USER]");
                   }
            }else{%>
        <p>hmm??looks like your session is gone? login again plz :)</p>
        <%}%>
        <br><a href="http://localhost:8080/Assignment2-R1-war/"><button>Go back to home page</button>
    </body>
</html>
