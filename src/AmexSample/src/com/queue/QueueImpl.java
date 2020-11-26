/**
 * 
 */
package com.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sachin Garg
 *
 */
public class QueueImpl {

	/**
	 * @param args
	 */
	Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		QueueImpl q = new QueueImpl();
		
		q.enqueueList();
		q.retrieve();
		q.dequeueList();
		q.retrieve();

	}
	private void dequeueList() {
		
		System.out.println(queue.remove(1));
		System.out.println(queue.poll());
		System.out.println(queue.size());
		//System.out.println(queue.remove());//throws java.util.NoSuchElementException
	}
	private void retrieve() {
		System.out.println(queue.peek());	
		//System.out.println(queue.element());	
	}
	private void enqueueList() {
		
		queue.add(1);
		queue.add(2);		
	}

}
