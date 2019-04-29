/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Assignment2.CurrentUser;
import Assignment2.DBCheck;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * this is the admin mangement main page, this page will handle both review and
 * delete user entry
 *
 * @author Zeting Luo ID:16938158
 */
public class adminManage extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method. this will handle the review
     * user requirement
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
            out.println("<title>Servlet - admin Management page GET Review</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>admin Management page</h1>");
            out.println("<h1>Please select a user to review</h1>");
            out.println("<form>");
            out.println("<select name=\"REVIEW\">");
            ResultSet rs = new DBCheck().getAllUser();
            String addon = "";
            try {
                while (rs.next()) {
                    addon += "<option value=" + rs.getString(1).toString() + ">" + rs.getString(3).toString() + "</option>";
                }
            } catch (SQLException ex) {
                Logger.getLogger(adminManage.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println(addon);
            out.println("</select>");
            out.println("<input type=\"submit\" value=\"Select\"></button>");
            out.println("<input type=\"button\" onclick=\"location.href='http://localhost:8080/Assignment2-war/DisplayInfo\';\" value=\"Review\" />");
            out.println("</form>");
            out.println(" <a href=\"http://localhost:8080/Assignment2-war/\"><button>Go back to home page</button></a>");
            userSession.setAttribute("REVIEWER", request.getParameter("REVIEW").toString());
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method. this will handle the delete
     * user requirement
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
            out.println("<form action=\"http://localhost:8080/Assignment2-war/adminManage\" method=\"POST\">");
            out.println("<select name=\"REVIEW\">");
            ResultSet rs = new DBCheck().getAllUser();
            String addon = "";
            try {
                while (rs.next()) {
                    addon += "<option value=" + rs.getString(1).toString() + ">" + rs.getString(3).toString() + "</option>";
                }
            } catch (SQLException ex) {
                Logger.getLogger(adminManage.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println(addon);
            out.println("</select>");
            out.println("<input type=\"submit\" value=\"Select\"></button>");
            out.println("<input type=\"button\" onclick=\"location.href='http://localhost:8080/Assignment2-war/doDelete\';\" value=\"Delete\" />");
            out.println("</form>");
            out.println(" <a href=\"http://localhost:8080/Assignment2-war/\"><button>Go back to home page</button></a>");
            userSession.setAttribute("REVIEWER", request.getParameter("REVIEW").toString());
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
    }

}
