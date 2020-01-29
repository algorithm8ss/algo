import java.util.Scanner;
import java.util.Arrays;
public class ts {
	static int[] day, money, combination[], moneysum;
	static int count, sum[], max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = 0;
		int n = sc.nextInt();
		boolean visited[] = new boolean[n];
		day = new int[n];
		money = new int[n];
		count = 0;
		test = (int)Math.pow(2, n);
		sum = new int[test];
		moneysum = new int[test];
		combination = new int[test][n];
		max = 0;
		for(int i = 0; i < n; i++) {
			day[i] = sc.nextInt();
			money[i] = sc.nextInt();
		}
		for(int i = 1; i <= n; i++) {
			comb(day, visited, 0, n, i);
		}
		for(int i = 0; i < test; i++) {
			for(int j = 0; j < n; j++) {
				sum[i] += combination[i][j];
			}
		}
		for(int i = 0; i < test; i++) {
			if(moneysum[i] > max) max = moneysum[i];
		}
		System.out.println(max);

	}
	static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
	    if(r == 0) {
	    	outloop:
	        for(int i=0; i<n; i++) {
	            if(visited[i] == true) {
	            	if(arr[i] + i <= n) {
	            		for(int j = 0; j < i; j++) {
	            			if(i < combination[count][j]+j) continue outloop;
	            		}
		    		    combination[count][i] = arr[i];
		    		    moneysum[count] += money[i];
	            	}
	            }   	
	        }
            count++;
	        return;
	    }
	    if(depth == n) {
	        return;
	    } else {
	        visited[depth] = true;
	        comb(arr, visited, depth + 1, n, r - 1);
	 
	        visited[depth] = false;
	        comb(arr, visited, depth + 1, n, r);
	    }
	}
}
