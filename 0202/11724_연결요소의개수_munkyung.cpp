#include <iostream>
#include <vector>
#include <map>

using namespace std;

void visit(int idx);

int N, M;
bool check[1001];
map<int, vector<int>> m;

int main(int argc, const char * argv[]) {
    
    cin >> N >> M;
    int result = 0;
    
    for (int i = 0; i < M; i++) { // 연결 요소 입력하는 반복문
        int start, end;
        cin >> start >> end;
        
        if(m.find(start) != m.end()) { // a -> b 연결 입력
            m[start].push_back(end);
        } else {
            vector<int> v;
            v.push_back(end);
            m.insert(make_pair(start, v));
        }
        
        if(m.find(end) != m.end()) { // b -> a 연결 입력
            m[end].push_back(start);
        } else {
            vector<int> v;
            v.push_back(start);
            m.insert(make_pair(end, v));
        }
    }
    
    for (int i = 1; i <= N; i++) { // vertex 개수만큼 탐색
        if(!check[i]) {
            visit(i);
            result++;
        }
    }
    
    cout << result; // 출력
    return 0;
}

void visit(int idx) { // 연결된 점 방문하는 메서드
    
    check[idx] = true;
    
    for (int i = 0; i < m[idx].size(); i++) {
        int next_idx = m.find(idx)->second[i];
        if(!check[next_idx]) {
            visit(next_idx);
        }
    }
}
