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


            TextMessage message  = session.createTextMessage("I am creator of my destiny");
            producer.send(message);
            System.out.println("POST:sent");
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
