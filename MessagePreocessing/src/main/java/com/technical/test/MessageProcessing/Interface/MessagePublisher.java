/**
 * 
 */
package com.technical.test.MessageProcessing.Interface;

import java.util.Queue;

/**
 * @author swati
 *
 */
public interface MessagePublisher {

	Queue<String> publishMessage(String inputFile);

}
