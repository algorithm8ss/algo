package com.algo.self_main;

import java.util.Scanner;

public class bj1904_seungki {
	static int N;
	static long[] numbers = new long[10000000];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers[1] = 1;
		numbers[2] = 2;
		for(int i=3;i<=N;i++) {
			numbers[i]=(numbers[i-1]+numbers[i-2])%15746;
		}
		System.out.println(numbers[N]);
	}
}