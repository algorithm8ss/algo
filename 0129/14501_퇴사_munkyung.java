#include <iostream>
#include <vector>
#include <utility>

/*
* test case 는 돌아가는데...
* 
*/

using namespace std;

static int N, totalDay, m = 0;
static vector<pair<int, int>> v;

void checkMax(int idx, int tmpT, int tmpP){
    if(idx >= totalDay) return;
    
    if(tmpT == 0) {
        tmpT = v[idx].first;
        if(v[idx].first <= totalDay - idx) {
            tmpP += v[idx].second;
            if(m < tmpP)  {
                m = tmpP;
            }
        }
    }
    
    for (int i = idx + 1; i < totalDay; i++) {
        checkMax(i, tmpT - 1, tmpP);
    }
}

int main(int argc, const char * argv[]) {
    cin >> N;
    totalDay = N;
    while(N--) {
        int T, C;
        cin >> T >> C;
        v.push_back(make_pair(T, C));
    }

    for (int i = 0; i < totalDay; i++) {
        checkMax(i, v[i].first, v[i].second);
    }

    cout << m;
    return 0;
}
