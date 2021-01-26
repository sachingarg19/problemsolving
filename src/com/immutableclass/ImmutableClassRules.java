/**
 * 
 */
package com.immutableclass;

/**
 * @author Sachin Garg
 *
 */
public final class ImmutableClassRules {

	/**
	 * @param args
	 */

	private final String name;


	private final int age;

	private ImmutableClassRules(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public static ImmutableClassRules createIntance(String name, int age){
		
		return new ImmutableClassRules(name, age);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

}
