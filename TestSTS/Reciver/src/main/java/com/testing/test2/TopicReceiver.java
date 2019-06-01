package com.testing.test2;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TopicReceiver {

    public static void main(String[] args) {
        InitialContext initialContext = null;
        Connection connection = null;

        try {
            initialContext = new InitialContext();
            Topic topic = (Topic) initialContext.lookup("topic/myTopic");
            ConnectionFactory factory = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
            connection = factory.createConnection();
            Session createSession = connection.createSession();
            MessageConsumer consumerA = createSession.createConsumer(topic);
            MessageConsumer consumerB = createSession.createConsumer(topic);

            connection.start();
          //  consumerA.receive(5000);
         //   consumerB.receive(5000);
            TextMessage messageA = (TextMessage) consumerA.receive();
            TextMessage messageB = (TextMessage) consumerB.receive();
            System.out.println("[GET]"+"[A]"+messageA.getText()+" [B] "+messageB.getText());


    }
        catch (NamingException e) {
            e.printStackTrace();
        }
        catch (JMSException e) {
            e.printStackTrace();
        }
        finally {
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
        }}

}
