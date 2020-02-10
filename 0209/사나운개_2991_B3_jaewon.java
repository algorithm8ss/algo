package com.ssafy;

import java.util.Scanner;

public class 사나운개_2991_B3_jaewon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		int postman = sc.nextInt();
		int milk  = sc.nextInt();
		int news = sc.nextInt();
		
		int temp1 = a+b;
		int temp2 = c+d;
		
		sol(postman, temp1, temp2, a, c);
		sol(milk, temp1, temp2, a, c);
		sol(news, temp1, temp2, a, c);
		
	}
	
	public static void sol(int time, int temp1, int temp2, int a, int c) {
		int ans = 0;
		if(time%temp1<=a && time%temp1>0)
			ans++;
		if(time%temp2<=c && time%temp2>0)
			ans++;
		System.out.println(ans);
	}
}
