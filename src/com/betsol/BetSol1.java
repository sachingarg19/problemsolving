/**
 * 
 */
package com.betsol;

/**
 * @author Sachin Garg
 *
 */
public class BetSol1 {

	/**
	 * @param args
	 */
	
	        public static void main(String [] args) 
	        {
	        	BetSol1 h = new BetSol1(); 
	             h.methodA(); /* Line 6 */
	            try 
	            {
	            	System.exit(1);
	                badMethod();  
	                System.out.print("A");
	                
	            }  	
	            catch (Exception ex) 
	            {
	                System.out.print("B");  
	            } 
	            finally 
	            {
	                System.out.print("C"); 
	            } 
	            System.out.print("D"); 
	        }  
	        public static void badMethod() 
	        {
	            throw new Error(); 
	        } 
	    
	        Object methodA() 
	        {
	            Object obj1 = new Object(); 
	            Object [] obj2 = new Object[1]; 
	            obj2[0] = obj1; 
	            obj1 = null; 
	            return obj2[0]; 
	        } 
}
