package DMS.A3.Server;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

public class ServerAction {

    private final String ANNOUNCE_QUEUE_LOCAION = "queue/Announce";
    private InitialContext initialContext;
    private Connection connection;
    private Queue announceQueue;
    private Session session ;
    private JMSContext context;
    private   ConnectionFactory factory;

    ServerAction()  {
        try {
            this.initialContext = new InitialContext();
            factory = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
            connection= factory.createConnection();
            session = connection.createSession();
            this.announceQueue= (Queue) initialContext.lookup(this.ANNOUNCE_QUEUE_LOCAION);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public void sendAnnounce(String topic,String body){
        try {
            MessageProducer producer =  session.createProducer(this.announceQueue);
            TextMessage message  = session.createTextMessage(topic+"-"+body);
            producer.send(message);
            System.out.println("Send announces: "+topic+"-"+body);
            this.context.createProducer().send(announceQueue,topic+"-"+body);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String,String> seeAnnounceQueue(){

        System.out.println("Server output all queue trigger");

        HashMap<String,String> topicBodyPair = new HashMap<>();
        try {
            QueueBrowser browser = session.createBrowser(this.announceQueue);
            Enumeration msgs = browser.getEnumeration();

            while(msgs.hasMoreElements()){
                Message tempMsg = (Message)msgs.nextElement();
                System.out.println("Message: " + tempMsg.getBody(String.class));
                String[] result = tempMsg.getBody(String.class).split("-");
                topicBodyPair.put(result[0],result[1]);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
        System.out.println(topicBodyPair);
        return topicBodyPair;
    }




}
