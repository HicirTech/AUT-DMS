/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author luoze
 */
@Stateless
@LocalBean
public class DBCheck {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private final String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
    private final String dbURL = "jdbc:derby://localhost:1527/Assignment2;" + 
                            "create=true;user=dms;password=A218";
    private Statement statement;
    private ResultSet resultSet;
    private Connection connection;
    private String userType;
    
    public void connect() throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection(dbURL);
        Class.forName(driverURL); 
        this.statement = connection.createStatement();
        this.checkUserTable();
       
    }
  
    public boolean checkUserVaild(String userID,String password){
        String sql = "SELECT PASS FROM CHATUSER WHERE UID = "+Integer.parseInt(userID);
        try {
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
               return resultSet.getString(1).toString().equals(password);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBCheck.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    public boolean checkHasUser(String userID){
        String sql = "SELECT PASS FROM CHATUSER WHERE UID = "+Integer.parseInt(userID);
        try {
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private void checkUserTable() throws SQLException{
        DatabaseMetaData dbmd = connection.getMetaData();
        ResultSet rs = dbmd.getTables(null, null,"CHATUSER".toUpperCase(),null);
        if(rs.next())
        {
            System.out.println("Table "+ "CHATUSER" +" already exists");
        }
        else
        {
            String sql = "CREATE TABLE CHATUSER "
                + "(UID INT PRIMARY KEY, "
                + "PASS VARCHAR(255),"
                +" USERNAME VARCHAR(255), "
                + "TYPE INT)";
            this.statement.executeUpdate(sql);
            this.connection.commit();
            System.out.println("Table created");
        }
    }
    public boolean insertNewUser(String UID, String password, String userName,String userType, String time){
       
        try {
            String sql = "INSERT INTO CHATUSER VALUES ("+Integer.parseInt(UID)+", '"+password+"', '"+userName+"', "+Integer.parseInt(userType)+", '"+time+"')";
            this.statement.executeUpdate(sql);
            this.connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBCheck.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public ResultSet getUserInfo(String UID){
        try {
            this.connect();
            String sql = "SELECT * FROM CHATUSER WHERE UID = "+UID;
            ResultSet returning = this.statement.executeQuery(sql);
            return returning;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DBCheck.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public void disconnect(){
        try {
            this.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    public ResultSet getAllUser(){
        String sql = "SELECT * FROM CHATUSER";
        try {
            this.connect();
            ResultSet returning = this.statement.executeQuery(sql);
            return returning;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DBCheck.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
