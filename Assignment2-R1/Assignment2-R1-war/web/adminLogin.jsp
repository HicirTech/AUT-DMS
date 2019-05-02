<%-- 
    Document   : adminLogin
    Created on : May 1, 2019, 8:45:16 PM
    Author     : luoze
--%>

<%@page import="Stateful.User"%>
<%@page import="Stateless.UserDB"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assignment2 admin login</title>
    </head>
    <body>
        <h1>Admin login to server</h1>
        <form name="form" method="POST">
            Admin user ID :<input type="text" name ="adminID">
            password:<input type="text" name="password">
            <input type="submit" name="DBcheck">
            <a href="./index.html"><button type="button">Go Back</button></a>
        </form>
        <%
            HttpSession userSession = request.getSession();
            String pass = "";
            try {
                pass = userSession.getAttribute("PASS").toString();
            } catch (NullPointerException e) {
                System.out.println("[PASS IS NOT IN THE SESSION,NEW USER]");
            }

            if (!pass.equals("PASS")) {

                if (request.getParameter("DBcheck") != null) {
                    UserDB UDB = new UserDB();
                    UDB.connect();

                    String adminId = request.getParameter("adminID");
                    String password = request.getParameter("password");
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());

                    // when user never login
                    if (userSession.getAttribute("USER") == null) {
                        User user = new User();
                        user.completeUser(adminId, date.toString());
                        System.out.println("[LOG:NEW USER login: The user " + user + "has completed!]");
                        userSession.setAttribute("USER", user);
                    } //if system already have user login
                    else {
                        User user = (User) userSession.getAttribute("USER");
                        System.out.println("[LOG:USER: The user " + user + " RETURNED!]");
                    }

                    if (UDB.checkUserVaild(adminId, password) && UDB.getUserType(adminId) == 1) {
                        userSession.setAttribute("PASS", "PASS");
                        userSession.setAttribute("CPASS", "CPASS");//admin can also login to chat no password
        %>
        <h1>Login success, welcome admin</h1>
        <a href="adminEntrySelection.jsp"><button>admin login</button></a>
        <%} else {%>
        <h1>login failed, please check your username, password and your user type</h1>
        <%}
            }
        } else {
        %>
        <h1>Returning user, no need for login, welcome back admin</h1>
        <a href="adminEntrySelection.jsp"><button>admin login</button></a>
        <%
            }
        %>
    </body>
</html>