package 스터디_2018;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_배재원 {
	static StringTokenizer st;
	static int[][] map;
	static int[][][] visited;

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static class Point {
		int r, c;
		int distance;
		int breakWall;

		public Point(int r, int c, int distance, int breakWall) {
			// TODO Auto-generated constructor stub
			this.r = r;
			this.c = c;
			this.distance = distance;
			this.breakWall = breakWall;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N + 2][M + 2];
		visited = new int[N + 2][M + 2][2];
		for (int[] i : map)
			Arrays.fill(i, -1);

		for (int i = 1; i <= N; i++) {
			String s = in.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = (int) (s.charAt(j - 1) - '0');
			}
		}
		bfs();
		if (visited[N][M][0] != 0 && visited[N][M][1] != 0) {
			System.out.println(Math.min(visited[N][M][0], visited[N][M][1]));
		} else if (visited[N][M][0] == 0 && visited[N][M][1] != 0) {
			System.out.println(visited[N][M][1]);
		} else if(visited[N][M][0] != 0 && visited[N][M][1] == 0){
			System.out.println(visited[N][M][0]);
		} else{
			System.out.println(-1);
		}
	}

	public static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		visited[1][1][0] = 1;
		q.add(new Point(1, 1, 1, 0));

		while (!q.isEmpty()) {
			Point temp = q.poll();
			int w = temp.breakWall;
			for (int i = 0; i < 4; i++) {
				int nr = temp.r + dr[i];
				int nc = temp.c + dc[i];
				if (map[nr][nc] == -1)
					continue;
				if (visited[nr][nc][w] != 0)
					continue;

				if (map[nr][nc] == 0) {
					if (visited[nr][nc][w] == 0 || visited[nr][nc][w]>temp.distance+1) {
						visited[nr][nc][w] = temp.distance + 1;
						q.add(new Point(nr, nc, temp.distance + 1, w));
					}
				}else if (map[nr][nc]== 1 && w==0) {
					if (visited[nr][nc][1] == 0 || visited[nr][nc][1]>temp.distance+1) {
						visited[nr][nc][1] = temp.distance + 1;
						q.add(new Point(nr, nc, temp.distance + 1, 1));
					}
				}

			}
		}

	}

}