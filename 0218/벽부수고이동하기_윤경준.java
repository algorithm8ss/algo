import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class axis{
		int x;
		int y;
		int dis;
		int bre;
		public axis(int x, int y, int dis, int bre){
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.bre = bre;
		}
		
	}
	private static int n, m, map[][], visited[][];
	private static Queue<axis> q = new LinkedList<axis>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		visited = new int[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			String str = br.readLine();
			for(int j = 1; j <= m; j++) {
				map[i][j] = str.charAt(j-1) - '0';
			}
		}
		bfs(1, 1, 1, 0);
		if(check)
			bw.write(String.valueOf(ans));
		else
			bw.write(String.valueOf(-1));
		bw.flush();
		bw.close();

	}
	private static int dx4[] = {0, 1, 0, -1};
	private static int dy4[] = {1, 0, -1, 0};
	private static int ans;
	private static boolean check;
	private static void bfs(int x, int y, int dis, int bre) {
		int row;
		int col;
		q.offer(new axis(x, y, dis, bre));
		visited[x][y] = 1;
		while(!q.isEmpty()) {
			axis a = q.poll();
			int nextx = a.x;
			int nexty = a.y;
			ans = a.dis;
			int brea = a.bre;
			if(nextx == n && nexty == m) {
				check = true;
				return;
			}
			for(int i = 0; i < 4; i++) {
				row = nextx + dx4[i];
				col = nexty + dy4[i];
				if(row > n || row < 1 || col > m || col < 1) continue;
				if(brea == 0) {
					if(visited[row][col] == 1) continue;
				}
				else {
					if(visited[row][col] == 1) continue;
					if(visited[row][col] == 2) continue;
				}

				
				if(map[row][col] == 0 && brea == 0) {
					q.offer(new axis(row, col, a.dis+1, brea));
					visited[row][col] = 1;
				}
				else if(map[row][col] == 0 && brea == 1) {
					q.offer(new axis(row, col, a.dis+1, brea));
					visited[row][col]= 2;
				}else if(map[row][col] == 1 && brea == 0) {
					q.offer(new axis(row, col, a.dis+1, brea+1));
					visited[row][col]= 2;
				}else {
					continue;
				}
			}
		}
	}
}
