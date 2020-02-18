import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 금고열기 {
	private static int n, arr[];
	private static char oper[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());

		n = 4;
		arr = new int[n];
		ans = new char[3];
		oper = new char[] {'+', '-', '*', '/'};
		for(int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 4; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			do {
				operation(ans, 0);

//				if(check) {
//					System.out.println(Arrays.toString(arr));
//				}
				if(check) break;
			}while(np(arr));
			
			if(!check) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
			
			check = false;
		}
		
	}
	private static boolean np(int[] arr) {
		int i = n-1;
		while(i > 0 && arr[i-1] >= arr[i] ) --i;
		
		if(i == 0) return false;
		
		int j = n-1;
		while(arr[i-1] >= arr[j]) --j;
		
		int temp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = temp;
		
		j = n-1;
		while(i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return true;
	}
	private static char[] ans;
	private static double answer, answer2;
	private static boolean check;
	private static void operation(char[] carr, int depth) {
		if(check) return;
		
		if(depth == 3) {
			answer = arr[0];
			for(int i = 0; i < 3; i++) {	// 1 2 3
				switch(carr[i]) {
				case '+':
					answer += arr[i+1];
					break;
				case '-':
					answer -= arr[i+1];
					break;
				case '*':
					answer *= arr[i+1];
					break;
				case '/': 
					answer /= (double)arr[i+1];
					break;
				}
			}

			if(answer == 24) {
//				System.out.println(Arrays.toString(ans));
				check = true;
				return;
			}
			answer = 0;
			answer2 = 0;
			
			answer = arr[0];
			switch(carr[0]) {
			case '+':
				answer += arr[1];
				break;
			case '-':
				answer -= arr[1];
				break;
			case '*':
				answer *= arr[1];
				break;
			case '/': 
				answer /= (double)arr[1];
				break;
			}	
			switch(carr[2]) {		//1 3 2
			case '+':	
				answer2 = arr[2] + arr[3];
				break;
			case '-':
				answer2 = arr[2] - arr[3];
				break;
			case '*':
				answer2 = arr[2] * arr[3];
				break;
			case '/': 
				answer2 = (double)(arr[2] / arr[3]);
				break;
			}
			switch(carr[1]) {
			case '+':
				answer += answer2;
				break;
			case '-':
				answer -= answer2;
				break;
			case '*':
				answer *= answer2;
				break;
			case '/': 
				if(answer2 == 0) return;
				answer /= (double)answer2;
				break;
			}
			if(answer == 24) {
//				System.out.println(Arrays.toString(ans));
				check = true;
				return;
			}
			answer = 0;
			answer2 = 0;
			
			answer = arr[1];
			switch(carr[1]) {		//2 1 3
			case '+':	
				answer += arr[2];
				break;
			case '-':
				answer -= arr[2];
				break;
			case '*':
				answer *= arr[2];
				break;
			case '/': 
				answer /= (double)arr[2];
				break;
			}
			switch(carr[0]) {
			case '+':
				answer = arr[0] + answer;
				break;
			case '-':
				answer = arr[0] - answer;
				break;
			case '*':
				answer = arr[0] * answer;
				break;
			case '/': 
				if(answer == 0) return;
				answer = (double)arr[0] / answer;
				break;
			}			
			switch(carr[2]) {
			case '+':
				answer += arr[3];
				break;
			case '-':
				answer -= arr[3];
				break;
			case '*':
				answer *= arr[3];
				break;
			case '/': 
				answer /= (double)arr[3];
				break;
			}
			if(answer == 24) {
//				System.out.println(Arrays.toString(ans));
				check = true;
				return;
			}
			answer = 0;
			answer2 = 0;
			
			answer = arr[1];
			switch(carr[1]) {		//2 3 1
			case '+':	
				answer += arr[2];
				break;
			case '-':
				answer -= arr[2];
				break;
			case '*':
				answer *= arr[2];
				break;
			case '/': 
				answer /= (double)arr[2];
				break;
			}
			switch(carr[2]) {		
			case '+':	
				answer += arr[3];
				break;
			case '-':
				answer -= arr[3];
				break;
			case '*':
				answer *= arr[3];
				break;
			case '/': 
				answer /= (double)arr[3];
				break;
			}
			switch(carr[0]) {
			case '+':
				answer = arr[0] + answer;
				break;
			case '-':
				answer = arr[0] - answer;
				break;
			case '*':
				answer = arr[0] * answer;
				break;
			case '/': 
				if(answer == 0) return;
				answer = (double)arr[0] / answer;
				break;
			}
			if(answer == 24) {
//				System.out.println(Arrays.toString(ans));
				check = true;
				return;
			}
			answer = 0;
			answer2 = 0;
			
			answer2 = arr[2];
			switch(carr[2]) {		//3 1 2
			case '+':	
				answer2 += arr[3];
				break;
			case '-':
				answer2 -= arr[3];
				break;
			case '*':
				answer2 *= arr[3];
				break;
			case '/': 
				answer2 /= (double)arr[3];
				break;
			}
			switch(carr[0]) {		
			case '+':	
				answer = arr[0] + arr[1];
				break;
			case '-':
				answer = arr[0] - arr[1];
				break;
			case '*':
				answer = arr[0] * arr[1];
				break;
			case '/': 
				answer = (double)(arr[0] / arr[1]);
				break;
			}
			switch(carr[1]) {
			case '+':
				answer += answer2;
				break;
			case '-':
				answer -= answer2;
				break;
			case '*':
				answer *= answer2;
				break;
			case '/': 
				if(answer2 == 0) return;
				answer /= (double)answer2;
				break;
			}
			if(answer == 24) {
//				System.out.println(Arrays.toString(ans));
				check = true;
				return;
			}
			answer = 0;
			answer2 = 0;
			
			answer = arr[2];
			switch(carr[2]) {		//3 2 1
			case '+':	
				answer += arr[3];
				break;
			case '-':
				answer -= arr[3];
				break;
			case '*':
				answer *= arr[3];
				break;
			case '/': 
				answer /= (double)arr[3];
				break;
			}
			switch(carr[1]) {
			case '+':
				answer = arr[1] + answer;
				break;
			case '-':
				answer = arr[1] - answer;
				break;
			case '*':
				answer = arr[1] * answer;
				break;
			case '/': 
				if(answer == 0) return;
				answer = (double)arr[1] / answer;
				break;
			}
			switch(carr[0]) {		
			case '+':	
				answer = arr[0] + answer;
				break;
			case '-':
				answer = arr[0] - answer;
				break;
			case '*':
				answer = arr[0] * answer;
				break;
			case '/': 
				if(answer == 0) return;
				answer = (double)arr[0] / answer;
				break;
			}
			if(answer == 24) {
//				System.out.println(Arrays.toString(ans));
				check = true;
				return;
			}
			answer = 0;
			answer2 = 0;
			return;
		}
		for(int i = 0; i < 4; i++) {
			carr[depth] = oper[i];
			operation(carr, depth+1);
		}
	}
}
