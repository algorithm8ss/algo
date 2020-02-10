package com.ssafy;

import java.util.Scanner;
import java.util.Stack;

public class OXÄûÁî_8958_jaewon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {	
			int sum = 0;
			Stack<Integer> stack = new Stack<Integer>();
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j)=='O') {
					stack.push(1);
					sum+=stack.size();
				}else if(str.charAt(j)=='X') {
					stack.clear();
				}
			}
			System.out.println(sum);
		}
		
		
		
	}

}
