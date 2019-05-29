/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Try;

import Stateless.UserDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author luoze
 */
@WebService(serviceName = "NewWebService")
@Stateless()
public class NewWebService {

    @EJB
    private UserDB ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "connect")
    public void connect() throws SQLException, ClassNotFoundException {
        ejbRef.connect();
    }

    @WebMethod(operationName = "checkUserVaild")
    public boolean checkUserVaild(@WebParam(name = "userID") String userID, @WebParam(name = "password") String password) {
        return ejbRef.checkUserVaild(userID, password);
    }

    @WebMethod(operationName = "checkHasUser")
    public boolean checkHasUser(@WebParam(name = "userID") String userID) {
        return ejbRef.checkHasUser(userID);
    }

    @WebMethod(operationName = "insertNewUser")
    public boolean insertNewUser(@WebParam(name = "UID") String UID, @WebParam(name = "password") String password, @WebParam(name = "userName") String userName, @WebParam(name = "userType") String userType, @WebParam(name = "time") String time) {
        return ejbRef.insertNewUser(UID, password, userName, userType, time);
    }

    @WebMethod(operationName = "getUserInfo")
    public ResultSet getUserInfo(@WebParam(name = "UID") String UID) {
        return ejbRef.getUserInfo(UID);
    }

    @WebMethod(operationName = "getUserType")
    public int getUserType(@WebParam(name = "UID") String UID) {
        return ejbRef.getUserType(UID);
    }

    @WebMethod(operationName = "deleteUser")
    public boolean deleteUser(@WebParam(name = "UID") String UID) {
        return ejbRef.deleteUser(UID);
    }

    @WebMethod(operationName = "disconnect")
    @Oneway
    public void disconnect() {
        ejbRef.disconnect();
    }

    @WebMethod(operationName = "getAllUser")
    public ResultSet getAllUser() {
        return ejbRef.getAllUser();
    }
    
}
