import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		long count = 0;
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		int b = sc.nextInt();
		int c = sc.nextInt();

		for (int i = 0; i < N; i++) {
			if (a[i] <= b) {
				count++;
				continue;
			} else {
				a[i] -= b;
				count++;
				if (a[i] % c == 0) {
					count += a[i] / c;
					continue;
				} else {
					count += a[i] / c + 1;
					continue;
				}

			}
		}

		System.out.println(count);
	}

}