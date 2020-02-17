package น้มุ0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B3190_น์_Jaewon {
	static int playtime;
	static int N,K,L;
	static int[][] map;
	static ChDir[] cd;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};	
	
	static class Point{
		int r,c;
		public Point(int r, int c) {
			// TODO Auto-generated constructor stub
			this.r = r;
			this.c = c;	
		}				

	}
	
	static class ChDir{
		int time;
		char dir;
		public ChDir(int time, char dir) {
			// TODO Auto-generated constructor stub
			this.time = time;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N+2][N+2];
		// wall, body : -1 , empty : 0 
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(i==0||i==map.length-1||j==0||j==map.length-1)
					map[i][j]=-1;
			}
		}	
		
		// # apples : 1
		K = Integer.parseInt(in.readLine());
		for (int k = 0; k < K; k++) {
			StringTokenizer st =  new StringTokenizer(in.readLine());
			int ar = Integer.parseInt(st.nextToken());
			int ac = Integer.parseInt(st.nextToken());
			map[ar][ac] = 1;			
		}
		
		// # change direction
		L = Integer.parseInt(in.readLine());
		cd = new ChDir[L];
		for (int l = 0; l < L; l++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			cd[l] = new ChDir(time, dir);
		}
		
		sol(new Point(1,1));
		System.out.println(playtime);
	}
	
	
	public static void sol(Point point) {
		int dir = 0;
		Deque<Point> dq = new LinkedList<Point>();
		dq.add(point);
		map[point.r][point.c] = -1;
		playtime = 0;
		//move
		while(true) {
			playtime++;

			Point tp = dq.peekLast();
			int nr = tp.r+dr[dir]; int nc = tp.c+dc[dir];
			if(map[nr][nc]==-1) {
				return;	
			}			
			for(ChDir c : cd) {
				if(c.time==playtime)
					dir = rotate(dir,c.dir);
			}
			Point tail = dq.poll();
			if(map[nr][nc]==1) {
				dq.offer(new Point(nr,nc));
				dq.offerFirst(tail);
				map[nr][nc] = -1;
			}else {
				dq.offer(new Point(nr,nc));
				map[nr][nc] = -1;
				map[tail.r][tail.c] = 0;
			}

		}
		
	}
	
	public static int rotate(int dir, char r) {
		if(r=='L') {
			dir--;
			if(dir<0)
				dir+=4;			
		}else if(r=='D') {
			dir++;
			if(dir>=4)
				dir%=4;			
		}
		return dir;
	}
}
