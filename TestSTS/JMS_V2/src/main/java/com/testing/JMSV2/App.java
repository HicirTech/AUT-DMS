package com.testing.JMSV2;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws NamingException, JMSException, InterruptedException {
		InitialContext initialContext = new InitialContext();
		Queue queue = (Queue) initialContext.lookup("queue/Announce");
		Queue queue2 = (Queue) initialContext.lookup("queue/myQueue");

		try (ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();) {
			JMSContext jmsContext = connectionFactory.createContext();

//           // SEND
//           jmsContext.createProducer().send(queue2,"Action-Announce-t-b");
//           System.out.println("out");
//           Thread.sleep(1000);
//           jmsContext.createProducer().send(queue2,"Action-Announce-t2-b2");
//           System.out.println("out");
//           Thread.sleep(1000);
			//jmsContext.createProducer().send(queue2, "Action-Announce-t3-b3");
		//	System.out.println("out");
			//Thread.sleep(1000);
			//jmsContext.createProducer().send(queue2, "Action-Announce-t4-b4");
//           System.out.println("out");
		//	Thread.sleep(1000);
		//	jmsContext.createProducer().send(queue2, "Action-View");

			// RECEIVE
//            String message = jmsContext.createConsumer(queue).receiveBody(String.class);
//            System.out.println("[GET] "+message);

		}

		// reply
//        try(ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
//        		JMSContext jmsContext = connectionFactory.createContext() ){
//            Queue requestQueue = (Queue) initialContext.lookup("queue/requestQueue");
//            Queue replyQueue = (Queue)initialContext.lookup("queue/replyQueue");
//
//            JMSProducer realProducer = jmsContext.createProducer();
//            TextMessage message = jmsContext.createTextMessage("<- [PRODUCER]: here is the message");
//            message.setJMSReplyTo(replyQueue);
//            realProducer.send(requestQueue,message); //message is out
//
//            JMSConsumer consumer  = jmsContext.createConsumer(requestQueue);
//            TextMessage textMessage = (TextMessage) consumer.receive();
//            System.out.println("[CONSUMER HAS THE MESSAGE]: "+textMessage.getText());
//
//            JMSProducer replyProducer = jmsContext.createProducer();
//            replyProducer.send(message.getJMSReplyTo()," <-[AFTER CONSUMER GET THE MESSAGE]: Reply back to where the message should go" );
//
//            JMSConsumer replyConsummer = jmsContext.createConsumer(replyQueue);
//            System.out.println("[REPLY CONSUMER HAS MESSAGE]:"+replyConsummer.receiveBody(String.class));
//
//
//        	
//        }

	}
}
