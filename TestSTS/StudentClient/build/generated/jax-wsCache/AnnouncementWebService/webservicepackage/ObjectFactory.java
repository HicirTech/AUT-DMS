
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

    private final static QName _SelectAllAnnouncementDBResponse_QNAME = new QName("http://WebServicePackage/", "selectAllAnnouncementDBResponse");
    private final static QName _Exception_QNAME = new QName("http://WebServicePackage/", "Exception");
    private final static QName _AddAnnouncementResponse_QNAME = new QName("http://WebServicePackage/", "addAnnouncementResponse");
    private final static QName _SelectAllAnnouncementDB_QNAME = new QName("http://WebServicePackage/", "selectAllAnnouncementDB");
    private final static QName _MakeAnnouncementObjectResponse_QNAME = new QName("http://WebServicePackage/", "makeAnnouncementObjectResponse");
    private final static QName _GetAnnouncementList_QNAME = new QName("http://WebServicePackage/", "getAnnouncementList");
    private final static QName _MakeAnnouncementObject_QNAME = new QName("http://WebServicePackage/", "makeAnnouncementObject");
    private final static QName _InitAnnouncement_QNAME = new QName("http://WebServicePackage/", "initAnnouncement");
    private final static QName _AddAnnouncement_QNAME = new QName("http://WebServicePackage/", "addAnnouncement");
    private final static QName _GetAnnouncementListResponse_QNAME = new QName("http://WebServicePackage/", "getAnnouncementListResponse");
    private final static QName _InitAnnouncementResponse_QNAME = new QName("http://WebServicePackage/", "initAnnouncementResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservicepackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddAnnouncement }
     * 
     */
    public AddAnnouncement createAddAnnouncement() {
        return new AddAnnouncement();
    }

    /**
     * Create an instance of {@link GetAnnouncementListResponse }
     * 
     */
    public GetAnnouncementListResponse createGetAnnouncementListResponse() {
        return new GetAnnouncementListResponse();
    }

    /**
     * Create an instance of {@link InitAnnouncementResponse }
     * 
     */
    public InitAnnouncementResponse createInitAnnouncementResponse() {
        return new InitAnnouncementResponse();
    }

    /**
     * Create an instance of {@link InitAnnouncement }
     * 
     */
    public InitAnnouncement createInitAnnouncement() {
        return new InitAnnouncement();
    }

    /**
     * Create an instance of {@link MakeAnnouncementObject }
     * 
     */
    public MakeAnnouncementObject createMakeAnnouncementObject() {
        return new MakeAnnouncementObject();
    }

    /**
     * Create an instance of {@link GetAnnouncementList }
     * 
     */
    public GetAnnouncementList createGetAnnouncementList() {
        return new GetAnnouncementList();
    }

    /**
     * Create an instance of {@link MakeAnnouncementObjectResponse }
     * 
     */
    public MakeAnnouncementObjectResponse createMakeAnnouncementObjectResponse() {
        return new MakeAnnouncementObjectResponse();
    }

    /**
     * Create an instance of {@link SelectAllAnnouncementDB }
     * 
     */
    public SelectAllAnnouncementDB createSelectAllAnnouncementDB() {
        return new SelectAllAnnouncementDB();
    }

    /**
     * Create an instance of {@link AddAnnouncementResponse }
     * 
     */
    public AddAnnouncementResponse createAddAnnouncementResponse() {
        return new AddAnnouncementResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link SelectAllAnnouncementDBResponse }
     * 
     */
    public SelectAllAnnouncementDBResponse createSelectAllAnnouncementDBResponse() {
        return new SelectAllAnnouncementDBResponse();
    }

    /**
     * Create an instance of {@link Announcement }
     * 
     */
    public Announcement createAnnouncement() {
        return new Announcement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectAllAnnouncementDBResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "selectAllAnnouncementDBResponse")
    public JAXBElement<SelectAllAnnouncementDBResponse> createSelectAllAnnouncementDBResponse(SelectAllAnnouncementDBResponse value) {
        return new JAXBElement<SelectAllAnnouncementDBResponse>(_SelectAllAnnouncementDBResponse_QNAME, SelectAllAnnouncementDBResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAnnouncementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "addAnnouncementResponse")
    public JAXBElement<AddAnnouncementResponse> createAddAnnouncementResponse(AddAnnouncementResponse value) {
        return new JAXBElement<AddAnnouncementResponse>(_AddAnnouncementResponse_QNAME, AddAnnouncementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectAllAnnouncementDB }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "selectAllAnnouncementDB")
    public JAXBElement<SelectAllAnnouncementDB> createSelectAllAnnouncementDB(SelectAllAnnouncementDB value) {
        return new JAXBElement<SelectAllAnnouncementDB>(_SelectAllAnnouncementDB_QNAME, SelectAllAnnouncementDB.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeAnnouncementObjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "makeAnnouncementObjectResponse")
    public JAXBElement<MakeAnnouncementObjectResponse> createMakeAnnouncementObjectResponse(MakeAnnouncementObjectResponse value) {
        return new JAXBElement<MakeAnnouncementObjectResponse>(_MakeAnnouncementObjectResponse_QNAME, MakeAnnouncementObjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnnouncementList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "getAnnouncementList")
    public JAXBElement<GetAnnouncementList> createGetAnnouncementList(GetAnnouncementList value) {
        return new JAXBElement<GetAnnouncementList>(_GetAnnouncementList_QNAME, GetAnnouncementList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeAnnouncementObject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "makeAnnouncementObject")
    public JAXBElement<MakeAnnouncementObject> createMakeAnnouncementObject(MakeAnnouncementObject value) {
        return new JAXBElement<MakeAnnouncementObject>(_MakeAnnouncementObject_QNAME, MakeAnnouncementObject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitAnnouncement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "initAnnouncement")
    public JAXBElement<InitAnnouncement> createInitAnnouncement(InitAnnouncement value) {
        return new JAXBElement<InitAnnouncement>(_InitAnnouncement_QNAME, InitAnnouncement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAnnouncement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "addAnnouncement")
    public JAXBElement<AddAnnouncement> createAddAnnouncement(AddAnnouncement value) {
        return new JAXBElement<AddAnnouncement>(_AddAnnouncement_QNAME, AddAnnouncement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnnouncementListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "getAnnouncementListResponse")
    public JAXBElement<GetAnnouncementListResponse> createGetAnnouncementListResponse(GetAnnouncementListResponse value) {
        return new JAXBElement<GetAnnouncementListResponse>(_GetAnnouncementListResponse_QNAME, GetAnnouncementListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitAnnouncementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "initAnnouncementResponse")
    public JAXBElement<InitAnnouncementResponse> createInitAnnouncementResponse(InitAnnouncementResponse value) {
        return new JAXBElement<InitAnnouncementResponse>(_InitAnnouncementResponse_QNAME, InitAnnouncementResponse.class, null, value);
    }

}
