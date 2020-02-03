import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class connectedcomponent {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static ArrayList<Integer> bfs;
	static Queue<Integer> Q;
	static boolean visited[];
	static int node, edge, count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

        int x;
        int y;
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		
        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge; i++) {
        	st = new StringTokenizer(br.readLine());
        	x = Integer.parseInt(st.nextToken());
        	y = Integer.parseInt(st.nextToken());
        	graph.get(x).add(y); // 양방향이라 두개
        	graph.get(y).add(x); 
        }
        visited = new boolean[node+1];
        for(int i = 1; i <= node; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
        
        System.out.println(count);
	}
    public static void dfs(int v){
        visited[v] = true;

        for(int value : graph.get(v)){
            if(!visited[value]){
                dfs(value);
            }
        }
    }
}
