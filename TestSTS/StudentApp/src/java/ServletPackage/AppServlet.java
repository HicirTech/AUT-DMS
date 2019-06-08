/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

//import ModelPackage.MyListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXB;
import javax.xml.ws.WebServiceRef;
import webservicepackage.Exception_Exception;
import webservicepackage.JAXBException_Exception;
import webservicepackage.Student;
import webservicepackage.StudentWebService_Service;


/**
 *
 * @author MY PHU NGUYEN
 */
public class AppServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/StudentServer/StudentWebService.wsdl")
    private StudentWebService_Service service;

    public static String message="hehe";
    public final String PAGE_NAME = "Student login";
    public final String PAGE_TITLE = "Student login";
    private final String NO_TARGET_INDICATOR = "0";

    private String userID;
    private String password;

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
        this.userID=null;
        this.password=null;

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>"+this.PAGE_NAME+"</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+this.PAGE_TITLE+"</h1>");
            out.println("<form action='http://localhost:8080/StudentApp/AppServlet' method = 'Post'>");
            out.println("User ID:  <input type='text' name='UserID'>");
            out.println("User Password:  <input type='password' name='Password'>");
            out.println("<input type='submit' name='login' value='Login here'>");
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

        System.out.println(message);
        this.userID = request.getParameter("UserID").toString();
        this.password = request.getParameter("Password").toString();




        boolean pass = false;
        try {
            pass = this.checkPassword(Integer.parseInt(userID), password);
        } catch (Exception_Exception ex) {
            Logger.getLogger(AppServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (pass) {
            ArrayList<String> singleStudent = new ArrayList<String>();
            try {
                String xml=this.getStudentInformation(Integer.parseInt(this.userID));
                System.out.println("XML is: "+xml);
                Student aStudent= unMarshallStudentObject(xml);

                singleStudent.add(Integer.toString(aStudent.getStudentID()));
                singleStudent.add(aStudent.getStudentName());
                singleStudent.add(Integer.toString(aStudent.getAge()));
                singleStudent.add(aStudent.getGender().toString());
                singleStudent.add(aStudent.getPassword());
            } catch (Exception_Exception ex) {
                Logger.getLogger(AppServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JAXBException_Exception ex) {
                Logger.getLogger(AppServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            try (PrintWriter out = response.getWriter()) {
                HttpSession session = request.getSession();
                session.setAttribute("USERID", this.userID);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>" + this.PAGE_TITLE + "</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Student account Information</h1>");
                out.println("<h1>Welcome back " + singleStudent.get(1) + "</h1>");
                out.println("<br>");
                out.println("<h1>Your information</h1>");
                out.println("<p>ID :" + singleStudent.get(0) + "</p>");
                out.println("<p>Name :" + singleStudent.get(1) + "</p>");
                out.println("<p>Age :" + singleStudent.get(2) + "</p>");
                out.println("<p>Gender :" + singleStudent.get(3) + "</p>");
                out.println("<p>Password :" + singleStudent.get(4) + "</p>");
                out.println("<form action='http://localhost:8080/StudentApp/ChangePassword' method = 'Post'>");
                out.println("<input type='submit' name='login' value='Change password'>");
                out.println("</form>");
                out.println("<form action='http://localhost:8080/StudentApp/AppServlet' method = 'Get'>");
                out.println("<input type='submit' name='login' value='Logout'>");
                out.println("</form>");
                out.println("<br>");
                out.println("<h1>General Announcement</h1>");
                try {
                    ArrayList<String> result = (ArrayList<String>) this.getAnnounce();
                    for (String e : result) {
                        ArrayList<String> temp = (ArrayList<String>) this.announceDecode(e);
                        if (temp.get(1).equals(this.NO_TARGET_INDICATOR)) {
                            out.println("<h3>" + temp.get(2) + "</h3>");
                            out.println("<p>" + temp.get(3) + "</p>");
                        }
                    }

                } catch (Exception_Exception ex) {
                    Logger.getLogger(AppServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                out.println("<br>");
                out.println("<h1>Special Announcement</h1>");
                try {
                    ArrayList<String> result = (ArrayList<String>) this.getAnnounce();
                    for (String e : result) {
                        ArrayList<String> temp = (ArrayList<String>) this.announceDecode(e);
                        if (temp.get(1).equals(this.userID)) {
                            out.println("<h3>" + temp.get(2) + "</h3>");
                            out.println("<p>" + temp.get(3) + "</p>");
                        }
                    }

                } catch (Exception_Exception ex) {
                    Logger.getLogger(AppServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                out.println("</body>");
                out.println("</html>");
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>"+this.PAGE_TITLE+"</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+this.PAGE_NAME+"</h1>");
            out.println("<h1>Your password or user name is wrong</h1>");
            out.println("</body>");
            out.println("</html>");
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

    private boolean checkPassword(int arg0, java.lang.String arg1) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        return port.checkPassword(arg0, arg1);
    }

    private void sentMessageToAnnounce(int arg0, java.lang.String arg1, java.lang.String arg2) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        port.sentMessageToAnnounce(arg0, arg1, arg2);
    }

    private java.util.List<java.lang.String> getAnnounce() throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        return port.getAnnounce();
    }

    private void sentMessageToAnnounceWithTarget(int arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        port.sentMessageToAnnounceWithTarget(arg0, arg1, arg2, arg3);
    }

    private java.util.List<java.lang.String> announceDecode(java.lang.String arg0) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        return port.announceDecode(arg0);
    }

    private String getStudentInformation(int arg0) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        return port.getStudentInformation(arg0);
    }

    private Student unMarshallStudentObject(java.lang.String arg0) throws JAXBException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        return port.unMarshallStudentObject(arg0);
    }



}