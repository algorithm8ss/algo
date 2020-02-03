import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class binary {
	static char[] binarychar;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		long[][] str = new long[n+1][2];
//		binarychar = new char[n];
		
//		binarychar[0] = '1';
//		binarychar[1] = '0';
		 
		str[1][0]= 0;
		str[1][1]= 1;
		
//		ichinsu(binarychar, 2);
		
		for(int i = 2; i <= n; i++) {
			str[i][1] = str[i-1][0] ;
			str[i][0] = str[i-1][0] + str[i-1][1];
		}
		
		System.out.println(str[n][0] + str[n][1]);
	}
//	static void ichinsu(char[] cr, int index) {
//		if(index == n) {
//			count++;
//			System.out.println(Arrays.toString(str));
//			return;
//		}
//		
//		if(str[index-1] == '1') {
//			str[index] = 48;
//			ichinsu(binarychar, index+1);
//		}else {
//			for(int i = 0; i < 2; i++) {
//				str[index] = (char)(i+48);
//				ichinsu(binarychar, index+1);
//			}
//		}
//	}

}
