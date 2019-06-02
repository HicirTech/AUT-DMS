package DMS.A3.Server;

import org.apache.derby.client.am.SqlException;

import java.sql.*;

public class UserDB {
    //private final String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
    private Connection conn;

    public void connectionToDerby() {
        String dbUrl = "jdbc:derby://localhost:1527/DMSA3;"
                + "create=true;user=dms;password=A218";
        try {
            conn = DriverManager.getConnection(dbUrl);
            this.checkUserTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createTable() {
        try {
            System.out.println(conn.isClosed());
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE USERS " +
                    "(UID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "NAME VARCHAR(255)," +
                    "PASSWORD VARCHAR(255)," +
                    "TYPE VARCHAR(255)," +
                    "BIO VARCHAR(255)," +
                    "PAPER VARCHAR(255)," +
                    "CONSTRAINT PRIMARY_KEY PRIMARY KEY (UID)" +
                    ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean checkHasName(String name) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NAME FROM USERS");
            while (rs.next()){
                if(name.equals(rs.getString("NAME"))){
                    return true;
                }
            }
            return false;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertNewStudent(String name, String password, String type, String bio, String paper) {

        if(!this.checkHasName(name))
        {
            try {
                Statement stmt = conn.createStatement();
                int check = stmt.executeUpdate("insert into " +
                        "USERS (NAME, PASSWORD, TYPE, BIO, PAPER) " +
                        "VALUES ('" + name + "','" + password + "','" + type + "','" + bio + "','" + paper + "')");
                return check > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }else{
            System.out.println("already has "+name);
            return false;
        }
    }

    public void viewAllStudent() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
            while (rs.next()) {
                System.out.println(rs.getInt("UID"));
                System.out.println(rs.getString("NAME"));
                System.out.println(rs.getString("PASSWORD"));
                System.out.println(rs.getString("BIO"));
                System.out.println(rs.getString("PAPER"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int viewIdByName(String name) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
            while (rs.next()) {
                if (name.equals(rs.getString("Name"))) {
                    System.out.println(name + "located with UID:" + rs.getInt("UID"));
                    return rs.getInt("UID");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("NO SUCH PERSON");
        return -1;
    }

    private void checkUserTable() {

        try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            // Statement stmt = conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, "USERS".toUpperCase(), null);
            if (rs.next()) {
                System.out.println("Table " + "USERS" + " already exists");
            } else {
                this.createTable();
                System.out.println("USERS Table created");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

