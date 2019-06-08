/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServicePackage;

import BeanPackage.Gender;
import BeanPackage.Student;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

/**
 *
 * @author MY PHU NGUYEN
 */
@WebService(serviceName = "StudentWebService")
public class StudentWebService {
    /**
     * This is a sample web service operation
     */
        private ArrayList<Student> studentList;
         // The driverURL to contain the Database Driver
        private final String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        private final String dbURL = "jdbc:derby://localhost:1527/DMSDB;" +
                  "create=true;user=dms;password=dms2018";
        private final String tableName="Student_DB";

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @WebMethod(operationName = "initList")
    public int initList() throws Exception
    {
        this.studentList = new ArrayList<Student>();
        //Create Connection
        Connection connection= connectDatabaseSchema();
        // Creating the SQL Statement
        Statement statement = connection.createStatement();
        //if connect sucessfully

        //if studentDB table exist
        if (isTableExisting(tableName,connection))
        {
            System.out.println("table existed");
            //Reading records from Student Table
            ResultSet rs=statement.executeQuery("SELECT * FROM "+tableName);

            while(rs.next())
            {
                int studentID= rs.getInt("studentID"); //read studentID
                String name= rs.getString("name"); //read student  Name
                int age= rs.getInt("age");// read student age
                Gender gender= Gender.valueOf(rs.getString("gender"));
                String password= rs.getString("password");
                //create Student Object
                Student aStudent= new Student(studentID, name, age,gender,password);
                //add Student to studentList
                studentList.add(aStudent);
                System.out.println("one student has been added");
            }
        }
        else //if studentDB table not exist
        {
           System.out.println("table is not existed");
            // Step 4: Creating a new STUDENTDB table in DMSDB
            String sqlQuery = "CREATE TABLE "+tableName + " (studentID INT PRIMARY KEY," +
            " name VARCHAR(20), age INT, gender VARCHAR(20), password VARCHAR(20))";
            int resultDB = statement.executeUpdate(sqlQuery);
            if(resultDB == 0)
            System.out.println("Student Table is created");
            // Step 5: Inserting a record in the Student table in DMSDB
            sqlQuery = "INSERT INTO "+ tableName +" VALUES" +
            "(1, 'Minh',18, 'Male','123')," +
            "(2, 'Huyen',20, 'Female','123')," +
            "(3, 'Duc',19, 'Male','123')," +
            "(4, 'Nghia',45, 'Male','123'),"+
            "(5, 'Thuan',26, 'Female','123'),"+
            "(6, 'Hai',7, 'Male','123')";
            resultDB = statement.executeUpdate(sqlQuery);
            if(resultDB == 6)
            System.out.println("6 records are insterted in Student Table");
            //add data
            initialiseStudentList();
        }
        //close connection
        connection.close();
        return this.studentList.size();
    }

     @WebMethod(operationName = "makeStudent")
    public Student makeStudent(String name)
    {
        Student aStudent = new Student(name,18, Gender.Male);
        return aStudent;
    }



     private Connection connectDatabaseSchema() throws ClassNotFoundException, SQLException
     {

            // Step 1: Loading the drivers for JAVA DB
            Class.forName(driverURL);
            // Network Driver both will work with this example.
            // You can use any one of them
            //Class.forName("org.apache.derby.jdbc.ClientDriver");

            // Step 2: Connecting to sample Database in Java DB
            Connection connection = DriverManager.getConnection(dbURL);
            System.out.println("Database is connected...");
            return connection;
     }

    //this method is to check if the table Student already exist in the database
    private static boolean isTableExisting(String tableName, Connection theConnection) throws SQLException
    {
        DatabaseMetaData theMetaData = theConnection.getMetaData();

        ResultSet existingTable = theMetaData.getTables(null, null, tableName.toUpperCase(), null);

        if(existingTable.next())
        {
                return true;
        }
        return false;
    }

    private void initialiseStudentList()
    {
        studentList.add(new Student("Minh",18, Gender.Male));
        studentList.add(new Student("Huyen",20, Gender.Female));
        studentList.add(new Student("Duc",19, Gender.Male));
        studentList.add(new Student("Nghia",45, Gender.Male));
        studentList.add(new Student("Thuan",26, Gender.Female));
        studentList.add(new Student("Hai",7, Gender.Male));
    }
     //ZETING_____________
    private final String QUEUE_FACTORY_LOCATION = "myQueueConnectionFactory";
    private final String ANNOUNCE_QUEUE_LOCATION = "Announces";
    private final String NO_TARGET_INDICATOR = "0";

    @WebMethod(operationName = "changePassword")
    public boolean changePassword(int studentID, String newPassword) throws Exception {
        Connection connection = this.connectDatabaseSchema();
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate("UPDATE " + tableName + " SET PASSWORD = '" + newPassword + "' WHERE STUDENTID = " + studentID);
        return count > 0;
    }

    @WebMethod(operationName = "checkPassword")
    public boolean checkPassword(int studentID, String password) throws Exception {
        Connection connection = this.connectDatabaseSchema();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName);

        while (rs.next()) {
            if (rs.getInt("STUDENTID") == studentID) {
                return password.equals(rs.getString("PASSWORD"));

            }
        }
        return false;
    }

    @WebMethod(operationName = "getStudentInformation")
    public String getStudentInformation(int studentID) throws Exception {
        Connection connection = this.connectDatabaseSchema();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName);

        int sID=-1;
        String name="";
        int age=-1;
        Gender gender=Gender.Male;
        String password="123";
        while (rs.next()) {
            if (rs.getInt("STUDENTID") == studentID) {
                sID=rs.getInt("STUDENTID");
                name=rs.getString("NAME");
                age=rs.getInt("AGE");
                gender=Gender.valueOf(rs.getString("GENDER"));
                password=rs.getString("PASSWORD");
            }
        }
        Student aStudent= new Student(sID,name,age,gender,password);

        String xml= marshallStudentObject(aStudent);
        connection.close();
        return xml;
    }

    @WebMethod(operationName = "sentMessageToAnnounce")
    public void sentMessageToAnnounce(int announcesID, String topic, String body) throws Exception {
        String queueMessage = announcesID + "-"
                + this.NO_TARGET_INDICATOR + "-"
                + topic + "-"
                + body;
        this.messageOut(queueMessage);
    }

    @WebMethod(operationName = "sentMessageToAnnounceWithTarget")
    public void sentMessageToAnnounceWithTarget(int announcesID, String Target, String topic, String body) throws Exception {
        String queueMessage = announcesID + "-"
                + Target + "-"
                + topic + "-"
                + body;
        this.messageOut(queueMessage);
    }

    @WebMethod(operationName = "announceDecode")
    public ArrayList<String> announceDecode(String singleMessage) throws Exception {
        ArrayList<String> decoded = new ArrayList<>();
        String[] parts = singleMessage.split("-");
        for (String e : parts) {
            decoded.add(e);
        }
        return decoded;

    }

    @WebMethod(operationName = "getAnnounce")
    public ArrayList<String> getAnnounce() throws Exception {
        System.out.println("all announces");

        ArrayList<String> result = new ArrayList<>();
        InitialContext initialContext = new InitialContext();
        QueueConnectionFactory factory = (QueueConnectionFactory) initialContext.lookup(this.QUEUE_FACTORY_LOCATION);
        QueueConnection connection = factory.createQueueConnection();
        connection.start();

        QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue announceQueue = (Queue) initialContext.lookup(this.ANNOUNCE_QUEUE_LOCATION);

        QueueBrowser browser = session.createBrowser(announceQueue);
        Enumeration collection = browser.getEnumeration();

        if (!collection.hasMoreElements()) {
            System.out.println("[ANNOUNCES QUEUE: NO ELEMENT INSIDE!]");
        } else {
            while (collection.hasMoreElements()) {
                Message message = (Message) collection.nextElement();
                System.out.println(message.getBody(String.class));
                result.add(message.getBody(String.class));
            }
        }
        return result;
    }

    private void messageOut(String compeletedMessage) throws Exception {
        System.out.println("Message OUT.");
        InitialContext initialContext = new InitialContext();
        QueueConnectionFactory factory = (QueueConnectionFactory) initialContext.lookup(this.QUEUE_FACTORY_LOCATION);
        QueueConnection connection = factory.createQueueConnection();
        connection.start();
        QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue announceQueue = (Queue) initialContext.lookup(this.ANNOUNCE_QUEUE_LOCATION);
        QueueSender sender = session.createSender(announceQueue);
        TextMessage msg = session.createTextMessage(compeletedMessage);
        sender.send(msg);
        connection.close();
    }

    @WebMethod(operationName = "getStudentList")
    public ArrayList<Student> getStudentList() throws Exception {
        ArrayList<Student> result = new ArrayList<>();
        Connection connection = this.connectDatabaseSchema();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName);

        while (rs.next()) {
            Student tempS = new Student(rs.getInt("STUDENTID"),
                    rs.getString("NAME"),
                    rs.getInt("AGE"),
                    Gender.valueOf(rs.getString("GENDER")),
                    rs.getString("PASSWORD"));

            result.add(tempS);
        };

        return result;
    }

    @WebMethod(operationName = "addStudent")
    public int addStudent(String name, int age, String genderString) throws Exception
    {
        Gender gender= Gender.valueOf(genderString);
        Student aStudent= new Student(name, age, gender);
        int studentID = aStudent.getStudentID();
        String sql = "Insert into "+this.tableName+"(STUDENTID,NAME,AGE,GENDER,PASSWORD)VALUES("+studentID+",'"+name+"',"+age+",'"+genderString+"',"+"'123')";
        System.out.println(sql);
        Statement statement = this.connectDatabaseSchema().createStatement();
        statement.execute(sql);
        return this.getStudentList().size();
    }

    private String marshallStudentObject(Student aStudent) throws JAXBException
    {
         JAXBElement<Student> jaxbElement =  new JAXBElement(
          new QName(Student.class.getSimpleName()), Student.class, aStudent);

         //Create a String writer object which will be
         //used to write jaxbElment XML to string
         StringWriter writer = new StringWriter();

         // create JAXBContext which will be used to update writer
         JAXBContext context = JAXBContext.newInstance(Student.class);
          // marshall or convert jaxbElement containing student to xml format
         context.createMarshaller().marshal(jaxbElement, writer);
         return writer.toString();
    }

      @WebMethod(operationName = "unMarshallStudentObject")
    public Student unMarshallStudentObject(String xml) throws JAXBException
    {
         StringReader sr = new StringReader(xml);
         Student aStudent=    JAXB.unmarshal(sr, Student.class);
         return aStudent;
    }
}
