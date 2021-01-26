/**
 * 
 */
package com.wayfair;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class HuluTempMemoryCreationTest {

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("Hello, World!");
		strings.add("Welcome to CoderPad.");
		strings.add("This pad is running Java " + Runtime.getRuntime().availableProcessors());

		DB db1 = new DB();
		DB db2 = new DB();
		DB db3 = new DB();
		DB db4 = new DB();
		DB db5 = new DB();

		List<DB> slaveList = new ArrayList<>();

		slaveList.add(db1);
		slaveList.add(db2);
		slaveList.add(db3);
		slaveList.add(db4);
		slaveList.add(db5);

		DB masterdb6 = new DB(slaveList);

		for (String string : strings) {
			System.out.println(string);
			masterdb6.set(string, string);
		}

		for(DB db: masterdb6.getSlaves()){
			System.out.println("db --  " + db.getStorate());
			System.out.println("Key base db values -- " + db.get("Hello, World!"));
		}

		/* System.out.println("db1 - " + db1.getStorate());

    System.out.println("db2 - " + db2.getStorate());

    //db2.setStorage(db1.getStorate());

    db1.set("Hello", "world");
    System.out.println(db1.get("Hello"));

    db2.set("Hello1" , "Bye");
    System.out.println(db1.get("Hello1"));
		 */ 
	}


}

//DB1 , storage1 ["a"="b"] -> id: 1234

//DB2 , storage2 [] -> id: 3456

//Db2.setStorage( storage 1)
// storage2 = storage1 ; // storage2 -> id: 1234


class DB {

	private Map<String,String> storage = new HashMap<>();
	private List<DB> slaves = new ArrayList<>();

	private String key;

	public DB(){
	}

	public DB(List<DB> slavesList) {
		this.slaves = slavesList;
	}


	public List<DB> getSlaves(){
		return this.slaves;
	}
	public Map<String,String> getStorate(){
		return this.storage;
	}

	/* public void setStorage(Map<String,String> storage){
    this.storage = storage;
  }
	 */

	void set(String key, String value){
		storage.put(key, value);
		replicateToSlave(key, value);
	}

	private void replicateToSlave(String key, String value) {
		for (DB db : slaves) {
			db.set(key, value);
		}
	}
	
	public String get(String key){
		return storage.get(key);
	}
}



/* 
Your previous Plain Text content is preserved below:

public class DB {
   //private Map<String,String> storage;

   String get(String key);
   void set(String key, String value);
}

 DB db1 = new DB();

 DB db2 = new DB();

 db1.set("a", "abc");
 db2.get("a"); //returns "abc"



 */