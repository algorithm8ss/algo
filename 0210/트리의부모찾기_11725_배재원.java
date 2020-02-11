package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725_배재원 {

	static class Node {
		boolean visited;
		int num;
		ArrayList<Integer> arr;
		int parent;

		public Node(int num) {
			// TODO Auto-generated constructor stub
			this.num = num;
			arr = new ArrayList<Integer>();
			parent = 0;
			visited = false;
		}

		public void addArr(int num) {
			arr.add(num);
		}
	}

	static Node[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		tree = new Node[N + 1];
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			if (tree[p] == null) {
				tree[p] = new Node(p);
				tree[p].addArr(q);
			} else
				tree[p].addArr(q);

			if (tree[q] == null) {
				tree[q] = new Node(q);
				tree[q].addArr(p);
			} else
				tree[q].addArr(p);
		}

		sol(1, 0);

		for (int i = 2; i < tree.length; i++) {
			System.out.println(tree[i].parent);
		}
	}

	public static void sol(int idx, int parent) {
		if(!tree[idx].visited) {
			tree[idx].parent = parent;
			tree[idx].visited = true;
			for (int i = 0; i < tree[idx].arr.size(); i++) {
				sol(tree[idx].arr.get(i), idx);
			}
		}

	}
}
