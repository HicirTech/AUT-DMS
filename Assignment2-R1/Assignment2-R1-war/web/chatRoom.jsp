<%-- 
    Document   : chatRoom
    Created on : May 2, 2019, 4:28:34 PM
    Author     : Zeting Luo
--%>

<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="Stateful.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Stateless.ChatDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Chat here with other user</h1>          

        <%
            //get chat display ready
            final int reflashTime = 4;
            ChatDB CBD;
            CBD = new ChatDB();
            CBD.connect();
            User user = (User) request.getSession().getAttribute("USER");
            ResultSet chatData = CBD.getAllChat();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date;
        %>        

        <%--User input--%>
        <form>

            say SomeThing: <input type='Text' min='0' name='CHAT' required></input>
            <button value="Refresh Page" onClick="window.location.reload();">Reflash Chat</button>

            <button name='send' type='submit'>Sent</button>
        </form>
        <%//code for send function
            if (request.getParameter("send") != null) {

                String chat = request.getParameter("CHAT");

                date = new Date(System.currentTimeMillis());
                if (chatData.next()) {
                    if (!chat.equals(chatData.getString("CHAT"))) {//chat is equal to last chat
                        //if not hitting protect insert new chat
                        date = new Date(System.currentTimeMillis());
                        CBD.insertNewChat(user.getUserName(), chat, date.toString());
                    } else {
                        System.out.println("hit protect[CHECK NOT REPEAT]!");
                    }
                } else {
                    CBD.insertNewChat(user.getUserName(), chat, date.toString());
                    System.out.println("hit 0 chat history");
                }
            }
        %>
        <%--current day and auto update--%>
        <form>
            <fieldset style="width:20%; background-color:#e6ffe6;">
                <legend>Current Time</legend>          
                <% //AUTO UPDATE CODE
                    response.setIntHeader("Refresh", reflashTime);%>
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
        <a href="index.html"><button>Home Page</button></a>           
        <%--chat display--%>
        <table border="5" style="width:100%">
            <tr>
                <th><p>User Name</p></th>
                <th><p>Chat</p></th> 
                <th><p>Time</p></th>
            </tr>
            <%
                chatData = CBD.getAllChat();//re postition 
                String table = "";
                while (chatData.next()) {
                    table += "<tr>";
                    table += "<td><center>" + chatData.getString("USERNAME") + "</center></td>";
                    table += "<td><center>" + chatData.getString("CHAT") + "</center></td>";
                    table += "<td><center>" + chatData.getString("TIME") + "</center></td>";
                    table += "</tr>";
                }
                out.println(table);
            %>
        </table>

    </body>
</html>
