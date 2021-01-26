
package com.amazon;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionItemCluster {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		/*
		 * final String fileName = System.getenv("OUTPUT_PATH"); BufferedWriter
		 * bw = new BufferedWriter(new FileWriter(fileName));
		 */
		int[] res;
		String _itemId;
		try {
			_itemId = in.nextLine();
		} catch (Exception e) {
			_itemId = null;
		}

		int _purchases_size = 0;

		// _purchases_size = Integer.parseInt(in.nextLine());

		String[] _purchases = new String[] { "first:ABC", " first:HIG",
				"sec:HIG", "sec:KLM", "third:NOP", "fourth:ABC", "fourth:QRS",
				" first:DEF", " fifth:KLM", "fifth:TUV" };
		System.out.println(_purchases.toString());
		String _purchases_item;
		/*
		 * for (int _purchases_i = 0; _purchases_i < _purchases_size;
		 * _purchases_i++) { try { _purchases_item = in.nextLine(); } catch
		 * (Exception e) { _purchases_item = null; } _purchases[_purchases_i] =
		 * _purchases_item; }
		 */

		res = determineRecommendation(_itemId, _purchases);
		/*
		 * for (int res_i = 0; res_i < res.length; res_i++) {
		 * bw.write(String.valueOf(res[res_i])); bw.newLine(); }
		 * 
		 * bw.close();
		 */
	}

	private static int[] determineRecommendation(String _itemId,
			String[] _purchases) {

	    int res[] = null;
        int custCount = 0;
        int custCountInvolved = 0,countNotInvoloved=0;
        int count=0,custC = 0;
        String custArray[]=new String[10];
        Map<String,String> map=new HashMap<>();
        String[] _purchasesCopy = new String[10];
        for (int i = 0; i < _purchases.length; i++) {
            if (_purchases[i].contains(_itemId)) {
                custCountInvolved++;
                String[] custNItem = _purchases[i].split(":");
                custArray[custC++]=custNItem[0];
                for (int j = 0; j < _purchases.length; j++) {
                    if (_purchases[j].contains(custNItem[0])) {
                        custCount++;
                    }
                }
            } else {
                _purchasesCopy[count] = _purchases[i];
                count++;
            }

        }
        
        for (int k=0;k<custArray.length;k++){
            for(int j=0;j<_purchasesCopy.length;j++){
                if(_purchasesCopy[j]!=null &&custArray[k]!=null&& !_purchasesCopy[j].contains(custArray[k])){
                   countNotInvoloved++; 
                } else{
                    
                }
            }
            
            
        }
        res[0]=custCount - custCountInvolved;
        res[1]=countNotInvoloved;
         
        return res;
	}
}