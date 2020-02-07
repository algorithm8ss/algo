package backjun;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class DFS와BFS_1260_S1 {
	private static int[][] adjMatrix;
	private static boolean[] visited;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		adjMatrix = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=0; i<M; i++ ) {
			int x= sc.nextInt();
			int y= sc.nextInt();
			adjMatrix[x][y]=1;
			adjMatrix[y][x]=1;
		
//			for(int p=0; p<M; p++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(adjMatrix[p][j]);
//				}
//				System.out.println();
//	 		}
//			System.out.println();
		}
		
		
		//출력 테스트
//		for(int i=1; i<=N; i++) {
//			for(int j=1; j<=N; j++) {
//				System.out.print(adjMatrix[i][j]);
//			}
//			System.out.println();
// 		}
		dfs(V);
		System.out.println();
		bfs(V);
		
	}
	
	public static void dfs(int current) {
		visited[current] =true;
		System.out.printf("%d " , current);
		
		for(int j=1; j<=N;j ++) {
			if(adjMatrix[current][j] >0 && !visited[j])
				dfs(j);
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		visited[start] =true;
		queue.offer(start);
		
		int current;
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.printf("%d ", current);
			
			for(int j=1; j<=N;j ++) {
				if(adjMatrix[current][j]>0 && !visited[j]) {
					visited[j] = true;
					queue.offer(j);
				}
			}
		}
	}

}
