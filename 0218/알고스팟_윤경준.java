import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class axis{
		int x;
		int y;
		int dis;
		public axis(int x, int y, int dis){
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
		
	}
	private static int n, m, map[][], check[][];
	private static boolean visited[][];
	private static Deque<axis> q = new LinkedList<axis>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		for(int i = 1; i <= m; i++) {
			String str = br.readLine();
			for(int j = 1; j <= n; j++) {
				map[j][i] = str.charAt(j-1) - '0';
			}
		}
		bfs(1, 1, 0);
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();

	}
	private static int dx4[] = {0, 1, 0, -1};
	private static int dy4[] = {1, 0, -1, 0};
	private static int ans;
	private static void bfs(int x, int y, int dis) {
		int row;
		int col;
		q.offer(new axis(x, y, 0));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			axis a = q.pollLast();
			int nextx = a.x;
			int nexty = a.y;
			ans = a.dis;
			if(a.x == n && a.y == m) return;
			for(int i = 0; i < 4; i++) {
				row = nextx + dx4[i];
				col = nexty + dy4[i];
				if(row > n || row < 1 || col > m || col < 1) continue;
				if(visited[row][col]) continue;
				
				if(map[row][col] == 0) {
					q.offerLast(new axis(row, col, a.dis));
					visited[row][col] = true;
				}else {
					q.offerFirst(new axis(row, col, a.dis+1));
					visited[row][col] = true;
				}
			}
		}
	}
}
