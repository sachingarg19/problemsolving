/**
 * 
 */
package com.equals;

/**
 * @author Sachin Garg
 *
 */
public class EqualOverride {

	String name;
	int age;
	Object obj;

	/**
	 * 
	 */
	public EqualOverride() {

	}

	public EqualOverride(String name, int age){
		this.name = name;
		this.age = age;	
	}


	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}else if(null == obj || this.getClass() != obj.getClass()){
			return false;
		}

		EqualOverride eq = (EqualOverride)obj;

		return EqualsUtil.equalString(this.name, eq.name) && EqualsUtil.equalInt(this.age, eq.age);

	}

	/*public int hashCode(){

		return 0;
	}*/
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EqualOverride eq = new EqualOverride("A", 12);
		
		EqualOverride eq1 = new EqualOverride("B", 15);
		
		EqualOverride eq2 = new EqualOverride("A", 12);
		
		System.out.println(eq.equals(eq));
		System.out.println(eq.equals(eq1));
		System.out.println(eq.equals(eq2));
	}


}
