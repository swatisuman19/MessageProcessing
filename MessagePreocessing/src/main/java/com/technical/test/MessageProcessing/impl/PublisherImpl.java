/**
 * 
 */
package com.technical.test.MessageProcessing.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import com.technical.test.MessageProcessing.Interface.MessagePublisher;

/**
 * @author swati
 * Read each line from input file as a message & add to Message Queue
 *
 */
public class PublisherImpl implements MessagePublisher {

	Queue<String> messageQ = new LinkedList<>();
	
	public PublisherImpl(Queue<String> messageQ) {
		super();
		this.messageQ = messageQ;
	}

	public PublisherImpl() {
		
	}

	@Override
	public Queue<String> publishMessage(String inputFile) {
		
		BufferedReader bufferedReader = null;
		String saleMessage;
		try {
			File inFile = new File(inputFile);
			bufferedReader = new BufferedReader(new FileReader(inFile));
			while ((saleMessage = bufferedReader.readLine()) != null) {
				
				messageQ.add(saleMessage);
			}
		} catch (java.io.IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return messageQ;
	}

}
