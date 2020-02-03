package com.algo.self_main;

import java.util.Scanner;

public class bj13458_seungki {
	static long count = 0;
	static boolean select = true;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int roomsize = sc.nextInt();
		int[] room = new int[roomsize + 1];
		for (int i = 1; i <= roomsize; i++) {
			room[i] = sc.nextInt();
		}
		int main = sc.nextInt();
		int sub = sc.nextInt();
		for (int i = 1; i <= roomsize; i++) {
			room[i] -= main;
			count++;
		}
		for (int i = 1; i <= roomsize; i++) {
			// System.out.println("count " + count);
			if(room[i]>0){
            if (room[i] % sub == 0) {
				count += room[i] / sub;
			}         
            else {
				count += (room[i] / sub) + 1;
			}
                }
		}
		System.out.println(count);

	}
}