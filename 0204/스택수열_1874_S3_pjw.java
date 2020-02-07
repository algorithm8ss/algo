package backjun;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class 스택수열_1874_S3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		
		int n = sc.nextInt();
		int num=0;
		int arr[] = new int[n+1];
		char arr_out[] = new char[3*n];
		for(int i=1; i<=n; i++) {
			arr[i]=sc.nextInt();
		}
		int index=1,index_arr=1, out_arr=1;
	//	for(int i=1; i<=n; i++) {
			while(index<=n) {
				// 넣으려는 숫자가 뽑아야하는 숫자가 같을 때
//				if(arr[index] == index ) {
//					System.out.println("+");
//					System.out.println("-");
//					index++;
//					break;
//					//continue;
//				}
				//스택의 맨위자리 값이 뽑아야하는 숫자와 같을 때  
				if(!stack.isEmpty()){
//					System.out.println("탑 : " + stack.peek() + "    " + arr[index_arr]);
					if(stack.peek() == arr[index_arr]) {
//						System.out.println("탑 : " + stack.peek() + "    " + arr[index_arr] + "팝");
						stack.pop();
						index_arr++;
						arr_out[out_arr]='-';
						out_arr++;
						//System.out.println("-");
						
						//break;
					}
					else {
						stack.push(index);	
//						System.out.println(index + "푸시");
						index++;
						arr_out[out_arr]='+';
						out_arr++;
						//System.out.println("+");
					}
				}
				else {
					stack.push(index);
//					System.out.println(index + "푸시2");
					index++;
					arr_out[out_arr]='+';
					out_arr++;
					//System.out.println("+");
				}
			}
		//}
		while(!stack.isEmpty()) {
			if(stack.peek() == arr[index_arr]) {
				stack.pop();
				index_arr++;
				arr_out[out_arr]='-';
				out_arr++;
				//System.out.println("-");
			}
			else {
				System.out.println("NO");
				break;
			}
		}
		if(stack.isEmpty()) {
		//	System.out.println(Arrays.toString(arr_out));
			for(int i=1; i<out_arr; i++) {
				System.out.println(arr_out[i]);
			}
		}
	}

}
