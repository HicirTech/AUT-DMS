package com.testing.test2;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Hello world!
 *
 */
public class QueueReceiver
{
    public static void main( String[] args )
    {
    	  InitialContext initialContext = null;
          Connection connection = null;

          try{
              initialContext= new InitialContext();
              ConnectionFactory factory = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
               connection= factory.createConnection();
              Session session = connection.createSession();
              Queue queue = (Queue) initialContext.lookup("queue/myQueue");
            //  TextMessage message  = session.createTextMessage("I am creator of my destiny");
             // producer.send(message);
             // System.out.println("POST:sent");

              MessageConsumer consumer = session.createConsumer(queue);
              connection.start();
              TextMessage messageRecivied = (TextMessage) consumer.receive(1000);
              System.out.println("GET:"+messageRecivied.getText());
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

