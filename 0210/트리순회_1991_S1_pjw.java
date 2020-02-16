package test;
import java.util.Scanner;
public class 트리순회_1991_S1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int map[][] = new int[26][2];
		for(int i=0; i<N; i++) {
			String str = sc.nextLine();
			int x=str.charAt(0)-'A';
			int y=str.charAt(2);
	//		System.out.println(x);
			int z=str.charAt(4);
			
			if(y=='.') 
				map[x][0]=-1;
			else
				map[x][0]=y-'A';
			if(z=='.') 
				map[x][1]=-1;
			else
				map[x][1]=z-'A';	
		}
		
		preorder(map, 0);
		System.out.println();
		inorder(map, 0);
		System.out.println();
		postorder(map, 0);
		System.out.println();
		
	}
	
	public static void preorder(int map[][], int x) {
		if(x==-1 )
			return;
		System.out.print((char)(x+'A'));
		preorder(map, map[x][0]);
		preorder(map, map[x][1]);
	}
	
	public static void inorder(int map[][], int x) {
		if(x==-1 )
			return;
		inorder(map, map[x][0]);
		System.out.print((char)(x+'A'));
		inorder(map, map[x][1]);
	}
	public static void postorder(int map[][], int x) {
		if(x==-1 )
			return;
		postorder(map, map[x][0]);
		postorder(map, map[x][1]);
		System.out.print((char)(x+'A'));
	}
}
