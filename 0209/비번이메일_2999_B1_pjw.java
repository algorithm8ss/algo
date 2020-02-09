package test;
import java.util.Scanner;
public class 비번이메일_2999_B1 {
	static int R=0,C=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);		
		String str;
		str = sc.next();
		int N = str.length();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++)	
				if(i*j==N && i<=j) {
					R=i;
					C=j;
				}
		}
		

		int index=0;
		char arr[][] = new char[101][101];
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				arr[j][i] = str.charAt(index++);
		//		System.out.print(arr[j][i]);
			}
			//System.out.println();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(arr[i][j]);
				//System.out.print(arr[i][j]);
			}			
			//System.out.println();
		}
		
		
	}
	
}