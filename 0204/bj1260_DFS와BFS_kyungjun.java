import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS¿ÍBFS {
	
	private static int arr[], node, edge, start;
	private static ArrayList<Integer>[] graph;
	private static boolean visited[], visitedDfs[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		graph = new ArrayList[node+1];
		for(int i = 0; i < node+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		arr = new int[2];
		visited = new boolean[node+1];
		visitedDfs = new boolean[node+1];
		for(int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			graph[arr[0]].add(arr[1]);
			graph[arr[1]].add(arr[0]);
		}
		for(int i = 1; i <= node; i++) {
			Collections.sort(graph[i]);
		}
		System.out.print(start + " ");
		DFS(start);
		System.out.println();
		BFS(start);
	}
	private static void DFS(int start) {
		visitedDfs[start] = true;
		for(int i:graph[start]) {
			if(!visitedDfs[i]) {
				visitedDfs[i] = true;
				System.out.print(i + " ");
				DFS(i);
				visitedDfs[i] = true;
			}
		}
	}
	private static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.offer(start);
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			System.out.print(temp + " ");
			for(int i:graph[temp]){
				if(!visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
