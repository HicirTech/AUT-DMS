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
 * @author Zeting Luo ID : 16938158
 */
@Stateless
@LocalBean
public class ChatDB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private final String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
    private final String dbURL = "jdbc:derby://localhost:1527/DMSA2ZT;"
            + "create=true;user=dms;password=A218";
    private Statement statement;
    private final int lastNRecord = 3;
    private ResultSet resultSet;
    private Connection connection;

    /**
     * set up connection
     *
     * @throws SQLException if happened do check driver
     * @throws ClassNotFoundException if happened do check driver
     */
    public void connect() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(dbURL);
        Class.forName(driverURL);
        this.statement = connection.createStatement();
        this.checkChatTable();
    }

    /**
     * this is a pre-run check, see if the table is in the database, if not this
     * will create new table
     *
     * @throws SQLException if error, do check your db can be connect
     */
    private void checkChatTable() throws SQLException {
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

    /**
     * Check last N record of chat see if any repeat chat message FINAL
     * lastNRecord is on the top of this class
     *
     * @param toCheck the message needs to check
     * @return if any repeat?
     */
    private boolean lastNRecord(String toCheck) {
        String sql = "SELECT * FROM CHATRECORD ORDER BY CID DESC";
        ResultSet rs;
        try {
            rs = this.statement.executeQuery(sql);

            for (int i = 0; i != lastNRecord; i++) {
                try {
                    if (rs.next()) {
                        if (rs.getString("CHAT").equals(toCheck)) {
                            return true;
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ChatDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChatDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * insert new chat message into chatDB this will also check lastNRecord
     *
     * @param username user name for the record
     * @param chat chat message going to be insert
     * @param time the time this happened
     * @return if success inserted
     */
    public boolean insertNewChat(String username, String chat, String time) {

        if (lastNRecord(chat)) {
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
                Logger.getLogger(ChatDB.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ChatDB.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    }

    /**
     * return all info in the chat DB
     *
     * @return a result of the chat DB
     */
    public ResultSet getAllChat() {
        String sql = "SELECT * FROM CHATRECORD ORDER BY CID DESC";
        try {
            this.connect();
            ResultSet returning = this.statement.executeQuery(sql);
            return returning;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ChatDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
