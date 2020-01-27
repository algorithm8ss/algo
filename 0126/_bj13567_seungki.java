package com.algo.bj_0127;

import java.util.Scanner;

public class _bj13567_seungki {

	public static void main(String[] args) {
		int M = 0;
		int N = 0;
		int X = 0; // X좌표
		int Y = 0; // Y좌표
		int turn = 0;
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		int[][] rect = new int[M][M];
		String[] text_command = new String[N]; // 명령어
		int[] num_command = new int[N];
		for (int i = 0; i < N; i++) {
			text_command[i] = sc.next();
			num_command[i] = sc.nextInt();
		}
		// TURN이 1일때 TURN이 0일때
		// 오른쪽 : 0
		// 위 : 1 or -3
		// 왼쪽 : 2 or -2
		// 아래 : 3 or -1
		for (int i = 0; i < N; i++) {
			if (text_command[i].equals("TURN") && num_command[i] == 0) {
				turn += 1;
			} else if (text_command[i].equals("TURN") && num_command[i] == 1) {
				turn -= 1;
			} else {
				if (X > M || Y > M || X<0 || Y<0) {
					break;
				} else {
					if (turn % 4 == 1 || turn % 4 == -3) {
						for (int z = 0; z < num_command[i]; z++) {
							Y++;
						}
					} else if (turn % 4 == 2 || turn % 4 == -2) {
						for (int z = 0; z < num_command[i]; z++) {
							X--;
						}
					} else if (turn % 4 == 3 || turn % 4 == -1) {
						for (int z = 0; z < num_command[i]; z++) {
							Y--;
						}
					} else if (turn % 4 == 0) {
						for (int z = 0; z < num_command[i]; z++) {
							X++;
						}
					} else {
						System.out.println("이상한숫자..");
						break;
					}
				}
			}
		}
		if (X > M || Y > M || X<0 || Y<0) {
			System.out.println("-1");
		}else {
			System.out.println(X + " " + Y);
		}
		
	}
}
