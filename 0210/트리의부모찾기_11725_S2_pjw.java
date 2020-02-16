package test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class 트리의부모찾기_11725_S2 {
	static int N;
	static int parent[];
	static List<Integer>[] list;
	static boolean visited[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		
		list = new ArrayList[N+1];
		parent = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++)
			list[i]=new ArrayList<>();
		
		for(int  i=1; i<N; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			list[x].add(y);
			list[y].add(x);
		}
		dfs(1);
		for(int i=2; i<=N; i++)
			System.out.println(parent[i]);
		
	}
	
	private static void dfs(int index) {
		visited[index] = true;
		
		for(int i : list[index]) {
			if(!visited[i]) {
				parent[i] =  index;
				dfs(i);
			}
		}
	}

}
