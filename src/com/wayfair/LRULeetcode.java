/**
 * 
 */
package com.wayfair;

import java.util.*;

/**
 * @author Sachin Garg
 *
 */
public class LRULeetcode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//LRUCache cache = new LRUCache( 2 /* capacity */ );

		/*cache.put(1, 1); //[2:1]
		//cache.displayStatus();
		cache.put(2, 2); // [2:2]
		//cache.displayStatus();
		System.out.println("get 1 " + cache.get(1));       // returns 1
		
		cache.put(3, 3);    // evicts key 2 //[3:3,2:2]
		//cache.displayStatus();
		System.out.println("get 2 " + cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1 ////[4:4,3:3,2:2]
		//cache.put(5, 7);
		//cache.displayStatus();
		System.out.println("get 1 " + cache.get(1));            // returns -1 (not found)
		System.out.println("get 3 " + cache.get(3));          // returns 3
		System.out.println("get 4 " + cache.get(4));           // returns 4
*/		 	
		
		//LRUCache cache = new LRUCache( 1 /* capacity */ );
		/*cache.put(2,1);
		//cache.displayStatus();
		System.out.println("get 2 - " + cache.get(2)); 
		cache.put(3,2);
		//cache.displayStatus();
		System.out.println("get 2 - " + cache.get(2));
		//cache.put(4, 4);
		//cache.put(5, 3);
		
		System.out.println("get 3 - " + cache.get(3)); */
		
		LRUCache cache = new LRUCache( 2 /* capacity */ );
		System.out.println("get 2 - " + cache.get(2));
		cache.put(2,6);
		System.out.println("get 1 - " + cache.get(1));
		cache.put(1,5);
		cache.put(1,2);
		System.out.println("get 1 - " + cache.get(1));
		System.out.println("get 2 - " + cache.get(2));


	}

}

class LRUCache {

	int capacity;
	Map<Integer, Integer> map = new HashMap<>();
	Deque<Integer> deque = new LinkedList<>();
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		//displayStatus();
		if(map.containsKey(key)){
			deque.remove(key);
			deque.addFirst(key);
			return map.get(key);	
		}

		return -1;  		      
	}

	public void put(int key, int value) {
		//if(!map.containsKey(key)){
		if(deque.size() == this.capacity) {
				map.remove(deque.removeLast());
		}
		deque.addFirst(key);
		map.put(key, value);
		//}
	}

	public void displayStatus(){
		System.out.println("deque - " + deque);
		System.out.println("map - " + map);
	}
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
