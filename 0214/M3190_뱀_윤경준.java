import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀 {
	static class axis{
		int x;
		int y;
		public axis(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static Queue<axis> q = new LinkedList<axis>();
	private static int n, k, map[][], time[], endtime, length;
	private static char[] direction;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		StringTokenizer st;
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
		}
		int l = Integer.parseInt(br.readLine());
		direction = new char[l];
		time = new int[l];
		for(int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			direction[i] = st.nextToken().charAt(0);
		}
		map[1][1] = 1;
		int tempdir = 3;
		q.offer(new axis(1, 1));
		delta(1,1,tempdir);
		length = 1;
		endtime = 0;
		while(true) {
			endtime++;
			if(check) break;
			
			for(int i = 0; i < time.length; i++) {
				if(endtime == time[i]) {
					if(direction[i] == 'D') {
						switch(tempdir) {
						case 0:			// 위
							tempdir = 3;
							break;
						case 1:			// 왼쪽
						case 2:			// 아래
						case 3:			// 오른쪽
							tempdir--;
							break;
						}
					}else if(direction[i] == 'L') {
						switch(tempdir) {
						case 0:
						case 1:
						case 2:
							tempdir++;
							break;
						case 3:
							tempdir = 0;
							break;
						}
					}
					break;
				}
			}
			delta(tempx, tempy, tempdir);
				
		}
		System.out.println(endtime);
		
	}
	
	private static int dx4[] = {-1, 0, 1, 0};
	private static int dy4[] = {0, -1, 0, 1};
	private static boolean check;
	private static int tempx, tempy, tailx, taily;
	private static void delta(int x, int y, int dir) {
		int row = x + dx4[dir];
		int col = y + dy4[dir];
		if(row < 1 || row > n || col < 1 || col > n) {
			check = true;
			return;
		}
		if(map[row][col] == 1) {
			check = true;
			return;
		}
		if(map[row][col] == 2) {
			q.offer(new axis(row, col));
			map[row][col] = 1;
			length++;
		}else if(map[row][col] == 0) {
			q.offer(new axis(row, col));
			map[row][col] = 1;
			axis a = q.poll();
			tailx = a.x;
			taily = a.y;
			map[tailx][taily] = 0;
		}
		
	}

}
