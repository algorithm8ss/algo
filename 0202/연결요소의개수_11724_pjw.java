package test;
import java.util.Scanner;
import java.util.ArrayList;
public class 연결요소의개수_11724_2 {
	static ArrayList<Integer>[] arr;
	static boolean check[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int M = sc.nextInt();
		arr = new ArrayList[N+1];
		check = new boolean[N+1];
		int count=0;
		for(int i=1; i<=N; i++) 
			arr[i]=new ArrayList<>();
		int u,v;
		for(int i=1; i<=M; i++) {
			u=sc.nextInt();
			v=sc.nextInt();
			
			arr[u].add(v);
			arr[v].add(u);
		}
		
		for(int i=1; i<=N; i++) {
			if(check[i])
				continue;
			dfs(i);
			count++;
		}
		System.out.println(count);
		
	}

	public static void dfs(int num) {
		check[num]=true;
		for(int i=0; i<arr[num].size(); i++) {
			int  temp=arr[num].get(i);
			if(check[temp])
				continue;
			dfs(temp);
		}
	}
}
