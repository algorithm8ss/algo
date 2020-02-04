package com.algo.self_200205;

import java.util.Scanner;
import java.util.Stack;

public class bj1874_seungki {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] num = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			num[i] = sc.nextInt();
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		char[] store = new char[1000000];
		int storecount=0;
		int i=1;
		int count=1;
		int temp=0;
		boolean selected = true;
		L:while(true) {
			if(i==N+1) {
				break;
				
			}
		//	System.out.println(stack);
			if(num[i]==count) {
				stack.push(count);
				store[storecount++]='+';
				count++;
				//System.out.println("pop "+stack);
				stack.pop();
				store[storecount++]='-';
				i++;
			}else if(num[i]>count){
				stack.push(count);
				store[storecount++]='+';
				count++;
			}else if(num[i]<count) {
				temp=stack.pop();
				if(temp>num[i]) {
					System.out.println("NO");
					selected=false;
					break L;
				}else {
					store[storecount++]='-';
					i++;
				}	
			}
		}	
		if(selected) {
			for(int z=0;z<storecount;z++) {
				System.out.println(store[z]);
			}
		}
	}
}
