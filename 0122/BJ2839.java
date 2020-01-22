import java.util.Scanner;

public class BJ2839 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		int x = 0; int y = 0;
		boolean isTrue = false;
		int N = sc.nextInt();
		int xLim = N / 3;

		for (int i = 0; i <= xLim; i++) {
			int temp = N - 3 * i;
			if (temp % 5 == 0) {
				isTrue = true;
				int num = i + (temp / 5);
				if (min > num)
					min = num;
			}
		}
		if (isTrue)
			System.out.println(min);
		else
			System.out.println("-1");
	}

}
