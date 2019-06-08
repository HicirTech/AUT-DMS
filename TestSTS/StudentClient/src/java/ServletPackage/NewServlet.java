/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import webservicepackage.Exception_Exception;
import webservicepackage.Student;
import webservicepackage.StudentWebService_Service;
import javax.naming.*;  
import javax.jms.*;
import webservicepackage.Announcement;
import webservicepackage.AnnouncementWebService_Service;
import webservicepackage.Gender;

/**
 *
 * @author MY PHU NGUYEN
 */
public class NewServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/StudentServer/AnnouncementWebService.wsdl")
    private AnnouncementWebService_Service service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/StudentServer/StudentWebService.wsdl")
    private StudentWebService_Service service;

    
    @Override
    public void init()
    {
        try {
            initList();
            initAnnouncement();
            
        } catch (Exception_Exception ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        ArrayList<Student> studentList= (ArrayList<Student>) getStudentList();
        //add StudentList to request
        request.setAttribute("STUDENT_LIST", studentList);
        //send to JSP page
        RequestDispatcher dispatcher= request.getRequestDispatcher("/studentList.jsp");
        dispatcher.forward(request, response);
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
            String userDemand= request.getParameter("userDemand");
            if (userDemand=="null")
            {
                userDemand= "startDB";
            }
            
            switch(userDemand)
            {
                case "listStudent":
                    getStudentListDB(request, response);
                    break;
                case "addStudent":
                    addStudentDB(request,response);
                    break;
                case "toALl":
                    toALl(request,response);
                    break;
                case "toOne":
                    toOne(request,response);
                    break;
                case "announceAll":
                    announceAll(request,response);
                    break;
                case "announceOne":
                    announceOne(request,response);
                    break;
                case "add":
                    add(request,response);
                    break;
                default:
                    getStudentListDB(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
       
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


    private int addStudent(java.lang.String arg0, int arg1, java.lang.String arg2) throws Exception_Exception {
    // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
    // If the calling of port operations may lead to race condition some synchronization is required.
    webservicepackage.StudentWebService port = service.getStudentWebServicePort();
    return port.addStudent(arg0, arg1, arg2);
    }
    
    private java.util.List<webservicepackage.Student> getStudentList() throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        return port.getStudentList();
    }

    private int initList() throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        return port.initList();
    }

    private Student makeStudent(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.StudentWebService port = service.getStudentWebServicePort();
        return port.makeStudent(arg0);
    }

    private int addAnnouncement(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.AnnouncementWebService port = service_1.getAnnouncementWebServicePort();
        return port.addAnnouncement(arg0, arg1, arg2);
    }

    private java.util.List<webservicepackage.Announcement> getAnnouncementList() throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.AnnouncementWebService port = service_1.getAnnouncementWebServicePort();
        return port.getAnnouncementList();
    }

    private int initAnnouncement() throws Exception_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.AnnouncementWebService port = service_1.getAnnouncementWebServicePort();
        return port.initAnnouncement();
    }
    
    private Announcement makeAnnouncementObject(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservicepackage.AnnouncementWebService port = service_1.getAnnouncementWebServicePort();
        return port.makeAnnouncementObject(arg0, arg1, arg2);
    }
    
        private void getStudentListDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception_Exception {
        ArrayList<Student> studentList= (ArrayList<Student>) getStudentList();
        //add StudentList to request
        request.setAttribute("STUDENT_LIST", studentList);
        //send to JSP page
        RequestDispatcher dispatcher= request.getRequestDispatcher("/studentList.jsp");
        dispatcher.forward(request, response);
    }

    private void announceAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception_Exception{
         //get parameter from user input
        String topic= request.getParameter("topic");
        String body= request.getParameter("body");
        addAnnouncement("0", topic, body);
        //send to JSP page
        toALl(request, response);
    }

    private void announceOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception_Exception {
        String studentID= request.getParameter("StudentID");
          //get parameter from user input
        String topic= request.getParameter("topic");
        String body= request.getParameter("body");
        addAnnouncement(studentID, topic, body);
       //send to JSP page
        toOne(request, response);
    }

    private void toALl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception_Exception {
        ArrayList<Announcement> announcementList= (ArrayList<Announcement>) getAnnouncementList();
        //add StudentList to request
        request.setAttribute("ANNOUNCEMENT_LIST", announcementList);
        //send to JSP page
        RequestDispatcher dispatcher= request.getRequestDispatcher("/AnnouncementAll.jsp");
        dispatcher.forward(request, response);
    }

    private void toOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception_Exception {
        ArrayList<Announcement> announcementList= (ArrayList<Announcement>) getAnnouncementList();
        ArrayList<Student> studentList= (ArrayList<Student>) getStudentList();
        //add StudentList to request
        request.setAttribute("STUDENT_LIST", studentList);
        //add StudentList to request
        request.setAttribute("ANNOUNCEMENT_LIST", announcementList);
       //send to JSP page
        RequestDispatcher dispatcher= request.getRequestDispatcher("/Announcement.jsp");
        dispatcher.forward(request, response);
    }
    
    private void addStudentDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception_Exception {
        //send to JSP page
        RequestDispatcher dispatcher= request.getRequestDispatcher("/AddStudentForm.jsp");
        dispatcher.forward(request, response);
    }    

    private void add(HttpServletRequest request, HttpServletResponse response) throws Exception_Exception, ServletException, IOException {
        String name= request.getParameter("name");
        int age= Integer.parseInt(request.getParameter("age"));
        String genderString= request.getParameter("gender");
        addStudent(name,age,genderString);
        //send to JSP page
        getStudentListDB(request, response);
    }
}
