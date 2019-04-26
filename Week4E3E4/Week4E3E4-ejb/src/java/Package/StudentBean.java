/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 * Assignment 1 Week4 Exercise 3, session bean
 * @author Zeting Luo ID:16938158
 */
@Stateless
@LocalBean
public class StudentBean {

    final String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
    final String dbURL = "jdbc:derby://localhost:1527/DMSDB;" + 
                            "create=true;user=dms;password=dms2018";
    private Statement statement;
    private ResultSet resultSet;
    private Connection connection;
    private int studentID;
    
// Load drivers for JAVA DB
//Connecting to sample Database in Java DB
    public void connect() throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection(dbURL);
        Class.forName(driverURL); 
        this.statement = connection.createStatement();
    }
    public ArrayList<SingleStudent> getAllStudent(){
  
        String sqlQuery = "SELECT * FROM STUDENT";
        ArrayList<SingleStudent> studentInfo = new ArrayList<>();
        try {
           
            resultSet = statement.executeQuery(sqlQuery);
            while(resultSet.next()){
               SingleStudent student = new SingleStudent(
                       Integer.parseInt(resultSet.getString(1)),
                               resultSet.getString(2),
                               resultSet.getString(3));
                System.out.println(student);
                studentInfo.add(student);
            }
        } catch (SQLException ex) {
            System.out.println("[DB: GET INFORMATION FAIL {STUDENT BEAN}]");
        } 
        return studentInfo;
    }
    public String insert(int studentID, String firstName, String lastName){
        String sqlQuery = "INSERT INTO STUDENT VALUES ("+studentID+", '"+firstName+"', '"+lastName+"')";
        int queryResult=-1;
        String info = "";
        try {
            queryResult = statement.executeUpdate(sqlQuery);
        } catch (SQLException ex) {
            info = "[DB: INSERT FAIL {STUDENT BEAN}]";
        }
        if(queryResult == 1)
            info = "[DB SUCCESSED INPUTED!]New student created in the database ";
        return info;
    }
    public SingleStudent SingleStudentInfo(int studentId){
        
        ArrayList<SingleStudent> studentInfo = this.getAllStudent();
        SingleStudent target = null;
        for(SingleStudent t : studentInfo)
        {
            if(t.getStudentId()==studentId){
                target = t;
            }               
        }
        if(target!=null){
            
            return target;
        }else{
            System.out.println("[DB: LOCATE SINGLE STUDENT FAIL {STUDENT BEAN}]");
            return null;
        }
       
      }
    public String closeDBConnect() throws SQLException{
          statement.close();
          return "[DB]DATABASE STATEMENT CLOSED";
    }
    
}
