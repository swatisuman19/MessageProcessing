package com.technical.test.MessageProcessing;

import java.util.LinkedList;
import java.util.Queue;

import com.technical.test.MessageProcessing.impl.ConsumerImpl;
import com.technical.test.MessageProcessing.impl.PublisherImpl;
import com.technical.test.MessageProcessing.Interface.MessagePublisher;
import com.technical.test.MessageProcessing.Interface.MessageConsumer;

/**
 * @author swati
 * SaleNotificationProcessor is the begin of the application.
 * Creates Message Queue & Consume/process Message Queue.
 *
 */
public class SaleNotificationProcessor {
	public static void main(String[] args) {
		Queue<String> messageQ = new LinkedList<String>();
		
		MessagePublisher publisher = new PublisherImpl();
		MessageConsumer consumer = new ConsumerImpl();
		String inputFile = null;

		if (args.length != 0) {
			inputFile = args[0];
		} else {
			System.out.println("*** No input file provided, loading default input file ***");
			inputFile = "src/main/resources/inputMessages.txt";
		}

		messageQ = publisher.publishMessage(inputFile);

		consumer.consumeMessage(messageQ);

	}
}
