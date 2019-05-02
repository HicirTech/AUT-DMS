<%-- 
    Document   : mainPage
    Created on : May 2, 2019, 7:42:38 PM
    Author     : luoze
--%>

<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assignment 2 Chat room</title>
    </head>
    <body>
        <h1>Char room intro page</h1>
    <center>
         <form>
            <fieldset style="width:20%; background-color:#e6ffe6;">
                <legend>Current Time</legend>          
                <% //AUTO UPDATE CODE
                    response.setIntHeader("Refresh", 1);%>
                <%
                    Calendar calendar = new GregorianCalendar();
                    String am_pm;
                    int hour = calendar.get(Calendar.HOUR);
                    int minute = calendar.get(Calendar.MINUTE);
                    int second = calendar.get(Calendar.SECOND);
                    if (calendar.get(Calendar.AM_PM) == 0) {
                        am_pm = "AM";
                    } else {
                        am_pm = "PM";
                    }
                    String CT = hour + ":" + minute + ":" + second + " " + am_pm;
                    out.println("Crrent Time: " + CT + "\n");
                %>
            </fieldset>
        </form>
    </center>
    <br>
        <table border="5" style="width:100%">
            <tr>
                <th><p>Please login of accounts management</p></th>
                <th><p>Please select your login of the chat room</p></th>
                <th><p>Please sign up</p></th>

            </tr>
            <tr>
                <th><p><a href="adminLogin.jsp"><button>Login as administrator</button></a></p></th>
                <th><p><a href="userLogin.jsp"><button>Login as user</button></a></p></th>
                <th><p><a href="http://localhost:8080/Assignment2-R1-war/SignUp"><button>Registration</button></a></p></th>

            </tr>
        </table>
    </body>
</html>
