import java.util.Scanner;

public class Main {
	static Scanner sc;
	static int N;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = new int[N];
	    if (N == 1) {
            arr[0] = 1;
        } else if (N == 2) {
            arr[1] = 1;
        } else {
            arr[0] = 1;
            arr[1] = 1;
            for (int i = 2; i < N; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }
	    
        System.out.println(arr[N-1]);
	}
}
