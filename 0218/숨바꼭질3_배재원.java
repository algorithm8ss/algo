package 스터디_2018;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3_배재원 {
	static int max;
	static int N, K;
	static StringTokenizer st;
	static int min;
	static int visited[];

	public static class Pair implements Comparable<Pair> {
		int time;
		int loc;

		public Pair(int loc, int time) {
			// TODO Auto-generated constructor stub
			this.loc = loc;
			this.time = time;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		min = Math.abs(N - K);
		max = 100001;
		visited = new int[max];
		Arrays.fill(visited, min);
		sol(N);
		System.out.println(min);
	}

	public static void sol(int N) {

		Queue<Pair> pq = new LinkedList<Pair>();
		pq.offer(new Pair(N, 0));

		while (!pq.isEmpty()) {
			Pair temp = pq.poll();
			
			if(temp.loc==K) {
				if(min>temp.time) min = temp.time;
			}
			
			if (temp.loc * 2 > 0 && temp.loc * 2 < max&&visited[temp.loc * 2]>temp.time) {
				visited[temp.loc * 2] = temp.time;
				pq.offer(new Pair(temp.loc * 2, temp.time));					
			}		
			if (temp.loc - 1 >= 0 && temp.loc -1 < max&&visited[temp.loc - 1 ]>temp.time+1) {
				visited[temp.loc - 1] = temp.time+1;
				pq.offer(new Pair(temp.loc -1, temp.time+1));
			}
				
			
			if (temp.loc + 1 >= 0 && temp.loc +1 < max&&visited[temp.loc + 1 ]>temp.time+1 ) {
				visited[temp.loc + 1 ]= temp.time+1;
				pq.offer(new Pair(temp.loc +1, temp.time+1));				
			}
			
		}
	}

}