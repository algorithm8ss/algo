package com.algo.self_main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj1260_seungki {

	private static int[][] map;
	private static int N,M,start;
	private static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		start = sc.nextInt();

		map = new int[N + 1][N + 1];
		visited=new boolean[N+1];
		for (int i = 1; i <= M; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			map[num1][num2] = 1;
			map[num2][num1] = 1;
			
			
		}

//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		dfs(start);
		System.out.println();
		bfs(start);
		sc.close();
	}
	private static void dfs(int current) {
		
		visited[current] = true;
		System.out.print(current + " ");
		for (int j = 1; j <= N; j++) {
			if(map[current][j]>0 && !visited[j]) {
				dfs(j);
			}
		}
	}
	
	private static void bfs(int current) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] selected = new boolean[N+1];
		
		selected[current] = true;
		queue.offer(current);
		
		int temp;
		while(!queue.isEmpty()) {
			temp = queue.poll();
			System.out.print(temp + " ");
			
			for (int j = 1; j <= N; j++) {
				if(map[temp][j]>0 && !selected[j]) {
					selected[j] = true;
					queue.offer(j);
				}
			}
		}
	}	
}
