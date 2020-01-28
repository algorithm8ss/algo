import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();		

		for(int test_case = 1; test_case <= t; test_case++)
		{

			int n = sc.nextInt();
			int[] numbers = new int[n];
			long sum = 0;
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = sc.nextInt();
			}
			
			
			for (int i = 0; i < numbers.length-1; i++) {
				for (int j = i+1; j < numbers.length; j++) {
					sum +=gcd(numbers[i],numbers[j]);
				}
			}
			
			System.out.println(sum);
		}
	}

	private static int gcd(int a, int b) {
		if(b==0) {
			return a;
		}else {
			return gcd(b,a%b);
		}
		
	}
}