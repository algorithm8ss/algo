import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프린터큐 {
	
	static class pri{
		int idx;
		int priority;
		public pri(int idx, int priority) {
			super();
			this.idx = idx;
			this.priority = priority;
		}
	}
	
	private static Integer priority[];
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<pri> queue = new LinkedList<pri>();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			int n = 0, m = 0;
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			priority = new Integer[n];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				priority[j] = Integer.parseInt(st.nextToken());
				queue.offer(new pri(j, priority[j]));
			}
			Arrays.sort(priority, Collections.reverseOrder());
			
			int check = 0;
			int answer = 0;
			while(true) {
				
				if(queue.peek().priority == priority[check]) {
					pri a = queue.poll();
					check++;
					answer++;
					if(a.idx == m) {
						queue.clear();
						break;
					}
				}else {
					pri a = queue.poll();
					queue.offer(a);
				}	
				
				if(queue.isEmpty()) {
					break;
				}
				
			}
			
			System.out.println(answer);
		}
	}

}