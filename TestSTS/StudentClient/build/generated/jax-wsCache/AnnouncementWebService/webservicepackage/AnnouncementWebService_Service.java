
package webservicepackage;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AnnouncementWebService", targetNamespace = "http://WebServicePackage/", wsdlLocation = "http://localhost:8080/StudentServer/AnnouncementWebService?wsdl")
public class AnnouncementWebService_Service
    extends Service
{

    private final static URL ANNOUNCEMENTWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException ANNOUNCEMENTWEBSERVICE_EXCEPTION;
    private final static QName ANNOUNCEMENTWEBSERVICE_QNAME = new QName("http://WebServicePackage/", "AnnouncementWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/StudentServer/AnnouncementWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ANNOUNCEMENTWEBSERVICE_WSDL_LOCATION = url;
        ANNOUNCEMENTWEBSERVICE_EXCEPTION = e;
    }

    public AnnouncementWebService_Service() {
        super(__getWsdlLocation(), ANNOUNCEMENTWEBSERVICE_QNAME);
    }

    public AnnouncementWebService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), ANNOUNCEMENTWEBSERVICE_QNAME, features);
    }

    public AnnouncementWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, ANNOUNCEMENTWEBSERVICE_QNAME);
    }

    public AnnouncementWebService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ANNOUNCEMENTWEBSERVICE_QNAME, features);
    }

    public AnnouncementWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AnnouncementWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AnnouncementWebService
     */
    @WebEndpoint(name = "AnnouncementWebServicePort")
    public AnnouncementWebService getAnnouncementWebServicePort() {
        return super.getPort(new QName("http://WebServicePackage/", "AnnouncementWebServicePort"), AnnouncementWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AnnouncementWebService
     */
    @WebEndpoint(name = "AnnouncementWebServicePort")
    public AnnouncementWebService getAnnouncementWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://WebServicePackage/", "AnnouncementWebServicePort"), AnnouncementWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ANNOUNCEMENTWEBSERVICE_EXCEPTION!= null) {
            throw ANNOUNCEMENTWEBSERVICE_EXCEPTION;
        }
        return ANNOUNCEMENTWEBSERVICE_WSDL_LOCATION;
    }

}
