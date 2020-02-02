package test;
import java.util.Scanner;
public class 퇴사_14501 {
	static int N;
	static int T[];
	static int P[];
	static int dp[];
	static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
	//	int arr[][] = new int[N][2];
		
		T= new int[N+2];
		P= new int[N+2];
		dp = new int[N+2];
		
//		int max=0,day;
		for(int i=0; i<N; i++) {

			T[i] = sc.nextInt();	//날짜
//			System.out.println(T[i]);
			P[i] = sc.nextInt();	//포인트
//			System.out.println(P[i]);
			//dp[i] = P[i];
		}
		
//		for(int i=2; i<=N; i++) {
//			for(int j=1; j<i; j++ ) {
//				if(i-j >= T[j])
//				dp[i] = Math.max(P[i]+dp[j],dp[i]);
//			}
//		}
// 		
		dfs(0,0);
		System.out.println(result);
	}
	public static void dfs(int day, int money) {
		if(day>=N)  {
			result = Math.max(result,  money);
			return;
		}
		
		dfs(day+1, money);
		if(T[day]+day <=N )
			dfs(day + T[day], money + P[day]);
	}

}
