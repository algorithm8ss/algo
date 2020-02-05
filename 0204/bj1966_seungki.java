package com.algo.self_main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj1966_seungki {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n, m, count;
		for (int i = 0; i < t; i++) {
			Queue<int[]> queue = new LinkedList<int[]>();
			count = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			for (int j = 0; j < n; j++) {
				queue.offer(new int[] { j, sc.nextInt() });
			}
			while (!queue.isEmpty()) {
				int[] temp = queue.poll();
				boolean visited = true;
				for (int[] q : queue)
					if (q[1] > temp[1])
						visited = false;
				if (visited) {
					count++;
					if (temp[0] == m)
						break;
				} else
					queue.offer(temp);

			}
			System.out.println(count);
		}
	}

}