package DMS.A3.Server;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;



/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws NamingException {
        InitialContext initialContext = new InitialContext();
        Queue queue = (Queue) initialContext.lookup("queue/myQueue");

        try (ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();) {
            JMSContext jmsContext = connectionFactory.createContext();
//
//            //SEND
//            jmsContext.createProducer().send(queue,"V2_SEND");

            JMSConsumer serverEntry = jmsContext.createConsumer(queue);
            //RECEIVE
            while (true) {//here
                try {
                    TextMessage message = (TextMessage) serverEntry.receive(1000);//.receiveBody(String.class);
                    System.out.println("[SERVER GET] " + message.getText());
                    messageAnalyzer(message);
                } catch (JMSException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    System.out.println("not thing get from queue");
                }
            }//hre
        }

    }

    private static void messageAnalyzer(TextMessage message) throws JMSException {
        String content = message.getText();
        String[] methodType = content.split("-");
        System.out.println(methodType[0]);


        switch (methodType[0]) {

            case "UserDB": {
                UserDB db = new UserDB();
                db.connectionToDerby();
                switch (methodType[1]) {
                    case "Insert":
                        System.out.println("Insert trigger: message" + methodType[2] + methodType[3] + methodType[4] + methodType[5] + methodType[6]);
                        boolean result = db.insertNewStudent(methodType[2], methodType[3], methodType[4], methodType[5], methodType[6]);
                        System.out.println("insert result: " + result);
                        break;
                    case "Find":
                        System.out.println("Find ID by name trigger");
                        int ID = db.viewIdByName(methodType[2]);
                        System.out.println(
                                ID == -1 ?
                                        "NO such person with name " + methodType[2] : "id located in " + ID);
                        break;

                    case "View":
                        System.out.println("View all student trigger");
                        db.viewAllStudent();
                        break;
                    default:
                        System.out.println("trigger user db but not use any method|| message is " + methodType[1]);
                        break;
                }
            }

            case "Action":{
                ServerAction actor = new ServerAction();

                System.out.println(methodType[1]);
                switch(methodType[1]){
                    case "Announce":
                        System.out.println("Announce trigger ");
                        actor.sendAnnounce(methodType[2],methodType[3]);
                        break;
                    case "View":
                        System.out.println("View all announces");
                        actor.seeAnnounceQueue();

                }
            }
            default:
                System.out.println("message not trigger action");
        }
    }
}
