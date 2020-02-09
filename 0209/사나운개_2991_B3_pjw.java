package test;
import java.util.Scanner;
public class 사나운개_2991_B3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A= sc.nextInt();
		int B= sc.nextInt();
		int C= sc.nextInt();
		int D= sc.nextInt();
//		int P=sc.nextInt();
//		int M =  sc.nextInt();
//		int N = sc.nextInt();
		
		for(int i=0; i<3; i++) {
			int input=sc.nextInt();
			int count=0;
			if(input%(A+B)<=A && input%(A+B)>0) 
				count++;			
			if(input%(C+D)<=C && input%(C+D)>0) {
				count++;		
			}
			System.out.println(count);
		}
			
	}
}


