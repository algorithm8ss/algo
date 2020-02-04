#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

struct Doc { // queue 에 담을 문서 구조체
	int idx;
	int priority;
};

int main()
{
	int T, cnt;       // test case 개수, 출력되는 순서 카운터

	cin >> T;        

	while (T--) {
		cnt = 0;        // 출력되는 순서 카운터 = 0 초기화
		int N, M;       // N : 문서 개수, M : 보고싶은 문서의 인덱스
		queue<Doc> q;   // 문서를 담을 큐
		vector<int> v;  // 우선순위들을 담을 배열

		cin >> N >> M; 

		for (int i = 0; i < N; i++)
		{
			Doc d;        // 큐에 저장할 문서 구조체 선언
			int tmp;      // 각 문서의 우선순위 받는 tmp 변수
			cin >> tmp;   
			d.idx = i;    // 인덱스는 순서대로 증가하며 저장
			d.priority = tmp;   // 우선순위 저장
			q.push(d);    // 큐에 구조체 push  
			v.push_back(tmp); // 배열에 우선순위 담기
		}

		sort(v.begin(), v.end());   // 오름차순 정렬
		reverse(v.rbegin(), v.rend());  // 배열 역순 정렬

		while(1) {
			if (q.front().idx == M && q.front().priority ==	v[cnt]) { // 찾는 인덱스이면서 우선순위가 가장 높을 때
				cnt++;  
				break;    // 빠져나옴
			} else if(q.front().priority == v[cnt]) { // 우선순위가 가장 높을 때
				q.pop();  // 출력해주기
				cnt++;    // 출력순서 증가
			} else {      
				q.push(q.front());   // 제일 처음에 있는 문서를
				q.pop();             // 뒤로 보내기
			}
		}

		cout << cnt << endl;  // 원하는 문서의 출력 순서  
	}
	return 0;
}
