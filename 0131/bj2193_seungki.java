package com.algo.self_main;

import java.util.Scanner;


public class bj2193_seungki {
	static int[] numbers;
	static int N,count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		// N(1 ≤ N ≤ 90)
		if (N >= 1 && N <= 90) {
			numbers = new int[N];
			//permutation(0);
			if(N==1 || N==2) {
				System.out.println("1");
			}else if(N==3){
				System.out.println("2");
			}else{
				addfunction(0);	
			}
			
		} else {
			System.out.println();
		}
		//System.out.println(count);

	}
	private static void addfunction(int index) {
		long[] num = new long[N];
		num[0]=1;
		num[1]=1;
		num[2]=2;
		num[3]=3;
		for(int i=2;i<N;i++) {
			num[i] = num[i-1]+num[i-2];
		}
		System.out.println(num[N-1]);
	}
}