package com.amazon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Reorderlines
{ 
	
	public static void main(String[] args){
		
		List<String> abc = new ArrayList<String>();
		abc.add("abc1234 I am Abhishek Bihari");
		abc.add("abc345 19 05 83");
		abc.add("abc642 I am Sachin Garg");
		abc.add("kds54 16 12 1988");
		
		Reorderlines r = new Reorderlines();
		System.out.println(r.reorderLines(4, abc));
		
	}
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> reorderLines(int logFileSize, List<String> logfile) 
	{
    	Map<String, String> mapStr = new HashMap<String, String>();
	    List<String> StringFile=new ArrayList<String>();
	    List<String> numberFile=new ArrayList<String>();
		for (int count=0;count<logFileSize;count ++){
		    String tempString=logfile.get(count);
		    List<String> splitLogFile=Arrays.asList(tempString.split(" "));
		    if (splitLogFile.get(1) instanceof String){
		        StringFile.add(logfile.get(count));
		        String temp ="";
		        for(int i=1; i < splitLogFile.size(); i++){
		        	temp += splitLogFile.get(i) + " ";
		        	System.out.println(temp);
		        }
		        mapStr.put(splitLogFile.get(0), temp);
		    }else{
		        numberFile.add(logfile.get(count));
		    }
		}
		System.out.println(mapStr);
		Collections.sort(StringFile);
		System.out.println(StringFile);
		Collections.sort(numberFile);
		System.out.println(numberFile);
		StringFile.addAll(numberFile);
	return StringFile;
	}
	// METHOD SIGNATURE ENDS
}