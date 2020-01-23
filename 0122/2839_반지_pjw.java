package study;
import java.util.Scanner;

public class 반지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String find_str =sc.next();
		int find_length= find_str.length();
		int N = sc.nextInt();
		String temp_str;
		char[] arr = new char[11];
		char[] search_arr = new char[11];
		
		for(int i=0; i<find_length; i++) {
			search_arr[i] = find_str.charAt(i);
		}
		
		int count=0;
		for(int p=0; p<N; p++ ) {
			temp_str = sc.next();
			for(int i=0; i<10; i++) {				
				arr[i] = temp_str.charAt(i);
			}
			int index=1, str_index;
			int count_len;
			
			for(int i=0; i<10; i++) {
				if(search_arr[0] == arr[i]) {
					index =1;
					str_index=i+1;
					count_len=1;
					for(int j=0; j<find_length; j++) {
						
						if(search_arr[index] == arr[str_index%10]) {
							count_len++;
							index++;
							str_index++;
						}
					}
					if(count_len == find_length) {
						count++;
						break;
					}				
				}				
			}
		}		
		System.out.println(count);
	}
}
