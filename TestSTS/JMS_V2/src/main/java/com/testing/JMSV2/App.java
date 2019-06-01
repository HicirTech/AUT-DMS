package com.testing.JMSV2;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NamingException {
        InitialContext initialContext = new InitialContext();
        Queue queue  = (Queue) initialContext.lookup("queue/myQueue");

        try(ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();){
            JMSContext jmsContext = connectionFactory.createContext();

            //SEND
            jmsContext.createProducer().send(queue,"V2_SEND");

            //RECEIVE
            String message = jmsContext.createConsumer(queue).receiveBody(String.class);
            System.out.println("[GET] "+message);
        }
    }
}
