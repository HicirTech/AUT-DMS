<%-- 
    Document   : userLogin
    Created on : May 2, 2019, 4:01:33 PM
    Author     : Zeting Luo
--%>

<%@page import="Stateful.User"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Stateless.UserDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assignment2 user login</title>
    </head>
    <body>
        <h1>user login to server</h1>
        <form name="form" method="POST">
            User ID: <input type="text" name ="userID">
            password:<input type="text" name="password">
            <input type="submit" name="DBcheck">
            <a href="mainPage.jsp"><button type="button">Go Back</button></a>
        </form>
        <%
            HttpSession userSession = request.getSession(false);
            String cpass = "";
            UserDB UDB = new UserDB();
            boolean autoPassDoubleCheck = false;

            try {
                cpass = userSession.getAttribute("CPASS").toString();
            } catch (NullPointerException e) {

                userSession = request.getSession();
                System.out.println("[CPASS IS NOT IN THE SESSION,NEW USER]");
            }
            if (!"CPASS".equals(cpass)) {
                if (request.getParameter("DBcheck") != null) {
                    UDB.connect();
                    String userID = request.getParameter("userID");
                    String password = request.getParameter("password");
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());

                    // when user never login
                    if (userSession.getAttribute("USER") == null) {
                        User user = new User();
                        user.completeUser(userID, date.toString());
                        System.out.println("[LOG:NEW USER login: The user " + user + "has completed!]");
                        userSession.setAttribute("USER", user);
                    } //if system already have user login
                    else {
                        User user = (User) userSession.getAttribute("USER");
                        System.out.println("[LOG:USER: The user " + user + " RETURNED!]");
                    }
                    //check first time login
                    if (UDB.checkUserVaild(userID, password)) {
                        userSession.setAttribute("CPASS", "CPASS");
        %>
        <h1>Login success, welcome to the chat room</h1>
        <a href="chatRoom.jsp"><button>user chat room login</button></a>
        <%} else {%>
        <h1>login failed, please check your username, password</h1>
        <%}
            }
        } else {
        %>
        <h1> Returning user, no need for login, welcome back</h1>
        <a href="chatRoom.jsp"><button>user chat room login</button></a>
        <%
                out.println(((User) userSession.getAttribute("USER")).toString());
            }%>
    </body>
</html>
