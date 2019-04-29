/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Assignment2.DBCheck;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
/**
 *
 * @author luoze
 */
public class signup extends HttpServlet {

    @EJB
    private DBCheck db;

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
        HttpSession session = request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet - New user signup</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet signup at " + request.getContextPath() + "</h1>");
            out.println("<form method=\"POST\"'>"
                    + "User ID <input type='Text' min='0' name='UID' required></input>"
                    + "Password <input type='Text' min='0' name='PASSWORD' required></input>"
                    + "User name <input type='Text' min='0' name='USERNAME' required></input>"
                    +"<select name = 'TYPE'>"
                    + "<option value=\"1\">administrator</option>"
                    + "<option value=\"0\">chat user</option>"
                    +"</select>"
                    + "<button name='' type='submit'>signup</button>"
                    + "</form>");
            out.println("<a href=\"http://localhost:8080/Assignment2-war/\"><button>Go back to home page</button></a>");
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
        ///processRequest(request, response);
          HttpSession session = request.getSession(true);
          response.setContentType("text/html;charset=UTF-8");
             try (PrintWriter out = response.getWriter()) {
                 
            String password = request.getParameter("PASSWORD");
            String UID = request.getParameter("UID");
            String userName = request.getParameter("USERNAME");
            String userType = request.getParameter("TYPE");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet - New user signup</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet signup at " + request.getContextPath() + "</h1>");
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");  
            Date date = new Date(System.currentTimeMillis()); 
            out.println("<p> signup success? =  "+this.doSignUp(UID, userName, password,userType,date.toString()));
          //  session.invalidate();
            out.println("<a href=\"http://localhost:8080/Assignment2-war/\"><button>Go back to home page</button></a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private boolean doSignUp(String UID, String userName, String Password,String userType,String time){
        try {
            db.connect();
            if(db.checkHasUser(UID)){
                System.out.println(UID+"already there");
            }else{
               db.insertNewUser(UID, Password, userName,userType,time);
               db.disconnect();
               return true;
            }
            db.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
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
