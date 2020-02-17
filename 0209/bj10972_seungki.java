

import java.util.Arrays;
import java.util.Scanner;

public class bj10972_seungki {
	static int[] numbers; // 원래 나열된 수들을 통해 스와핑을 함!
	static int N, R, totalCount;
	static boolean selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		for(int i=0;i<N;i++) {
			numbers[i]=sc.nextInt();
		}
		np(numbers);
		if(selected) {
			System.out.println("-1");
		}else {
			for(int i=0;i<N;i++) {
				System.out.print(numbers[i]+" ");
			}
		}
		
	}

	// index자리에 올 수를 뽑아 기존 뒤에 붙이기...

	private static boolean np(int[] numbers) {
		totalCount++;
		// 1. 뒷쪽부터 탐색하며 교환이 필요한 위치(i-1) 찾기
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i]) {
			--i;
		}
		if (i == 0) {
			selected=true;
			return false; // i가 꼭지고 더이상 이전원소가 없음... (즉, 내림차순된 순열...)
			// 2. i-1위치와 교환할 한단계 큰 j위치를 찾기(j위치는 맨뒤부터 탐색..)
		}
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) {
			--j;
		}
		// 3. i-1위치와 j위치 swap
		int temp = numbers[i - 1];
		numbers[i - 1] = numbers[j];
		numbers[j] = temp;

		j = N - 1;
		// 4. i-1위치 뒤쪽(i위치) 으로부터 끝까지 가장 작은 순열로 재배치...
		// i위치부터 끝은 내림차순 된 모습 이를통해 오름차순으로 뒤집을 수 있다.
		while (i < j) {
			temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
			++i;
			--j;
		}
		return true;
	}
}
