package com.algo.bj_0127;

import java.util.Scanner;

public class _bj13567_seungki {

	public static void main(String[] args) {
		int M = 0;
		int N = 0;
		int X = 0; // X��ǥ
		int Y = 0; // Y��ǥ
		int turn = 0;
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		int[][] rect = new int[M][M];
		String[] text_command = new String[N]; // ��ɾ�
		int[] num_command = new int[N];
		for (int i = 0; i < N; i++) {
			text_command[i] = sc.next();
			num_command[i] = sc.nextInt();
		}
		// TURN�� 1�϶� TURN�� 0�϶�
		// ������ : 0
		// �� : 1 or -3
		// ���� : 2 or -2
		// �Ʒ� : 3 or -1
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
						System.out.println("�̻��Ѽ���..");
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
