<%-- 
    Document   : chatRoom
    Created on : Apr 29, 2019, 8:38:48 PM
    Author     : luoze
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@ page import="java.io.*,java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Assignment2.chatDB" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Hello World!</h1>                  

        <form>

            say SomeThing: <input type='Text' min='0' name='CHAT' required></input>
            <button value="Refresh Page" onClick="window.location.reload();">Reflash Chat</button>

            <button name='submitButton' type='submit'>Sent</button>
        </form>
        <%
            if (request.getParameter("submitButton") != null) {
                String checkBeforeAdd = request.getParameter("CHAT");
                chatDB cdb = new chatDB();
                cdb.connect();
                ResultSet preinsert = cdb.getAllChat();

                if (preinsert.next()) {
                    if (!checkBeforeAdd.equals(preinsert.getString("CHAT"))) {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                        Date date = new Date(System.currentTimeMillis());
                        cdb.insertNewChat(request.getSession().getAttribute("UNAME").toString(), request.getParameter("CHAT"), date.toString());
                    } else {
                        System.out.println("hit protect!");
                    }
                } else {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());
                    cdb.insertNewChat(request.getSession().getAttribute("UNAME").toString(), request.getParameter("CHAT"), date.toString());
                    System.out.println("hit 0 chat history");
                }
            }

        %>


        <form>
            <fieldset style="width:20%; background-color:#e6ffe6;">
                <legend>Current Time</legend>          
                <%                        response.setIntHeader("Refresh", 1);
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

        <table border="5" style="width:100%">
            <tr>
                <th><p>User Name</p></th>
                <th><p>Chat</p></th> 
                <th><p>Time</p></th>
            </tr>
            <%
                chatDB cdb = new chatDB();
                cdb.connect();
                ResultSet thatTime = cdb.getAllChat();
                String table = "";
                while (thatTime.next()) {
                    table += "<tr>";
                    table += "<td><center>" + thatTime.getString("USERNAME") + "</center></td>";
                    table += "<td><center>" + thatTime.getString("CHAT") + "</center></td>";
                    table += "<td><center>" + thatTime.getString("TIME") + "</center></td>";
                    table += "</tr>";
                }
                out.println(table);
            %>

        </table>
    </center>
</body>
</html>