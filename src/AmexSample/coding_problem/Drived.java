/**
 * 
 */
package com.capitalone;

/**
 * @author Sachin Garg
 *
 */
public class Drived extends Base{

	int x = 10;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Base b = new Drived(); // x will be invoked by the reference type i.e. b.
		System.out.println(b.x);
	}

}
