package test;
import java.util.Scanner;
public class 롤케이크_3985_S5 {
/*
 * 메모리 : 17940kb
 * 시간 : 164ms
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); // 케이크 길이
		int N = sc.nextInt(); // 방청객 수
		int arr[] = new int[L+1];
		int maybe_max=0, max=0, maybe_max_index=0,count=0, max_index=0;
		for(int i=1; i<=N; i++) {
			int P = sc.nextInt();
			int K = sc.nextInt();
			// P~K까지
//			System.out.println(P-K);
			count=0;
			if(maybe_max<(K-P)) {
				maybe_max=K-P;
//				System.out.println(maybe_max);
				maybe_max_index=i;
			}
			
			for(int j=P; j<=K; j++) {
				if(arr[j]==0) {
					arr[j]=1;
					count++;
				}				
			}
			
			if(max<count) {
				max=count;
				max_index=i;
			}
				
			
		}
		System.out.println(maybe_max_index);
		System.out.println(max_index);
	}

}
