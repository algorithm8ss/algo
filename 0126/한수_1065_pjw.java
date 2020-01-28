package test;
import java.util.Scanner;
public class 한수_1065 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count=0,first,second, third, d;
		if(N>0 & N<100) {
			count+=N;
		}
		else {
			count+=99;
			for(int i =N; N>100; N--) {
				i = N;
//				System.out.println("N : " + N);
//				System.out.println("i : " + i);
				if(N>=100 & N<1000) {
					first = N/100;
					second = (N/10)%10;
					third = N%10;
					d = first - second;			
					
					if(d == (second - third)) 
						count++;
//					System.out.println("count : " + count);
				}
			}
		}
		
		System.out.println(count);
	}

}
