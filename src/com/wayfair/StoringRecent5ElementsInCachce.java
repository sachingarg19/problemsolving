/**
 * 
 */
package com.wayfair;

import java.util.*;

/**
 * @author Sachin Garg
 *
 */
public class StoringRecent5ElementsInCachce {

	/**
	 * @param args
	 */
	static HashSet<String> inMemoryCache = new HashSet<>();
	static Deque<String> linkList = new LinkedList<String>();
	static int size = 2;
	public static void main(String[] args) {


		storingRecentTrxn("1");
		storingRecentTrxn("2");
		storingRecentTrxn("3");
		storingRecentTrxn("1");
		storingRecentTrxn("5");
		storingRecentTrxn("6");
		storingRecentTrxn("7");
		System.out.println(inMemoryCache);
		System.out.println(linkList);

		System.out.println("------------------");


		LRU.buildInMemoryCache("1");
		LRU.buildInMemoryCache("2");
		LRU.buildInMemoryCache("3");
		LRU.buildInMemoryCache("1");
		LRU.buildInMemoryCache("5");
		LRU.buildInMemoryCache("6");
		LRU.buildInMemoryCache("7");
		LRU.buildInMemoryCache("3");
		LRU.buildInMemoryCache("3");
		LRU.buildInMemoryCache("1");
		LRU.buildInMemoryCache("2");
		LRU.displayStatus();
		LRU.buildInMemoryCache("3");
		LRU.displayStatus();
		LRU.buildInMemoryCache("4");
		LRU.displayStatus();
	}
	private static void storingRecentTrxn(String data) {

		if(!inMemoryCache.contains(data)){
			if(linkList.size() == size){
				String last = linkList.removeLast();
				inMemoryCache.remove(last);
			}
			else{
				Iterator itr = linkList.iterator();
				int index = 0, i=0;
				while(itr.hasNext()){
					if(itr.next() == data){
						index = i;
						break;
					}
					i++;
				}
				linkList.remove(index);
			}
			linkList.push(data);
			inMemoryCache.add(data);
		}
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
		displayStatus();
		if(map.containsKey(key)){
			return map.get(key);	
		}

		return -1;  		      
	}

	public void put(int key, int value) {
		
		if(map.size() == this.capacity && deque.size() == this.capacity) {
			if(value <=3){
				map.remove(deque.remove());
			} else{
				map.remove(deque.removeLast());
			}
		}
		if(!map.containsKey(key)){
			deque.push(key); 
		}
		map.put(key, value);

		displayStatus();
	}

	public void displayStatus(){
		System.out.println(deque);
		System.out.println(map);
	}
}
