import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class check1{
	int x;
	int time;
	public check1(int x, int time) {
		this.x = x;
		this.time = time;
	}
}

public class 숨바꼭질3{
	private static boolean visited[];
	private static int s, d, ans, time;
	private static Queue<check1> q = new LinkedList<check1>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		bfs();
		System.out.println(time);
	}
	
	private static int dxm[] = {2, -1, 1};
	private static void bfs() {
		q.offer(new check1(s,0));
		ans = 0;
		visited[s] = true;
		
		while(!q.isEmpty()) {
			check1 t = q.poll();
			time = t.time;
			for(int i = 0; i < 3; i++) {
				if(t.x == d) return;
				if(i != 0) {
					ans = t.x + dxm[i];
				}else {
					ans = t.x * dxm[i];
				}
				if(ans < 0 || ans > 100000) continue;
				if(visited[ans]) continue;
				
				if(i != 0) {
					q.offer(new check1(ans, t.time+1));
				}else {
					q.offer(new check1(ans, t.time));
				}
				visited[ans] = true;
			}
		}
	}
}
