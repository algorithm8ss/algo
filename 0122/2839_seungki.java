import java.util.Scanner;

public class 2839_seungki{

	public static void main(String[] args) {
		int value=0;
		Scanner sc = new Scanner(System.in);
		
		int data = sc.nextInt(); //지정한 값
		if(data==0) {
			value=-1;
		}
		while(data!=0) {
			if(data%5==0) {
				value=data/5;
				data=0;
			}else if(data<10 && data%3==0) {
				value=value+(data/3);
				data=0;
			}else if(data<10 && data%8==0) {
				value=value+2;
				data=0;
			}else if(data%5==1) {
				if(data>10 && data==11) {
					value+=3;
					data=0;
				}else {
					data=data-5;
					value+=1;
				}
			}else if(data>10 && data%5==2) {
				if(data==17) {
					value+=5;
					data=0;
				}else if(data==12) {
					data=0;
					value+=4;
				}else {
					data=data-5;
					value+=1;
				}
			}else if(data<10 && (data%3!=0 || data%5!=0 || data%8!=0)) {
				value=-1;
				data=0;
			}else {
				data=data-5;
				value=value+1;
			}
		}
		
		System.out.println(value); 

	}


}
