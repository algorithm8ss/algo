package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399_S3_jwbae {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i <N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			sum+=(N-i)*arr[i];
		}
		System.out.println(sum);
	}
}
