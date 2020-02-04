package backjun;
import java.util.Scanner;
public class 시험감독_13458_B2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int stu[] =new int[N+1];
		
		
		for(int i=0; i<N; i++) {
			stu[i] = sc.nextInt();
			
			
		}
		int B = sc.nextInt();
		int C = sc.nextInt();
		int temp;
		long count=0;
		for(int i=0; i<N; i++) {
			if(stu[i]-B<=0) {
				count++;
			}
			else {
				temp = stu[i]-B;
				count++;
	//			System.out.println("temp : "  + temp);
				if(temp%C==0) {
					count+= temp/C;
				}
				else {
					count+= temp/C;
					count++;
				}
			
			}
			
		}
		System.out.println(count);
	}

}
