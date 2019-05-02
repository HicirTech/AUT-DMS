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
 * this page will allow admin to delete a user
 *
 * @author Zeting Luo ID : 16938158
 */
public class DeleteUser extends HttpServlet {

    HttpSession userSession;
    @Ejb
    UserDB UDB;
    
    String DeleteID;
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

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            DeleteID = request.getSession().getAttribute("DELETEID").toString();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet doDelete</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet doDelete at " + request.getContextPath() + "</h1>");
            userSession = request.getSession();
            User user = (User)userSession.getAttribute("USER");
            out.println("<h1>Admin "+user.getUserName()+" now is going to DELETE USER with ID: ["+DeleteID+"]</h1>");
            out.println(this.userTableString());
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
    
    private String userTableString(){
         String addon="";
         try {
            UDB = new UserDB();
            ResultSet rs = UDB.getUserInfo(DeleteID);
            addon ="<table border=\"5\" ><tr>";
            
            while (rs.next()) {
                addon+=("<td>User ID :" +this.DeleteID+"</td>");
                addon+=("<td>User Name:" + rs.getString("USERNAME")+"</td>");
                addon+=("<td>User password: " + rs.getString("PASS")+"</td>");
                addon+=("<td>User type: " + rs.getInt("TYPE")+"</td>");
                addon+=("<td>User registration time:" + rs.getString("TIME")+"</td>");
            }
            addon+="</tr></table>";
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return addon;
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
        if (request.getParameter("deleteButton") != null) {
            try (PrintWriter out = response.getWriter()) {
                UDB = new UserDB();
                out.println("<p>User ID : "+DeleteID+" delete "+
                        (UDB.deleteUser(DeleteID)?"Successed":"failed")
                        +"</p>");
                //clean up
                this.DeleteID="";
                userSession.setAttribute("DELETEID", "");                        
                out.println("<br> <br><a href=\"http://localhost:8080/Assignment2-R1-war/\"><button>Go back to home page</button></a>");
            }
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

}
