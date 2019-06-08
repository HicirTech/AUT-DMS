<%-- 
    Document   : AnnouncementAll
    Created on : 3/06/2019, 12:07:57 AM
    Author     : MY PHU NGUYEN
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="webservicepackage.Announcement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Announcement All Page</title>
    </head>
    <body>
        <h2>Announcement List</h2>
        <% ArrayList<Announcement> announcementList= (ArrayList<Announcement>)request.getAttribute("ANNOUNCEMENT_LIST");%>
        <div>
            <table>
                <tr>
                    <th>Announcement ID</th>
                    <th>Target</th>
                    <th>Topic</th>
                    <th>Body</th>
                </tr>
                
                <% for (Announcement anAnnouncement: announcementList) {%>
                <tr>
                    <td> <%= anAnnouncement.getAnnouncementID() %> </td>
                    <td> <%= anAnnouncement.getTarget()%> </td>
                    <td> <%= anAnnouncement.getTopic()%> </td>
                    <td> <%= anAnnouncement.getBody()%> </td>
                </tr>
                <%}%>
            </table>
        </div>
                
        <br>
        
        <h2>Make Announcement To All Students</h2>
        <form action="http://localhost:8080/StudentClient/NewServlet" method="GET">
            <p>Enter your topic:
                <input type="text" name="topic"></p>
            <p>Enter your content:
                <input type="text" name="body"></p>
            <input type="hidden" name="userDemand" value="announceAll" />
            <button type="submit">Announce to All Student</button>
        </form>
        <p><a href="index.jsp">Return to Home Page</a></p>
    </body>
</html>
