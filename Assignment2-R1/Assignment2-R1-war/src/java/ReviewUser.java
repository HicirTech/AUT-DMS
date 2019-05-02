/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Stateful.User;
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
 * this page will allow admin to review a user
 *
 * @author Zeting Luo ID : 16938158
 */
public class ReviewUser extends HttpServlet {

    @Ejb
    UserDB UDB;
    String reviewID;

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
        HttpSession userSession = request.getSession();
        UDB = new UserDB();
        reviewID = userSession.getAttribute("REVIEWID").toString();
        User user = (User) userSession.getAttribute("USER");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayInfo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Admin " + user.getUserName() + " now is looking at:</h1>");
            ResultSet rs = UDB.getUserInfo(this.reviewID);
            while (rs.next()) {
                out.println("<p>User ID :" + this.reviewID);
                out.println("<p>User Name:" + rs.getString("USERNAME"));
                out.println("<p>User password: " + rs.getString("PASS"));
                out.println("<p>User type: " + rs.getInt("TYPE"));
                out.println("<p>Registration date time" + rs.getString("TIME"));
            }
            userSession.setAttribute("REVIEWID", "");
            out.println("<br> <br><a href=\"http://localhost:8080/Assignment2-R1-war/AdminManage\"><button>Go back to last Page</button></a>");
            out.println("<a href=\"mainPage.jsp\"><button>Go back to home page</button></a>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(ReviewUser.class.getName()).log(Level.SEVERE, null, ex);
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
