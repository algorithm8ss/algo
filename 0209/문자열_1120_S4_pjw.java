package test;
import java.util.Scanner;
public class 문자열_1120_S4 {
/*
 * 메모리 : 14180kb
 * 시간 : 104ms
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
//		System.out.println(str1);
//		System.out.println(str2);
		
		int len1= str1.length();
		int len2= str2.length();
		
		int count=0,min=50;;
		int sub= len2-len1;
		// 맨처음 인덱스 부터 두 str의 차이만큼 비교하면서 다른 글자수를 센다.
		for(int i=0; i<=len2-len1; i++) {
			count=0;
			for(int j=0; j<len1; j++) {
				if(str1.charAt(j) != str2.charAt(i+j)) {
					count++;
				}
			}
			if(min>count)
				min=count;
		}
		System.out.println(min);
	}

}
