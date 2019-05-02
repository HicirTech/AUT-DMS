/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stateless;

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
 * this is a stateless bean response for connect the user date base
 *
 * @author Zeting Luo ID:16938158
 */
@Stateless
@LocalBean
public class UserDB {

    private final String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
    private final String dbURL = "jdbc:derby://localhost:1527/DMSA2ZT;"
            + "create=true;user=dms;password=A218";
    private Statement statement;
    private ResultSet resultSet;
    private Connection connection;

    /**
     * this will create a connection to database
     *
     * @throws SQLException Check the databse location URI
     * @throws ClassNotFoundException Check the driver URI
     */
    public void connect() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(dbURL);
        Class.forName(driverURL);
        this.statement = connection.createStatement();
        this.checkUserTable();

    }

    /**
     * This meathod will check userID and password pair is correct or not if sql
     * error please check the database is there
     *
     * @param userID the user ID going to be check
     * @param password the user password going to be check
     * @return userID and password pair is correct or not
     */
    public boolean checkUserVaild(String userID, String password) {
        String sql = "SELECT PASS FROM CHATUSER WHERE UID = " + Integer.parseInt(userID);
        try {
            this.connect();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                return resultSet.getString(1).toString().equals(password);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * this will check the database has this user ID
     *
     * @param userID the user id going to be check
     * @return if the user id in the database
     */
    public boolean checkHasUser(String userID) {
        String sql = "SELECT PASS FROM CHATUSER WHERE UID = " + Integer.parseInt(userID);
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * this is a pre-run check, see if the table is in the database, if not this
     * will create new table
     *
     * @throws SQLException if error, do check your db can be connect
     */
    private void checkUserTable() throws SQLException {
        DatabaseMetaData dbmd = connection.getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "CHATUSER".toUpperCase(), null);
        if (rs.next()) {
            System.out.println("Table " + "CHATUSER" + " already exists");
        } else {
            String sql = "CREATE TABLE CHATUSER "
                    + "(UID INT PRIMARY KEY, "
                    + "PASS VARCHAR(255),"
                    + " USERNAME VARCHAR(255), "
                    + "TYPE INT,"
                    + "TIME VARCHAR(255))";
            this.statement.executeUpdate(sql);
            this.connection.commit();
            System.out.println("Table created");
        }
    }

    /**
     * insert a new user by detail information
     *
     * @param UID user ID
     * @param password password
     * @param userName user name
     * @param userType user type, 1 for admin, 0 for normal user
     * @param time time user created
     * @return if the user successful insert
     */
    public boolean insertNewUser(String UID, String password, String userName, String userType, String time) {

        try {
            this.connect();
            String sql = "INSERT INTO CHATUSER VALUES ("
                    + Integer.parseInt(UID) + ", '" + password + "', '" + userName + "', " + Integer.parseInt(userType) + ", '" + time + "')";
            this.statement.executeUpdate(sql);
            this.connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * get the user information set by User ID
     *
     * @param UID going to be check
     * @return a result set of user information
     */
    public ResultSet getUserInfo(String UID) {
        try {
            this.connect();
            String sql = "SELECT * FROM CHATUSER WHERE UID = " + UID;
            ResultSet returning = this.statement.executeQuery(sql);
            return returning;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * this will get the user type for a user id
     *
     * @param UID user id going to becheck
     * @return the user type
     */
    public int getUserType(String UID) {
        try {
            this.connect();
            String sql = "SELECT TYPE FROM CHATUSER WHERE UID = " + UID;
            ResultSet returning = this.statement.executeQuery(sql);
            while (returning.next()) {
                return returning.getInt("TYPE");
            }
            return -1;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    /**
     * remove a user from the databse, by user ID
     *
     * @param UID the user id going to be remove
     * @return if the user has been successful delete
     */
    public boolean deleteUser(String UID) {
        try {
            this.connect();
            String sql = "DELETE FROM CHATUSER WHERE UID = " + UID;
            this.statement.execute(sql);
            this.connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * this will simplily disconnectc the database
     */
    public void disconnect() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * this method will get user informatin from db
     *
     * @return a result set for all information
     */
    public ResultSet getAllUser() {
        String sql = "SELECT * FROM CHATUSER";
        try {
            this.connect();
            ResultSet returning = this.statement.executeQuery(sql);
            return returning;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
