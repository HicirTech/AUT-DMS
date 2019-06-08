/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import webservicepackage.Exception_Exception;
import webservicepackage.Gender;
import webservicepackage.StudentWebService_Service;

/**
 *
 * @author luoze
 */
public class ChangePassword extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/StudentServer/StudentWebService.wsdl")
    private StudentWebService_Service service;

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
            throws ServletException, IOException, Exception_Exception {
        HttpSession session = request.getSession();
        int currentUser = Integer.parseInt(session.getAttribute("USERID").toString());
        String newPassword = request.getParameter("newPass");
        boolean pass = this.changePassword(currentUser, newPassword);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Change password </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Change password " + pass + "</h1>");
            out.println("<form action='http://localhost:8080/StudentApp/AppServlet' method = 'Get'>");
            out.println("<input type='submit' name='login' value='Login again'>");
            out.println("</form>");
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
        try {
            processRequest(request, response);
        } catch (Exception_Exception ex) {
            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Change password </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Change password </h1>");
            out.println("<form action='http://localhost:8080/StudentApp/ChangePassword' method = 'Get'>");
            out.println("New Password: <input type='text' name='newPass'>");
            out.println("<input type='submit' name='login' value='Change'>");
            out.println("</form>");
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

    private boolean changePassword(int arg0, java.lang.String arg1) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        return port.changePassword(arg0, arg1);
    }

    private int addStudent(java.lang.String arg0, int arg1, java.lang.String arg2) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        return port.addStudent(arg0, arg1, arg2);
    }

}
