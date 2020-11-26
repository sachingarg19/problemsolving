/**
 * 
 */
package com.immutableclass;

/**
 * @author Sachin Garg
 *
 */
public class TestImmutable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ImmutableClassRules im = ImmutableClassRules.createIntance("Sachin", 10);
		System.out.println(im.getName() + " " + im.getAge());
		mockImmutable(im.getName(), im.getAge());
		System.out.println(im.getName() + " " + im.getAge());
	}

	public static void mockImmutable(String name, int age){
		name = "Gaddu";
		age = 5;
	}


}
