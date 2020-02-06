package com.bj;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	final static String pop = "-\n";
	final static String push = "+\n";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N]; // �Է¹��� ������ �����ϴ� �迭
		for (int i = 0; i < N; i++) 
			arr[i] = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>(); // 1���� N������ ���� ó���� ����
		int max = 0; // ���ÿ� �� ���� �����ϱ� ���� ����
		StringBuilder sb = new StringBuilder();
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
