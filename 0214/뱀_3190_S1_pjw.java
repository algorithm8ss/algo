package test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 뱀_3190_S1 {

	static class Snake {
		int x, y;

		public Snake(int x, int y) {
			// super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 보드 크기
		int K = sc.nextInt(); // 사과 개수
		int map[][] = new int[N + 2][N + 2];
		// int apple[][] = new int[N+1][N+1];

		for (int i = 0; i < N + 2; i++) {
			map[0][i] = 3;
			map[i][0] = 3;
			map[i][N + 1] = 3;
			map[N + 1][i] = 3;
		}

		for (int k = 0; k < K; k++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 2; // 사과
		}
		map[1][1] = 1;

		int now_dir = 1; // 초기 오른쪽 방향
		Deque<Snake> snake = new ArrayDeque<>();
		// Deque<Snake> snake = new ArrayDeque<>();
		snake.add(new Snake(1, 1));

		int dx[] = { -1, 0, 1, 0 }; // 북-동-남-서
		int dy[] = { 0, 1, 0, -1 };
		boolean check = false;
		int L = sc.nextInt(); // 방향 변환 횟수
		int time = 0;
		int index=0;
		int time_arr[] = new int[L+1];
		char dir_arr[] = new char[L];
		for (int l = 0; l < L; l++) {
			// 정수x, 문자c
			// x만큼 이동 후 왼쪽:L / 오른쪽:D
			time_arr[l] = sc.nextInt();
			dir_arr[l] = sc.next().charAt(0);
		}
		while (true) {
			if (check)
				break;

				Snake head = snake.peekLast();
				int nextx = head.x + dx[now_dir];
				int nexty = head.y + dy[now_dir];
				time++;
				// 벽만남
				if (map[nextx][nexty] == 3 || map[nextx][nexty] == 1) {
					check = true;
					break;
				}

				// 사과아닐때
				if (map[nextx][nexty] != 2) {
					Snake tail = snake.poll();
					map[tail.x][tail.y] = 0;
				}

				map[nextx][nexty] = 1;
				snake.addLast(new Snake(nextx, nexty));

//				for (int i = 0; i < N + 2; i++) {
//					for (int j = 0; j < N + 2; j++) {
//						System.out.print(map[i][j]);
//					}
//					System.out.println();
//				}
//				System.out.println();

				
			if(time==time_arr[index]) {
				if (dir_arr[index] == 'D') { // 오른
					now_dir = (now_dir + 1) % 4;
				} else if (dir_arr[index] == 'L') { // 왼
					if (now_dir == 0)
						now_dir = 3;
					else
						now_dir = (now_dir - 1) % 4;
				}
				index++;
			}
		}
		System.out.println(time);
	}

}
