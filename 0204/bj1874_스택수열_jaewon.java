package com.bj;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	final static String pop = "-\n";
	final static String push = "+\n";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) 
			arr[i] = sc.nextInt();
		
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int max = 0;
		
		for (int j = 0; j < N; j++) {
			if (arr[j] > max) 
				for (int i = max; i < arr[j]; i++) {
					stack.push(i + 1);
					sb.append(push);
				}
			else
				if (stack.peek() != arr[j]) { System.out.print("NO"); return; }
            stack.pop();
			sb.append(pop);
			if (arr[j] > max) max = arr[j];
		}

		System.out.println(sb);
		
		
	}
}
