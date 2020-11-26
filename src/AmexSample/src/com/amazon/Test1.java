package com.amazon;

import java.util.*;

public class Test1 {

	
	List<Integer>[] g;
	int[] disc;
	int[] low;
	int n, time;
	List<List<Integer>> res;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> links = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(3);
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(2);
		list3.add(4);
		ArrayList<Integer> list4 = new ArrayList<>();
		list4.add(3);
		list4.add(4);
		ArrayList<Integer> list5 = new ArrayList<>();
		list5.add(3);
		list5.add(6);
		ArrayList<Integer> list6 = new ArrayList<>();
		list6.add(6);
		list6.add(7);
		ArrayList<Integer> list7 = new ArrayList<>();
		list7.add(4);
		list7.add(5);

		links.add(list1);
		links.add(list2);
		links.add(list3);
		links.add(list4);
		links.add(list5);
		links.add(list6);
		links.add(list7);

		System.out.println(new Test1().criticalRouters(7, 7,links));
	}
	public List<List<Integer>> criticalRouters(int n, int x, ArrayList<ArrayList<Integer>> cs) {
		this.n = n;
		g = new ArrayList[n+1];
		disc = new int[n];
		low = new int[n];
		time = 0;
		res = new ArrayList<>();
		Arrays.fill(disc, - 1);
		for (int i = 0; i <= n; i++) {
			g[i] = new ArrayList<>();
		}
		
		for (List<Integer> c : cs) {
			int fr = c.get(0);
			int to = c.get(1);
			System.out.println(fr + " -- " + to);
			System.out.println(g.toString());
			g[fr].add(to);
			g[to].add(fr);
		}
		
		for(List<Integer> c: cs) {
			
		}
		for (int i = 0; i < n; i++) {
			if (disc[i] == -1) dfs(i, i);
		}
		return res;
	}

	private void dfs(int u, int pre) {
		disc[u] = low[u] = ++time;
		System.out.println(disc[u]);
		
		for (int v : g[u]){
			if (v == pre) continue;  // do not forget;
			if (disc.length > g.length && disc[v] == -1) {
				dfs(v, u+1);
				if (low[v] > disc[u]) {
					res.add(Arrays.asList(u, v));
				}
			} 
			
			low[u] = Math.min(low[u], low[v]);
		}
	}
}
