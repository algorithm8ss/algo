#include <iostream>
#include <queue>
#include <stack>

using namespace std;

void dfsLogic(int visit);
void bfsLogic(int visit);

static int N, M, V;
static bool arr[1001][1001];
static stack<int> s;	// DFS
static queue<int> q;	// BFS
static bool isVisited[1001];	// DFS false 초기화 배열
static bool isVisited2[1001];	// BFS false 초기화 배열

int main()
{
	cin >> N >> M >> V;
	for (int i = 0; i < M; i++) {	// 간선 초기화
		int v1, v2;

		cin >> v1 >> v2;

		arr[v1][v2] = 1;
		arr[v2][v1] = 1;
	}
	
	s.push(V);
	isVisited[V] = 1;
	cout << V << " ";
	dfsLogic(V);			// DFS 로직

	cout << endl;

	isVisited2[V] = 1;
	q.push(V);
	bfsLogic(V);			// BFS 로직

	return 0;
}

void dfsLogic(int visit) {
	int top = s.top();
	for (int i = 1; i <= N; i++) {
		if (arr[top][i] && !isVisited[i]) {	// 간선이 있고 & 방문하지 않았으면
			cout << i << " ";				// 연결된 간선 출력
			isVisited[i] = 1;				
			s.pop();						// 현재 실행한 vertex pop
			s.push(i);						//  다음 vertex push
			dfsLogic(s.top());				// 재귀 호출 -> stack 쌓이는 구조
		}
	}
}

void bfsLogic(int visit) {
	int front = q.front();
	while(!q.empty()) {						// queue 가 비는 경우 중단
		front = q.front();	
		cout << front << " ";
		q.pop();
		for (int i = 1; i <= N; i++) {
			if (arr[front][i] && !isVisited2[i]) {	
				isVisited2[i] = 1;
				q.push(i);
			}
		}
	}
}
