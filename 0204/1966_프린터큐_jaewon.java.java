package com.bj2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Doc {
		int priority;
		boolean target;

		public Doc(int priority, boolean target) {
			// TODO Auto-generated constructor stub
			this.target = target;
			this.priority = priority;
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			Queue<Doc> queue = new LinkedList<Doc>();
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] check = new int[10];
			for (int i = 0; i < N; i++) {
				int temp = sc.nextInt();
				if (i == M) {
					check[temp]++;
					queue.offer(new Doc(temp, true));
				} else {
					check[temp]++;
					queue.offer(new Doc(temp, false));
				}
			}
			int max = 0;
			for (int i = 9; i >= 0; i--) {
				if (check[i] != 0) {
					max = i;
					break;
				}
			}
			int ans = 0;
			while (!queue.isEmpty()) {
				while (true) {
					if (check[max] == 0)
						max--;
					else
						break;
				}

				Doc temp = queue.poll();
				if (temp.priority == max) {
					check[temp.priority]--;
					ans++;
					if (temp.target) {
						System.out.println(ans);
						break;
					}
				} else
					queue.offer(temp);
			}
		}

	}

}
