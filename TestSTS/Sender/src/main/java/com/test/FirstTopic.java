package com.test;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FirstTopic{
    public static void main(String[] agrs) {
        InitialContext initialContext = null;
        Connection connection = null;

        try {
            initialContext = new InitialContext();
            Topic topic = (Topic) initialContext.lookup("topic/myTopic");

            ConnectionFactory factory = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
            connection = factory.createConnection();
            Session createSession = connection.createSession();
            MessageProducer producer = createSession.createProducer(topic);
            TextMessage message  = createSession.createTextMessage("TOPIC : TEST TOPIC");
            producer.send(message);
            //connection.start();
            System.out.println("[POST]: TOPIC SEND");

        } catch (NamingException e) {
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
