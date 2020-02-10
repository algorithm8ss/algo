package com.ssafy;

import java.util.Scanner;

public class 비밀이메일_2999_jaewon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = s.length();
		int r = 0;
		int c = 0;
		for (int i = 1; i <= (int) Math.sqrt(n); i++) {
			if(n%i==0) {
				r = i;
			}
		}
		c = n/r;
		char[][] arr = new char[r][c];
		int idx = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				arr[j][i] = s.charAt(idx);
				idx++;		
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sb.append(arr[i][j]);
			}
		}
				
		System.out.println(sb);
	}

}
