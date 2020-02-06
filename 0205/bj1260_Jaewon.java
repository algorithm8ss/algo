package backjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj1260_Jaewon {
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());			
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		for (int i = 0; i < N; i++) {
			graph.get(i).sort(null);			
		}
		visited = new boolean[N];
		dfs(V-1);
		System.out.println();
		visited = new boolean[N];
		bfs(V-1);
	}

	private static void bfs(int start) {		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			System.out.print((temp + 1)+" ");
			for (int i = 0; i < graph.get(temp).size(); i++) {
				int t = graph.get(temp).get(i); 
				if (!visited[t]) {
					queue.add(t);
					visited[t] = true;
				}
			}
		}
	}

	private static void dfs(int start) {
		visited[start] = true;
		System.out.print((start+1)+" ");
		for (int i = 0; i < graph.get(start).size(); i++) {
			int t = graph.get(start).get(i);
			if (!visited[t])
				dfs(t);
		}
	}
}
