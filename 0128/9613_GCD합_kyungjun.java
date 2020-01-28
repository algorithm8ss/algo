import java.util.Scanner;
public class GCD합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int n;
		int Arr[];
		int big, small, test;
		for(int i = 0; i < t; i++) {
			n = sc.nextInt();
			long GCD = 0;
			Arr = new int[n];
			for(int j = 0; j < n; j++) {
				Arr[j] = sc.nextInt();
				for(int k = 0; k < j; k++) {
					if(Arr[j] >= Arr[k]) {
						big = Arr[j];
						small = Arr[k];
					}else {
						big = Arr[k];
						small = Arr[j];
					}
					while(true) {
						if(big <= 0 || small <= 0) break;
						test = big % small;
						if(test == 0) {
							GCD += small;
							break;
						}else {
							big = small;
							small = test;
						}
					}
				}
				
			}
			System.out.println(GCD);
		}
		sc.close();
	}

}
