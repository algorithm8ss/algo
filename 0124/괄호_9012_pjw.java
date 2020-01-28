package test;
import java.util.Scanner;
//import java.util.Queue;
import java.util.Stack;
public class °ýÈ£ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Stack<String> stack = new Stack<String>();
		int N= sc.nextInt();
		String str;
		String[] arr = new String[50];
		boolean check = true;
		
		for(int i=0; i<N ; i++) {
			str = sc.next();
			check=true;
			stack.clear();

			
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j)=='(') { 
					stack.push(arr[j]);
				}
				else if(str.charAt(j)==')') {
					if(stack.isEmpty()) {
						check=false;
						break;
					}
					else 
						stack.pop();
				}
			
			}
			if(check && stack.isEmpty()) 
				System.out.println("YES");
			else
				System.out.println("NO");
		}		
	}
}
