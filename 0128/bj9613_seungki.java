package com.algo.self_main;

import java.util.Scanner;

public class Main {
	private static int[][] num = new int[100][100];
	private static long[] result = new long[100];
	private static int[] select2 = new int[100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int select1;
		int value=0;
		int max=0;
		
		select1=sc.nextInt();
		
		for (int i = 0; i < select1; i++) {
			select2[i]=sc.nextInt();
			for (int j = 0; j < select2[i]; j++) {
				num[i][j]=sc.nextInt();
			}
		}
		for (int i = 0; i < select1; i++) {
			for (int j = 0; j < select2[i]-1; j++) {
				for (int k = j+1; k < select2[i]; k++) {
					result[i] += GCD(num[i][j], num[i][k]);
				}
			}
			System.out.println(result[i]);
		}
	}
	private static int GCD(int a,int b) {
		if(b==0) return a;
		return GCD(b,a%b);
	}
}