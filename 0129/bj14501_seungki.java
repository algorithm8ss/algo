package com.algo.self_main;
import java.util.Scanner;

public class bj14501_seungki {
	static int N;
	static int[] term;
	static int[] pay;
	static int money=0;
	static int maxmoney=0;
	

	public static void main(String[] args) {
		boolean selected=true;
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		if(N<1 && N>15) {
			selected=false;
		}
		term = new int[N];
		pay = new int[N];
		
		for(int i=0;i<N;i++) {
			term[i] = sc.nextInt(); 
			pay[i] = sc.nextInt();
			if(term[i]<1 || term[i]>16 || pay[i]<1 || pay[i]>1000) {
				selected=false;
			}
		}
		if(selected) {
			permutation(0);
			System.out.println(maxmoney);
		}else {
			System.out.println();
		}
		
	}
	private static void permutation(int index) {
		Scanner sc = new Scanner(System.in);
		if (index == N) { 
			if(maxmoney<money) {
				maxmoney=money;
			}
			//System.out.println("Money"+money);
			return;
		}else if(index > N){
			return;
		}
		money+=pay[index];
		permutation(index + term[index]);
		money-=pay[index];
		permutation(index+1);
	}
}