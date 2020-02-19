package 스터디_2018;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알고스팟_배재원 {
	static StringTokenizer st;
	static int N,M;
	static int[][] visited;
	static int[][] map;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	
	static class Point{
		int r,c;
		int breakWall;
		public Point(int r, int c,int breakWall) {
			// TODO Auto-generated constructor stub
			this.r = r;
			this.c = c;
			this.breakWall = breakWall;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+2][M+2];
		for(int[] a : map)
			Arrays.fill(a, -1);		
		visited = new int[N+2][M+2];
		for(int[] a : visited)
			Arrays.fill(a, N+M);	
		for (int i = 1; i <= N; i++) {
			String s = in.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = (int)(s.charAt(j-1)-'0');
			}
		}
		
//		for(int[] a : map) {
//			for(int b : a)
//				System.out.print(b+"\t");
//			System.out.println();
//		}
		
		Queue<Point> q = new LinkedList<Point>();
		visited[1][1] = 0;
		q.add(new Point(1,1,0));
		while(!q.isEmpty()) {
			Point temp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = temp.r+dr[i];
				int nc = temp.c+dc[i];
				if(map[nr][nc]!=-1) {
					if(map[nr][nc]==0) {
						if(visited[nr][nc]>temp.breakWall) {
							visited[nr][nc] = temp.breakWall;
							q.add(new Point(nr,nc,temp.breakWall));
						}
					}else if(map[nr][nc]==1) {
						if(visited[nr][nc]>temp.breakWall+1) {
							visited[nr][nc] = temp.breakWall+1;
							q.add(new Point(nr,nc,temp.breakWall+1));
						}
					}
				}
			}
		}
		
		System.out.println(visited[N][M]);
	}

	
	
}