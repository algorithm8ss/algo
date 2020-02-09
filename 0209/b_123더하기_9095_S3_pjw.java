package test;
import java.util.Scanner;
public class b_123더하기_9095_S3 {
/*
 * 메모리 : 14256 kb
 * 시간 : 112ms
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int j=0; j<T; j++) {
			int n= sc.nextInt();
			int dp[] = new int[11];

			dp[0]=0;
			dp[1]=1;
			dp[2]=2;
			dp[3]=4;
			// i번째 값은 [i-1]+[i-2]+[i-3] 으로 계산한다.
			for(int i=4;i<=n; i++) {
				dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
			}
			System.out.println(dp[n]);
		}
		
	}

}
