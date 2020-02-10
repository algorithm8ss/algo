package com.algo.self_200211;

import java.util.Scanner;


public class bj2991_seungki {

	public static void main(String[] args) {
		int a1 = 0;
		int b1 = 0;
		int a2 = 0;
		int b2 = 0;
		Scanner sc = new Scanner(System.in);
		int Astart = sc.nextInt();
		int Aend = sc.nextInt();
		int Bstart = sc.nextInt();
		int Bend = sc.nextInt();
		int P = sc.nextInt();
		int M = sc.nextInt();
		int N = sc.nextInt();

		int Pfinish = 0;
		int Mfinish = 0;
		int Nfinish = 0;
		int Pattack = 0;
		int Mattack = 0;
		int Nattack = 0;

		b1 = 0;
		b2 = Bstart;
		a1 = 0;
		a2 = Astart;
		int i = 1;
		while (true) {

			if (P >= a1 && P <= a2 && Pfinish<2) {
				Pfinish++;
				if (i % 2 == 1) {
					Pattack++;
				}

			} 
			if (M >= a1 && M <= a2 && Mfinish<2) {
				Mfinish++;
				if (i % 2 == 1) {
					Mattack++;
				}

			} 
			if (N >= a1 && N <= a2 && Nfinish<2) {
				Nfinish++;
				if (i % 2 == 1) {
					Nattack++;
				}

			}
			if (P >= b1 && P <= b2 && Pfinish<2) {
				Pfinish++;
				if (i % 2 == 1) {
					Pattack++;
				}

			} 
			if (M >= b1 && M <= b2 && Mfinish<2) {
				Mfinish++;
				if (i % 2 == 1) {
					Mattack++;
				}

			} 
			if (N >= b1 && N <= b2 && Nfinish<2) {
				Nfinish++;
				if (i % 2 == 1) {
					Nattack++;
				}

			} 
			if (i % 2 == 1) {
				a1 = a2;
				a2 = a1 + Aend;
				b1 = b2;
				b2 = b1 + Bend;
			} else {
				a1 = a2;
				a2 = a1 + Astart;
				b1 = b2;
				b2 = b1 + Bstart;
			}
			
			
			i++;
			if(Nfinish==2 && Mfinish==2 && Pfinish==2) {
				System.out.println(Pattack);
				System.out.println(Mattack);
				System.out.println(Nattack);
				break;
			}
		}

	}
}
