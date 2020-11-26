/**
 * 
 */
package com.amazon;

import java.util.*;

/**
 * @author Sachin Garg
 *
 */
public class AmazonTest12020 {

	/**
	 * @param args
	 */
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

		System.out.println(criticalRouters(7, 7,links));
	}

	static List<List<Integer>> criticalRouters(int numRouters, int numLinks, ArrayList<ArrayList<Integer>> links){
		System.out.println(links);
		int n = numLinks;
		for(ArrayList<Integer> link: links){
			System.out.println(link);
		}

		List<List<Integer>> ans = new ArrayList<>();
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (List<Integer> con : links)
		{
			graph.putIfAbsent(con.get(0), new ArrayList<Integer>());
			graph.putIfAbsent(con.get(1), new ArrayList<Integer>());
			graph.get(con.get(0)).add(con.get(1));
			graph.get(con.get(1)).add(con.get(0));
		}

		System.out.println(graph);
		boolean[] visited = new boolean[n+1];
		int[] parent = new int[n+1];

		for (int i = 0; i < n; i++)
			parent[i] = -1;

		int[] low = new int[n+1];
		int[] disc = new int[n+1];
		Integer time = 0;

		for (Integer u : graph.keySet())
		{
			if (!visited[u])
				dfs(graph, u, parent, low, disc, visited, time, ans);
		}

		return ans;
	}

	private static void dfs(Map<Integer, List<Integer>> graph, int u, int[] parent, int[] low, int[] disc, boolean[] visited, Integer time, List<List<Integer>> ans) {
		visited[u] = true;
		low[u] = time + 1;
		disc[u] = time + 1;
		time++;

		for (Integer v : graph.getOrDefault(u, new ArrayList<Integer>()))
		{
			System.out.println(v);
			if (!visited[v])
			{
				System.out.println("u:" + u);
				parent[v] = u;
				dfs(graph, v, parent, low, disc, visited, time, ans);

				low[u] = Math.min(low[u], low[v]);

				if (low[v] > disc[u])
				{
					List<Integer> list = new ArrayList<>();
					list.add(u <= v ? u : v);
					list.add(u <= v ? v : u);
					ans.add(list);
				}
			}
			else if (v != parent[u])
				low[u] = Math.min(low[u], disc[v]);
		}
	}
}
