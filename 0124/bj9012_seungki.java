package com.algo.self_main;

import java.util.Scanner;

public class bj9012_seungki {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] array_word = null;
		boolean selected = true;
		N = sc.nextInt();
		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = sc.next();
		}
		for (int z = 0; z < N; z++) {
			int x = 0;
			int y = 0;
			if(str[z].length()>=2 && str[z].length()<=50) {
				array_word = str[z].split("");
				for (int i = 0; i < array_word.length; i++) {
					if (array_word[i].equals("(")) {
						x++;
					} else if (array_word[i].equals(")")) {
						y++;
					}
					if(x<y) {
						System.out.println("NO");
						selected = false;
						break;
					}
					
				}
				if(x==y) {
					System.out.println("YES");
				}else {
					if(selected) {
						System.out.println("NO");
					}
					selected=true;
				}
			}else {
				System.out.println("NO");
			}
			
		}

	}
}