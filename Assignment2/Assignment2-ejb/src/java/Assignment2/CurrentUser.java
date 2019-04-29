/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ejb.EJB;

/**
 *a Stateful bean that contain user information for current user
 * @author luoze
 */
import java.text.SimpleDateFormat;
import java.util.Date;

@Stateful
@LocalBean
public class CurrentUser {

    @EJB
    private DBCheck dbCheck;

    private String UID;
    private String userName;
    private String password;
    private int userType;
    private String loginTime;

    /**
     * this method will the user id and login time to create a stateful user
     *
     * @param UID user id to get user data from
     * @param time login time for record
     */
    public void makeup(String UID, String time) {
        this.UID = UID;
        dbCheck = new DBCheck();
        ResultSet userInfo = dbCheck.getUserInfo(UID);
        System.out.println(userInfo);

        try {
            while (userInfo.next()) {
                this.password = userInfo.getString("PASS");
                this.userName = userInfo.getString("USERNAME");
                this.userType = userInfo.getInt("TYPE");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CurrentUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.loginTime = time;
    }

    public String getUID() {
        return UID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getUserType() {
        return userType;
    }

    public String getLoginTime() {
        return loginTime;
    }

    @Override
    public String toString() {
        return "USER NAME: " + this.userName;
    }
}
