//
//  main.cpp
//  algo
//
//  Created by munkyung choi on 2020/01/27.
//  Copyright © 2020 munkyung choi. All rights reserved.
//

#include <cstdio>
#include <vector>
#include <sstream>
#include <string>
#include <iostream>
#include <cstring>
#include <stack>
#include <queue>
#include <map>
#include <set>
#include <unordered_map>
#include <algorithm>
#include <list>
#include <fstream>

using namespace std;

int main(int argc, const char * argv[]) {
    int N = 0;
    vector<int> v;
    
    cin >> N;
    
    v.push_back(0);
    v.push_back(1);
    v.push_back(2);
    
    for(int i = 3; i <= N; i++) {
        v.push_back((v[i-1] + v[i-2])%15746);
    }
    
    cout << v[N]%15746 << endl;
    return 0;
}
