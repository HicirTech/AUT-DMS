/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Stateful.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luoze
 */
public class DeleteUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession userSession = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet doDelete</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet doDelete at " + request.getContextPath() + "</h1>");
            User user = (User)userSession.getAttribute("USER");
            out.println("<h1>Admin"+user.getUserName()+" now is going to DELETE USER:"+request.getSession().getAttribute("DELETEID")+"</h1>");
            // = new DBCheck();
           // ResultSet rs = dbCheck.getUserInfo(userSession.getAttribute("REVIEWER").toString());
//            while (rs.next()) {
//                out.println("<p>User ID :" + userSession.getAttribute("REVIEWER"));
//                out.println("<p>User Name:" + rs.getString("USERNAME"));
//                out.println("<p>User password: " + rs.getString("PASS"));
//                out.println("<p>User type: " + rs.getInt("TYPE"));
//                out.println("<p>User registration time:" + rs.getString("TIME"));
//            }

            out.println("<form method=\"POST\">");

            out.println("<input type=\"submit\" name=\"deleteButton\" value=\"DELETE THIS USER\"></button>");
            out.println("</form>");

            out.println("<a href=\"http://localhost:8080/Assignment2-R1-war/DeleteUser\"><button>Go back to last Page</button></a>");
            out.println("<br> <br><a href=\"http://localhost:8080/Assignment2-R1-war/\"><button>Go back to home page</button></a>");
            out.println("</body>");
            out.println("</html>");
        }    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}