/**
 * 
 */
package com.amazon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TestRelationCluster {

	public static void main(String[] args)
	{

		for(String str : args){
			System.out.println("Str :: " + str);
		}
		Double affThreshold = new Double(0.15);
		Integer affinityRelationCt = new Integer(4);
		List<String> items=new ArrayList<String>();

		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter the thresold");
		float thresold=sc.nextFloat();
		System.out.println("Please Enter the no of afifinity");
		int relationship=sc.nextInt();
		String[] strArray = new String[affinityRelationCt];
		for(int i=0;i<relationship;i++){
			System.out.println("Please Enter first Item ");		
			//String item1 =sc.next();
			strArray[i] = sc.next();
		}
		
		System.out.println("strArray :: " + strArray);

		//System.out.println("Please Enter first Item ");		
		//String item2 =sc.next();

		//float af=sc.nextFloat();
		//String[] strArray = new String[affinityRelationCt];
		//		strArray[0] = "Item1 Item2 0.2";
		//		strArray[1] = "Item2 Item3 0.1";
		//		strArray[2] = "Item4 Item5 0.3";
		//		strArray[3] = "Item5 Item6 0.4";
		List<Set> clusterList = new ArrayList<Set>();
		for (String string : strArray) {

			Double affPrb = getProbofItems(string);
			if(affPrb > affThreshold)
			{
				Set cluster = checkIfItemExists(string, clusterList);
				if(cluster != null)
				{
					cluster.add(getItem1(string));
					cluster.add(getItem2(string));
					//clusterList.add(cluster);
				} else {
					Set<String> cluster1 = new LinkedHashSet<String>();
					cluster1.add(getItem1(string));
					cluster1.add(getItem2(string));
					clusterList.add(cluster1);
				}
			}

			//System.out.println(clusterList);
		}
		Set largestCluster = returnLargestCluster(clusterList);
		//System.out.println(">>"+clusterList);
		//System.out.println("Largest cluster >> "+largestCluster);
		Iterator itr = largestCluster.iterator();
		while (itr.hasNext()) {
			String str = (String) itr.next();
			System.out.println(str);
			return ;
		}
	}

	public static Set returnLargestCluster(List<Set> clusterList)
	{
		Set largestCluster = null;
		Integer size = new Integer(0);
		for (Set set : clusterList) {
			if(size < set.size())
			{
				size = set.size();
				largestCluster = set;
			}
		}
		return largestCluster;
	}

	public static Set checkIfItemExists(String str, List<Set> clusterList)
	{
		String[] strArray = str.split(" ");
		for (Set set : clusterList) {
			if( set.contains(strArray[0]) || set.contains(strArray[1]))
				return set;
		}
		return null;
	}

	public static String getItem1(String str)
	{
		String[] stringArray =  str.split(" ");
		return stringArray[0];
	}

	public static String getItem2(String str)
	{
		String[] stringArray =  str.split(" ");
		return stringArray[1];
	}

	public static Double getProbofItems(String str){
		String[] stringArray = str.split(" ");
		return Double.parseDouble(stringArray[2]);
	}


}