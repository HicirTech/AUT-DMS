/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Stateless.UserDB;
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
import org.jboss.weld.context.ejb.Ejb;

/**
 * this page is for process admin option
 * @author Zeting Luo ID : 16938158
 */
public class AdminManage extends HttpServlet {

    @Ejb
    UserDB UDB;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminManage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminManage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        HttpSession userSession = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet - admin Management servlet GET - method do Review</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>admin Management page</h1>");
            out.println("<h1>Please select a user to review</h1>");
            out.println("<form>");
            out.println("<p>Review by user Name</p>");
            out.println("<select name=\"REVIEW\">");
            out.println(getUserSelection());
            out.println("</select>");
            out.println("<input type=\"submit\" value=\"Select\"></button>");
            out.println("<input type=\"button\" onclick=\"location.href='http://localhost:8080/Assignment2-R1-war/ReviewUser\';\" value=\"Review\" />");
            out.println("</form>");
            out.println(" <a href=\"mainPage.jsp\"><button>Go back to home page</button></a>");
            userSession.setAttribute("REVIEWID", request.getParameter("REVIEW").toString());
            out.println("</body>");
            out.println("</html>");
        }
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
        HttpSession userSession = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet - admin Management page delete Review</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>admin Management page</h1>");
            out.println("<h1>Please select a user to delete</h1>");
            out.println("<form action=\"http://localhost:8080/Assignment2-R1-war/AdminManage\" method=\"POST\">");
            out.println("<select name=\"REVIEW\">");
            out.println(getUserSelection());
            out.println("</select>");
            out.println("<input type=\"submit\" value=\"Select\"></button>");
            out.println("<input type=\"button\" onclick=\"location.href='http://localhost:8080/Assignment2-R1-war/DeleteUser\';\" value=\"Delete\" />");
            out.println("</form>");
            out.println(" <a href=\"mainPage.jsp\"><button>Go back to home page</button></a>");
            userSession.setAttribute("DELETEID", request.getParameter("REVIEW").toString());
            out.println("</body>");
            out.println("</html>");
        }
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

    private String getUserSelection() {
        UDB = new UserDB();
        ResultSet rs = UDB.getAllUser();
        String addon = "";
        try {
            while (rs.next()) {
                addon += "<option value=" + rs.getString("UID") + ">" + rs.getString("USERNAME") + "</option>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return addon;
    }
}
