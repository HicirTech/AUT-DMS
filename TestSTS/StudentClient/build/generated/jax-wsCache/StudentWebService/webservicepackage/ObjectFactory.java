
package webservicepackage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservicepackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ChangePassword_QNAME = new QName("http://WebServicePackage/", "changePassword");
    private final static QName _Exception_QNAME = new QName("http://WebServicePackage/", "Exception");
    private final static QName _GetAnnounceResponse_QNAME = new QName("http://WebServicePackage/", "getAnnounceResponse");
    private final static QName _GetStudentInformation_QNAME = new QName("http://WebServicePackage/", "getStudentInformation");
    private final static QName _GetStudentListResponse_QNAME = new QName("http://WebServicePackage/", "getStudentListResponse");
    private final static QName _MakeStudentResponse_QNAME = new QName("http://WebServicePackage/", "makeStudentResponse");
    private final static QName _AnnounceDecode_QNAME = new QName("http://WebServicePackage/", "announceDecode");
    private final static QName _GetStudentList_QNAME = new QName("http://WebServicePackage/", "getStudentList");
    private final static QName _SentMessageToAnnounce_QNAME = new QName("http://WebServicePackage/", "sentMessageToAnnounce");
    private final static QName _ChangePasswordResponse_QNAME = new QName("http://WebServicePackage/", "changePasswordResponse");
    private final static QName _AddStudent_QNAME = new QName("http://WebServicePackage/", "addStudent");
    private final static QName _InitListResponse_QNAME = new QName("http://WebServicePackage/", "initListResponse");
    private final static QName _SentMessageToAnnounceResponse_QNAME = new QName("http://WebServicePackage/", "sentMessageToAnnounceResponse");
    private final static QName _GetAnnounce_QNAME = new QName("http://WebServicePackage/", "getAnnounce");
    private final static QName _GetStudentInformationResponse_QNAME = new QName("http://WebServicePackage/", "getStudentInformationResponse");
    private final static QName _AddStudentResponse_QNAME = new QName("http://WebServicePackage/", "addStudentResponse");
    private final static QName _CheckPasswordResponse_QNAME = new QName("http://WebServicePackage/", "checkPasswordResponse");
    private final static QName _CheckPassword_QNAME = new QName("http://WebServicePackage/", "checkPassword");
    private final static QName _SentMessageToAnnounceWithTargetResponse_QNAME = new QName("http://WebServicePackage/", "sentMessageToAnnounceWithTargetResponse");
    private final static QName _AnnounceDecodeResponse_QNAME = new QName("http://WebServicePackage/", "announceDecodeResponse");
    private final static QName _SentMessageToAnnounceWithTarget_QNAME = new QName("http://WebServicePackage/", "sentMessageToAnnounceWithTarget");
    private final static QName _InitList_QNAME = new QName("http://WebServicePackage/", "initList");
    private final static QName _MakeStudent_QNAME = new QName("http://WebServicePackage/", "makeStudent");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservicepackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SentMessageToAnnounceResponse }
     * 
     */
    public SentMessageToAnnounceResponse createSentMessageToAnnounceResponse() {
        return new SentMessageToAnnounceResponse();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link InitListResponse }
     * 
     */
    public InitListResponse createInitListResponse() {
        return new InitListResponse();
    }

    /**
     * Create an instance of {@link ChangePasswordResponse }
     * 
     */
    public ChangePasswordResponse createChangePasswordResponse() {
        return new ChangePasswordResponse();
    }

    /**
     * Create an instance of {@link GetStudentList }
     * 
     */
    public GetStudentList createGetStudentList() {
        return new GetStudentList();
    }

    /**
     * Create an instance of {@link SentMessageToAnnounce }
     * 
     */
    public SentMessageToAnnounce createSentMessageToAnnounce() {
        return new SentMessageToAnnounce();
    }

    /**
     * Create an instance of {@link AnnounceDecode }
     * 
     */
    public AnnounceDecode createAnnounceDecode() {
        return new AnnounceDecode();
    }

    /**
     * Create an instance of {@link MakeStudentResponse }
     * 
     */
    public MakeStudentResponse createMakeStudentResponse() {
        return new MakeStudentResponse();
    }

    /**
     * Create an instance of {@link GetStudentListResponse }
     * 
     */
    public GetStudentListResponse createGetStudentListResponse() {
        return new GetStudentListResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link GetAnnounceResponse }
     * 
     */
    public GetAnnounceResponse createGetAnnounceResponse() {
        return new GetAnnounceResponse();
    }

    /**
     * Create an instance of {@link GetStudentInformation }
     * 
     */
    public GetStudentInformation createGetStudentInformation() {
        return new GetStudentInformation();
    }

    /**
     * Create an instance of {@link ChangePassword }
     * 
     */
    public ChangePassword createChangePassword() {
        return new ChangePassword();
    }

    /**
     * Create an instance of {@link MakeStudent }
     * 
     */
    public MakeStudent createMakeStudent() {
        return new MakeStudent();
    }

    /**
     * Create an instance of {@link InitList }
     * 
     */
    public InitList createInitList() {
        return new InitList();
    }

    /**
     * Create an instance of {@link SentMessageToAnnounceWithTarget }
     * 
     */
    public SentMessageToAnnounceWithTarget createSentMessageToAnnounceWithTarget() {
        return new SentMessageToAnnounceWithTarget();
    }

    /**
     * Create an instance of {@link AnnounceDecodeResponse }
     * 
     */
    public AnnounceDecodeResponse createAnnounceDecodeResponse() {
        return new AnnounceDecodeResponse();
    }

    /**
     * Create an instance of {@link CheckPassword }
     * 
     */
    public CheckPassword createCheckPassword() {
        return new CheckPassword();
    }

    /**
     * Create an instance of {@link SentMessageToAnnounceWithTargetResponse }
     * 
     */
    public SentMessageToAnnounceWithTargetResponse createSentMessageToAnnounceWithTargetResponse() {
        return new SentMessageToAnnounceWithTargetResponse();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link CheckPasswordResponse }
     * 
     */
    public CheckPasswordResponse createCheckPasswordResponse() {
        return new CheckPasswordResponse();
    }

    /**
     * Create an instance of {@link GetStudentInformationResponse }
     * 
     */
    public GetStudentInformationResponse createGetStudentInformationResponse() {
        return new GetStudentInformationResponse();
    }

    /**
     * Create an instance of {@link GetAnnounce }
     * 
     */
    public GetAnnounce createGetAnnounce() {
        return new GetAnnounce();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangePassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "changePassword")
    public JAXBElement<ChangePassword> createChangePassword(ChangePassword value) {
        return new JAXBElement<ChangePassword>(_ChangePassword_QNAME, ChangePassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnnounceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "getAnnounceResponse")
    public JAXBElement<GetAnnounceResponse> createGetAnnounceResponse(GetAnnounceResponse value) {
        return new JAXBElement<GetAnnounceResponse>(_GetAnnounceResponse_QNAME, GetAnnounceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "getStudentInformation")
    public JAXBElement<GetStudentInformation> createGetStudentInformation(GetStudentInformation value) {
        return new JAXBElement<GetStudentInformation>(_GetStudentInformation_QNAME, GetStudentInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "getStudentListResponse")
    public JAXBElement<GetStudentListResponse> createGetStudentListResponse(GetStudentListResponse value) {
        return new JAXBElement<GetStudentListResponse>(_GetStudentListResponse_QNAME, GetStudentListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "makeStudentResponse")
    public JAXBElement<MakeStudentResponse> createMakeStudentResponse(MakeStudentResponse value) {
        return new JAXBElement<MakeStudentResponse>(_MakeStudentResponse_QNAME, MakeStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnounceDecode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "announceDecode")
    public JAXBElement<AnnounceDecode> createAnnounceDecode(AnnounceDecode value) {
        return new JAXBElement<AnnounceDecode>(_AnnounceDecode_QNAME, AnnounceDecode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "getStudentList")
    public JAXBElement<GetStudentList> createGetStudentList(GetStudentList value) {
        return new JAXBElement<GetStudentList>(_GetStudentList_QNAME, GetStudentList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SentMessageToAnnounce }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "sentMessageToAnnounce")
    public JAXBElement<SentMessageToAnnounce> createSentMessageToAnnounce(SentMessageToAnnounce value) {
        return new JAXBElement<SentMessageToAnnounce>(_SentMessageToAnnounce_QNAME, SentMessageToAnnounce.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangePasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "changePasswordResponse")
    public JAXBElement<ChangePasswordResponse> createChangePasswordResponse(ChangePasswordResponse value) {
        return new JAXBElement<ChangePasswordResponse>(_ChangePasswordResponse_QNAME, ChangePasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "initListResponse")
    public JAXBElement<InitListResponse> createInitListResponse(InitListResponse value) {
        return new JAXBElement<InitListResponse>(_InitListResponse_QNAME, InitListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SentMessageToAnnounceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "sentMessageToAnnounceResponse")
    public JAXBElement<SentMessageToAnnounceResponse> createSentMessageToAnnounceResponse(SentMessageToAnnounceResponse value) {
        return new JAXBElement<SentMessageToAnnounceResponse>(_SentMessageToAnnounceResponse_QNAME, SentMessageToAnnounceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnnounce }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "getAnnounce")
    public JAXBElement<GetAnnounce> createGetAnnounce(GetAnnounce value) {
        return new JAXBElement<GetAnnounce>(_GetAnnounce_QNAME, GetAnnounce.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentInformationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "getStudentInformationResponse")
    public JAXBElement<GetStudentInformationResponse> createGetStudentInformationResponse(GetStudentInformationResponse value) {
        return new JAXBElement<GetStudentInformationResponse>(_GetStudentInformationResponse_QNAME, GetStudentInformationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "checkPasswordResponse")
    public JAXBElement<CheckPasswordResponse> createCheckPasswordResponse(CheckPasswordResponse value) {
        return new JAXBElement<CheckPasswordResponse>(_CheckPasswordResponse_QNAME, CheckPasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "checkPassword")
    public JAXBElement<CheckPassword> createCheckPassword(CheckPassword value) {
        return new JAXBElement<CheckPassword>(_CheckPassword_QNAME, CheckPassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SentMessageToAnnounceWithTargetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "sentMessageToAnnounceWithTargetResponse")
    public JAXBElement<SentMessageToAnnounceWithTargetResponse> createSentMessageToAnnounceWithTargetResponse(SentMessageToAnnounceWithTargetResponse value) {
        return new JAXBElement<SentMessageToAnnounceWithTargetResponse>(_SentMessageToAnnounceWithTargetResponse_QNAME, SentMessageToAnnounceWithTargetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnounceDecodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "announceDecodeResponse")
    public JAXBElement<AnnounceDecodeResponse> createAnnounceDecodeResponse(AnnounceDecodeResponse value) {
        return new JAXBElement<AnnounceDecodeResponse>(_AnnounceDecodeResponse_QNAME, AnnounceDecodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SentMessageToAnnounceWithTarget }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "sentMessageToAnnounceWithTarget")
    public JAXBElement<SentMessageToAnnounceWithTarget> createSentMessageToAnnounceWithTarget(SentMessageToAnnounceWithTarget value) {
        return new JAXBElement<SentMessageToAnnounceWithTarget>(_SentMessageToAnnounceWithTarget_QNAME, SentMessageToAnnounceWithTarget.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "initList")
    public JAXBElement<InitList> createInitList(InitList value) {
        return new JAXBElement<InitList>(_InitList_QNAME, InitList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "makeStudent")
    public JAXBElement<MakeStudent> createMakeStudent(MakeStudent value) {
        return new JAXBElement<MakeStudent>(_MakeStudent_QNAME, MakeStudent.class, null, value);
    }

}
