import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);		
		int L = sc.nextInt();
		int[] cake = new int[L];
		int N = sc.nextInt();
		int[] expect = new int[N];
		int max = 0;
		int winner = 1;
		int e = 1;
		int cal = 0;
		int[] p = new int[N];
		int[] k = new int[N];
		for (int i = 0; i < expect.length; i++) {
			int pi = sc.nextInt();
			p[i] = pi-1;
			int ki = sc.nextInt();
			k[i] = ki-1;
			if(ki-pi>cal) {
				cal = ki-pi;
				e = i+1;
			}
				
		}
		
		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = p[i]; j <= k[i]; j++) {				
				if(cake[j]==0) {
					count++;
					cake[j] = i+1;
				}
			}
			if(count>max) {
				max = count;
				winner = i+1;
			}				
		}
		System.out.println(e);
		System.out.println(winner);
	}

}