package test;
import java.util.Scanner;
public class 이천수_2193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long dp[] = new long[N+1];
		dp[0] = 0;
		dp[1] = 1;
		//dp[2] = 1;
		
		if(N==1)
			System.out.println(dp[1]);
		else {
			for(int i=2; i<=N; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
			System.out.println(dp[N]);
		}
	}

}