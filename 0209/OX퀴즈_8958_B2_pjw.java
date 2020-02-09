package test;
import java.util.Scanner;
public class OX퀴즈_8958_B2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0; i<N;i++) {
			int count=0,sum=0;
			String str = sc.next();
			int len = str.length();
			for(int j=0; j<len; j++) {
				if(str.charAt(j)=='O') {
					count++;
					sum+=count;
				}
				else
					count=0;
			}
			System.out.println(sum);
		}
	}

}
