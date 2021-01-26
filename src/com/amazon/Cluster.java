package com.amazon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


public class Cluster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<String> items=new ArrayList<String>();
		//HashMap<String, String> map=new HashMap<String, String>();
		List<HashSet<String>> listOfCluster=new ArrayList<HashSet<String>>();
		HashSet<String> set=new HashSet<String> ();
		Scanner sc=new Scanner(System.in);
		//System.out.println("Please Enter the thresold");
		float thresold=sc.nextFloat();
		//System.out.println("Please Enter the no of afifinity");
		//sc=new Scanner(System.in);
		int relationship=sc.nextInt();
		int clusterSize=0;
		for(int i=0;i<relationship;i++){
			//System.out.println("Please Enter first Item ");		
			String item1 =sc.next();

			//System.out.println("Please Enter Second Item ");		
			String item2 =sc.next();

			//System.out.println("Please Enter affinity");		
			sc=new Scanner(System.in);

			float af=sc.nextFloat();

			if(af>thresold){
				//


				if(listOfCluster!=null){
					listOfCluster.add(set);
					clusterSize=listOfCluster.size();
					for(int c=0;c<clusterSize;c++){
						if( (listOfCluster.get(i).contains(item1)|| listOfCluster.get(i).contains(item2))){
							listOfCluster.get(i).add(item1);
							listOfCluster.get(i).add(item2);
							break;
						}else{
							HashSet<String> set1=new HashSet<String> ();
							set1.add(item1);
							set1.add(item2);
							listOfCluster.add(set1);
							break;
						}
					}

				}


			}
		}
		if(listOfCluster!=null){
			int max = listOfCluster.get(0).size();
			HashSet<String> largestArray=new HashSet<String>();

			for (int k = 1; k < listOfCluster.size(); k++) {
				if (listOfCluster.get(k).size() > max) {
					max=listOfCluster.get(k).size();
					largestArray = listOfCluster.get(k);		      
				}}

			List<String> sortable=new ArrayList<String>();
			for(String s:largestArray){
				sortable.add(s);
			}
			Collections.sort(sortable);
			if(sortable!=null)
				System.out.println(sortable.get(0));
		}

	}

}