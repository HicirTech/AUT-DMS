package  com.test;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FirstQueue {

    public static void main(String[] args){
        InitialContext initialContext = null;
        Connection connection = null;

        try{
            initialContext= new InitialContext();
            ConnectionFactory factory = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
             connection= factory.createConnection();
            Session session = connection.createSession();
            Queue queue = (Queue) initialContext.lookup("queue/myQueue");
            MessageProducer producer =  session.createProducer(queue);


//            TextMessage message  = session.createTextMessage("UserDB-Insert-RName-RPass-Radmin-Rbio-RPaper");
//            producer.send(message);
//            System.out.println("POST:sent");
//            message  = session.createTextMessage("UserDB-Find-RName");
//            producer.send(message);
//            message  = session.createTextMessage("UserDB-Find-RName");
//            producer.send(message);
//            message  = session.createTextMessage("UserDB-View");
//            producer.send(message);
            TextMessage message  = session.createTextMessage("Action-Announce");
            producer.send(message);
            
        }
        catch (NamingException e){
                e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
        	if(initialContext!=null) {
        		try {
					initialContext.close();
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	if(connection!=null) {
        		try {
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	
       
        }
    }
}
