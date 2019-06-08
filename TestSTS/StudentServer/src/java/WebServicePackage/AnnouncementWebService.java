/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServicePackage;


import BeanPackage.Announcement;
import BeanPackage.Gender;
import BeanPackage.Student;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;


/**
 *
 * @author MY PHU NGUYEN
 */
@WebService(serviceName = "AnnouncementWebService")
public class AnnouncementWebService {
    private ArrayList<Announcement> announcementList;
             // The driverURL to contain the Database Driver
        private final String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        private final String dbURL = "jdbc:derby://localhost:1527/DMSDB;" + 
                  "create=true;user=dms;password=dms2018";
        private final String tableName="Announcement_DB";
    
    @WebMethod(operationName = "initAnnouncement")
    public int initAnnouncement() throws Exception
    {
        announcementList= new ArrayList<Announcement>();
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
                int announcementID= rs.getInt("announcementID"); 
                String target= rs.getString("target");
                String topic= rs.getString("topic");
                String body= rs.getString("body");
                //create announcement Object
                Announcement anAnncouncement= new Announcement(announcementID, target, topic,body);
                //add announcement to studentList
                announcementList.add(anAnncouncement);
                System.out.println("one announcement has been added");
            }               
        }
        else //if studentDB table not exist
        {
           System.out.println("table is not existed");
            // Step 4: Creating a new STUDENTDB table in DMSDB
            String sqlQuery = "CREATE TABLE "+tableName + " (announcementID INT PRIMARY KEY," +
            " target VARCHAR(50), topic VARCHAR(50), body VARCHAR(50))";
            int resultDB = statement.executeUpdate(sqlQuery);
            if(resultDB == 0)
            System.out.println("Announcement Table is created");
            // Step 5: Inserting a record in the Student table in DMSDB
            sqlQuery = "INSERT INTO "+ tableName +" VALUES" +
            "(1, '1','Topic 11','Body 11')," +
            "(2, '2','Topic 22','Body 22')," +
            "(3, '3','Topic 33','Body 33')," +
            "(4, '1','Topic 41','Body 41'),"+
            "(5, '0','Topic 50','Body 50'),"+
            "(6, '0','Topic 60','Body 60')";
            resultDB = statement.executeUpdate(sqlQuery);
            if(resultDB == 6)
            System.out.println("6 records are insterted in Announcement Table");
            //add data
            initialiseAnnouncementList();
        }
        //close connection
        connection.close();
        return this.announcementList.size();
    }
    
    @WebMethod(operationName = "makeAnnouncementObject")
    public Announcement makeAnnouncementObject(String target, String topic, String body)
    {
        Announcement anAnnouncement = new Announcement(target,topic, body);
        return anAnnouncement;
    }
    
    @WebMethod(operationName = "getAnnouncementList")
    public ArrayList<Announcement> getAnnouncementList() throws Exception {
        announcementList=selectAllAnnouncementDB();
        return announcementList;
    }
    
    @WebMethod(operationName = "addAnnouncement")
    public int addAnnouncement(String target, String topic, String body) throws Exception
    {
        Announcement anAnncouncement= new Announcement(target,topic, body);
        Connection connection= connectDatabaseSchema();
        // Creating the SQL Statement
        Statement statement = connection.createStatement();
        System.out.println(anAnncouncement.getAnnouncementID());
        String sqlQuery = "INSERT INTO "+ tableName +" VALUES (" + 
                anAnncouncement.getAnnouncementID()+" ,'"+anAnncouncement.getTarget()+"' ,'"+anAnncouncement.getTopic()+"','"+anAnncouncement.getBody()+"')";
        statement.executeUpdate(sqlQuery);
        System.out.println(sqlQuery);
        System.out.println("a Announcement has been added");
        //close connection
        connection.close();
        announcementList=selectAllAnnouncementDB();
        if(target.equals("0")){
              this.sentMessageToAnnounce(anAnncouncement.getAnnouncementID(),
                    anAnncouncement.getTopic(), anAnncouncement.getBody());
        }else{
            this.sentMessageToAnnounceWithTarget(anAnncouncement.getAnnouncementID(),
                    anAnncouncement.getTarget(), anAnncouncement.getTopic(), anAnncouncement.getBody());
        }
        return announcementList.size();
    }
    
    @WebMethod(operationName = "selectAllAnnouncementDB")
    public ArrayList<Announcement> selectAllAnnouncementDB() throws Exception
    {
        announcementList.clear();
        //Create Connection
        Connection connection= connectDatabaseSchema();
        // Creating the SQL Statement
        Statement statement = connection.createStatement();
        //Reading records from Student Table
        ResultSet rs=statement.executeQuery("SELECT * FROM "+tableName);

        while(rs.next())
        {
            int announcementID= rs.getInt("announcementID"); 
            String target= rs.getString("target");
            String topic= rs.getString("topic");
            String body= rs.getString("body");
            //create announcement Object
            Announcement anAnncouncement= new Announcement(announcementID, target, topic,body);
            //add announcement to studentList
            announcementList.add(anAnncouncement);
            System.out.println("one announcement has been added");
        }
        //close connection
        connection.close();
        return announcementList;
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
    
    private void initialiseAnnouncementList()
    {
        announcementList.add(new Announcement("1","Topic 11", "Body 11"));
        announcementList.add(new Announcement("2","Topic 22", "Body 22"));
        announcementList.add(new Announcement("3","Topic 33", "Body 33"));
        announcementList.add(new Announcement("1","Topic 41", "Body 41"));
        announcementList.add(new Announcement("0","Topic 50", "Body 50"));
        announcementList.add(new Announcement("0","Topic 60", "Body 60"));
    }
    //___________
    
    private final String QUEUE_FACTORY_LOCATION = "myQueueConnectionFactory";
    private final String ANNOUNCE_QUEUE_LOCATION = "Announces";
    private final String NO_TARGET_INDICATOR = "0";

    private void sentMessageToAnnounce(int announcesID, String topic, String body) throws Exception {
        String queueMessage = announcesID + "-"
                + this.NO_TARGET_INDICATOR + "-"
                + topic + "-"
                + body;
        this.messageOut(queueMessage);
    }

    private void sentMessageToAnnounceWithTarget(int announcesID, String Target, String topic, String body) throws Exception {
        String queueMessage = announcesID + "-"
                + Target + "-"
                + topic + "-"
                + body;
        this.messageOut(queueMessage);
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
}
