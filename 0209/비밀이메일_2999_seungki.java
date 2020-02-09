import java.util.Scanner;

public class 비밀이메일_2999_seungki{
	static int R=0,C=0,N=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		String text;
		text= sc.next();
		N=text.length();
		//System.out.println(text.length());
		//암호문을 만드는 과정
		int[] tep = new int[N];
		for(int i=1;i<=N;i++) {
			if(N%i==0)
			tep[i-1]=N/i;
		}
		for(int i=1;i<=N;i++) {
			if(tep[i-1]<=i) {
				if(R<tep[i-1])
				R=tep[i-1];
			}
		}
		C=N/R;
	//	System.out.println(R);
	//	System.out.println(C);
		char[][] map = new char[R][C];
		int sample=0;
		for(int j=0;j<C;j++) {
			for(int i=0;i<R;i++) {			
				map[i][j]=text.charAt(sample);
				sample++;
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(map[i][j]);
			}
			//System.out.println();
		}
//		for(int j=0;j<C;j++) {
//			for(int i=0;i<R;i++) {
//				System.out.print(map[i][j]);
//			}
//		}
//		System.out.println();
//		char[][] temp = new char[R][C]; //3 5
//		for(int j=0;j<C;j++) {
//			for(int i=0;i<R;i++) {
//				temp[i][j] = map[i][j];
//			}
//		}
//		for(int i=0;i<R;i++) {
//			for(int j=0;j<C;j++) {
//				System.out.print(temp[i][j]);
//			}
//		}
//		
		
		

	}

}