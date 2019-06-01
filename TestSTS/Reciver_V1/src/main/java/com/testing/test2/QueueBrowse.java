package com.testing.test2;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Enumeration;

public class QueueBrowse {

	public static void main(String[] args) {
		InitialContext initialContext = null;
		Connection connection = null;

		try {
			initialContext = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
			connection = factory.createConnection();
			Session session = connection.createSession();
			Queue queue = (Queue) initialContext.lookup("queue/myQueue");
			QueueBrowser queueBrowser =  session.createBrowser(queue);
			Enumeration messageEnum = queueBrowser.getEnumeration();

			while (messageEnum.hasMoreElements()){
				TextMessage message  = (TextMessage) messageEnum.nextElement();
				System.out.println("[in QUEUE : ]"+message.getText());
			}


			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (initialContext != null) {
				try {
					initialContext.close();
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
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
