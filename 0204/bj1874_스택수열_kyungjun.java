import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열 {
	private static int Ans[];
	private static Stack<Integer> stack = new Stack<Integer>();;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Ans = new int[n];
		for(int i = 0; i < n; i++) {
			Ans[i] = Integer.parseInt(br.readLine());
		}
		int check = 2;
		int checkans = 0;
		StringBuilder str = new StringBuilder();
		String str2 = new String();
		stack.push(1);
		str.append("+");
		while(true) {
			if(checkans < n) {
				if(!stack.isEmpty()) {
					if(stack.peek() == Ans[checkans]) {
						stack.pop();
						str.append("-");
						checkans++;
						continue;
					}
				}
			}else {
				break;
			}
			if(check <= n) {
				stack.push(check);
				check++;
				str.append("+");
			}else {
				str2 = "NO";
				break;
			}
		}	
		if(str2.equals("NO")) {
			System.out.println(str2);
		}else {
			for(int i = 0; i < str.length(); i++) {
				System.out.println(str.charAt(i));
			}
		}
	}
}
