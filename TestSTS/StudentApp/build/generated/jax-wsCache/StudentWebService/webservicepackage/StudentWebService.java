
package webservicepackage;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StudentWebService", targetNamespace = "http://WebServicePackage/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StudentWebService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStudentInformation", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.GetStudentInformation")
    @ResponseWrapper(localName = "getStudentInformationResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.GetStudentInformationResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/getStudentInformationRequest", output = "http://WebServicePackage/StudentWebService/getStudentInformationResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://WebServicePackage/StudentWebService/getStudentInformation/Fault/Exception")
    })
    public String getStudentInformation(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws Exception_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "sentMessageToAnnounceWithTarget", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.SentMessageToAnnounceWithTarget")
    @ResponseWrapper(localName = "sentMessageToAnnounceWithTargetResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.SentMessageToAnnounceWithTargetResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/sentMessageToAnnounceWithTargetRequest", output = "http://WebServicePackage/StudentWebService/sentMessageToAnnounceWithTargetResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://WebServicePackage/StudentWebService/sentMessageToAnnounceWithTarget/Fault/Exception")
    })
    public void sentMessageToAnnounceWithTarget(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns webservicepackage.Student
     * @throws JAXBException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "unMarshallStudentObject", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.UnMarshallStudentObject")
    @ResponseWrapper(localName = "unMarshallStudentObjectResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.UnMarshallStudentObjectResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/unMarshallStudentObjectRequest", output = "http://WebServicePackage/StudentWebService/unMarshallStudentObjectResponse", fault = {
        @FaultAction(className = JAXBException_Exception.class, value = "http://WebServicePackage/StudentWebService/unMarshallStudentObject/Fault/JAXBException")
    })
    public Student unMarshallStudentObject(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws JAXBException_Exception
    ;

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws Exception_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "sentMessageToAnnounce", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.SentMessageToAnnounce")
    @ResponseWrapper(localName = "sentMessageToAnnounceResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.SentMessageToAnnounceResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/sentMessageToAnnounceRequest", output = "http://WebServicePackage/StudentWebService/sentMessageToAnnounceResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://WebServicePackage/StudentWebService/sentMessageToAnnounce/Fault/Exception")
    })
    public void sentMessageToAnnounce(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "changePassword", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.ChangePassword")
    @ResponseWrapper(localName = "changePasswordResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.ChangePasswordResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/changePasswordRequest", output = "http://WebServicePackage/StudentWebService/changePasswordResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://WebServicePackage/StudentWebService/changePassword/Fault/Exception")
    })
    public boolean changePassword(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws Exception_Exception
    ;

    /**
     * 
     * @return
     *     returns int
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "initList", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.InitList")
    @ResponseWrapper(localName = "initListResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.InitListResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/initListRequest", output = "http://WebServicePackage/StudentWebService/initListResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://WebServicePackage/StudentWebService/initList/Fault/Exception")
    })
    public int initList()
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addStudent", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.AddStudent")
    @ResponseWrapper(localName = "addStudentResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.AddStudentResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/addStudentRequest", output = "http://WebServicePackage/StudentWebService/addStudentResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://WebServicePackage/StudentWebService/addStudent/Fault/Exception")
    })
    public int addStudent(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2)
        throws Exception_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<webservicepackage.Student>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStudentList", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.GetStudentList")
    @ResponseWrapper(localName = "getStudentListResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.GetStudentListResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/getStudentListRequest", output = "http://WebServicePackage/StudentWebService/getStudentListResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://WebServicePackage/StudentWebService/getStudentList/Fault/Exception")
    })
    public List<Student> getStudentList()
        throws Exception_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAnnounce", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.GetAnnounce")
    @ResponseWrapper(localName = "getAnnounceResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.GetAnnounceResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/getAnnounceRequest", output = "http://WebServicePackage/StudentWebService/getAnnounceResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://WebServicePackage/StudentWebService/getAnnounce/Fault/Exception")
    })
    public List<String> getAnnounce()
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkPassword", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.CheckPassword")
    @ResponseWrapper(localName = "checkPasswordResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.CheckPasswordResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/checkPasswordRequest", output = "http://WebServicePackage/StudentWebService/checkPasswordResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://WebServicePackage/StudentWebService/checkPassword/Fault/Exception")
    })
    public boolean checkPassword(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "announceDecode", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.AnnounceDecode")
    @ResponseWrapper(localName = "announceDecodeResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.AnnounceDecodeResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/announceDecodeRequest", output = "http://WebServicePackage/StudentWebService/announceDecodeResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://WebServicePackage/StudentWebService/announceDecode/Fault/Exception")
    })
    public List<String> announceDecode(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns webservicepackage.Student
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "makeStudent", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.MakeStudent")
    @ResponseWrapper(localName = "makeStudentResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.MakeStudentResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/makeStudentRequest", output = "http://WebServicePackage/StudentWebService/makeStudentResponse")
    public Student makeStudent(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
