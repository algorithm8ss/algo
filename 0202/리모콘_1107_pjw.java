package test;
import java.util.Scanner;
public class 리모콘_1107 {
	static int channel=100;
	static int[] broken = new int[10];
	static int[] numbers= new int[6];
	static int count=0,index=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int M = sc.nextInt();
		int min=1000000;
		int temp_abs=0;
		String temp;
		for(int i=0; i<M; i++) {
			broken[sc.nextInt()]++;
		}
		
//		for(int i=0; i<10; i++) {
//			broken[temp.charAt(i)-'0'];
//		}
		
		min = Math.abs(Integer.parseInt(N)-100);
//		System.out.println(min);
		//시작하자 마자 동일 채널일 때		
		if(channel == Integer.parseInt(N))
			System.out.println(count);

		// 채널 숫자로 이동  -> + or -로 이동
		// + or -로만 이동
		else {
			for(int i=0; i<1000000; i++)  {		
				temp=Integer.toString(i);
//				System.out.println("temp : " + temp);
				for(int j=0; j<temp.length(); j++) {
					
					if(broken[temp.charAt(j)-'0']!=0) {
//						System.out.println("broken 인덱스 : " + (broken[temp.charAt(j)-'0']));
						break;
					}
					if(j==(temp.length()-1)) {
						temp_abs=Math.abs(i-Integer.parseInt(N));
						min=Math.min(temp_abs+temp.length(),  min);
//						System.out.println("min : " + min);
					}
				}
			}
			System.out.println(min);
		}

	}

}
