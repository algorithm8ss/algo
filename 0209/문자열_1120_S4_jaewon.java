package com.ssafy;

import java.util.Scanner;

public class ¹®ÀÚ¿­_1120_S4_jaewon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		System.out.println(cal(a,b));
	}
	
	public static int cal(String a, String b) {
		int min = Integer.MAX_VALUE; 
		for (int i = 0; i <= b.length()-a.length(); i++) {
			int count = 0;
			for (int k = 0; k < a.length(); k++) {
				if(a.charAt(k)!=b.charAt(i+k)) {
					count++;
				}
			}			
			if(count<min)
				min = count;			
		}
		return min;
	}
}
