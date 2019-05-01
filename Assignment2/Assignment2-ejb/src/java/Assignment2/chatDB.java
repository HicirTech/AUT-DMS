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
 * @author Zeting Luo ID:16938158
 */
@Stateless
@LocalBean
public class chatDB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private final String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
    private final String dbURL = "jdbc:derby://localhost:1527/Assignment2;"
            + "create=true;user=dms;password=A218";
    private Statement statement;
    private ResultSet resultSet;
    private Connection connection;

    public void connect() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(dbURL);
        Class.forName(driverURL);
        this.statement = connection.createStatement();
        this.checkUserTable();

    }

    /**
     * this is a pre-run check, see if the table is in the database, if not this
     * will create new table
     *
     * @throws SQLException if error, do check your db can be connect
     */
    private void checkUserTable() throws SQLException {
        DatabaseMetaData dbmd = connection.getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "CHATRECORD".toUpperCase(), null);
        if (rs.next()) {
            System.out.println("Table " + "CHATRECORD" + " already exists");
        } else {
            
            
            String sql = "CREATE TABLE CHATRECORD "
                    + "(CID INT NOT NULL GENERATED ALWAYS AS IDENTITY"
                    + "(START WITH 1, INCREMENT BY 1), "
                    + "USERNAME VARCHAR(255), "
                    + "CHAT VARCHAR(255), "
                    + "TIME VARCHAR(255), "
                    + "CONSTRAINT PRIMARY_KEY PRIMARY KEY (CID)"
                    + ")";
            this.statement.executeUpdate(sql);
            this.connection.commit();
            System.out.println("CHAT Table created");
        }
    }
    public boolean lastFiveRecord(String toCheck) {
        String sql = "SELECT * FROM CHATRECORD ORDER BY CID DESC";
        ResultSet rs;
        try {
            rs = this.statement.executeQuery(sql);

            for (int i = 0; i != 5; i++) {
                try {
                    if (rs.next()) {
                        if(rs.getString("CHAT").equals(toCheck)){
                            return true;
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(chatDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(chatDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean insertNewChat(String username, String chat, String time) {

        if (lastFiveRecord(chat)) {
            return false;
        } else {

            try {
                this.connect();
                String sql = "INSERT INTO CHATRECORD "
                        + "(USERNAME, CHAT, TIME)"
                        + "VALUES ('" + username + "', '" + chat + "', '" + time + "')";
                this.statement.executeUpdate(sql);
                this.connection.commit();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DBCheck.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBCheck.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    }
    
    public ResultSet getAllChat() {
        String sql = "SELECT * FROM CHATRECORD ORDER BY CID DESC";
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
