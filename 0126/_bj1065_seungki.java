package com.algo.bj_0127;

import java.util.Scanner;

public class _bj1065_seungki {

	public static void main(String[] args) {
		int num=0;
		int[] edit = new int[3];
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N>=1 && N<=1000) {
			if(N<=99) {
				for(int i=1;i<=N;i++) {
					num++;
				}
				System.out.println(num);
			}else if(N>=100){
				num=99;
				for(int i=100;i<=N;i++) {
					edit[0]=i%10;
					edit[1]=(i/10)%10;
					edit[2]=(i/10)/10;
					if(edit[1]-edit[0]==edit[2]-edit[1]) {
						num++;
					}else {
						continue;
					}
				}
				System.out.println(num);
			}
		}else {
			System.out.println();
		}
	}
}