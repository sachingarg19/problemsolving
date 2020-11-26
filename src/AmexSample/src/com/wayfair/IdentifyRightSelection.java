/**
 * 
 */
package com.wayfair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sachin Garg
 *
 */
public class IdentifyRightSelection {

	/**
	 * @param args
	 */
	static Map<String,String> selectionList = new HashMap<>();
	static List<String> buttonList = new ArrayList<>();
	static String selectButton = "PEPSI_BUTTON";
	static String selectButton1 = "OTHER_BUTTON";
	static String selectButton2 = "COKE_BUTTON";
	
	public static void main(String[] args) {
		selectionList.put("COKE_BUTTON","Pepsi");
		selectionList.put("PEPSI_BUTTON","other");
		selectionList.put("OTHER_BUTTON","Coke");
		
		System.out.println(isSelectionValidate(retreiveSelection(selectButton)));
		System.out.println(isSelectionValidate(retreiveSelection(selectButton1)));
		System.out.println(isSelectionValidate(retreiveSelection(selectButton2)));
	}
	
	static String retreiveSelection(String selection){
		return selectionList.get(selection);
	}
	
	static String isSelectionValidate(String selection){
		if("Coke".equalsIgnoreCase(selection)){
			return "COKE";
		}
		if("Pepsi".equalsIgnoreCase(selection)){
			return "PEPSI";
		}
		if("Other".equalsIgnoreCase(selection)){
			return "Other";
		}
		return "";
	}
	
	
}
