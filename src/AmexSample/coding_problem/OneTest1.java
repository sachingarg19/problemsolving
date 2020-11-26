/**
 * 
 */
package com.capitalone;

/**
 * @author Sachin Garg
 *Puzzle One
 *
 */
public class OneTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double[] inputValues = {-1.01,-1.01,5.0,6.0,7.0};
		System.out.println(getStatistics(inputValues));

	}


	public static String getStatistics(Double[] inputValues){
		String average = "Average: ";
	    
	    if(null == inputValues){
				return "No transactions found.";
			}
			if(inputValues.length == 0){
				return "No transactions found.";
			}

			int len = 0;
			double averageValue = 0;
			for(Double value : inputValues){
				if(null != value && value.doubleValue() > 0){
					averageValue = averageValue + value.doubleValue();
					len = len +1;
				}			
			}

			if(averageValue > 0){
				averageValue = averageValue/len;
			}else{
	            return "No positive transactions found.";
	        }
			
			System.out.println(averageValue);
			
			return average.concat(decimalFormatter(averageValue));	}

	private static String decimalFormatter(Double value) {
		System.out.println(String.format("%.2f", value));
		return String.format("%.2f", value);
	}

}
