package test;
import java.util.Scanner;
public class 색종이_2567_S5 {
/*
 * 메모리 : 14524kb
 * 시간 : 120ms
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count=0;
		int arr[][] = new int[102][102];
		for(int i=0; i<N; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			
			for(int j=0; j<10; j++) {
				for(int k=0; k<10; k++) {
					
					arr[x+j][y+k]=1;
				}
			}
			
		}		

		// 배열 값이 1인  곳을 만나면 상하좌우 값이 0인 곳이 변이므로 그 갯수를 센다.
		for(int j=0; j<=101; j++) {
			for(int k=0; k<=101; k++) {
				if(arr[j][k]==1 ) {
					if(arr[j+1][k]==0) {
						count++;
					}
					if(arr[j-1][k]==0)
						count++;
					if(arr[j][k+1]==0)
						count++;
					if(arr[j][k-1]==0)
						count++;
				}
			}
		}
		System.out.println(count);
	}

}