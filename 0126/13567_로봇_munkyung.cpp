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
    int M, n;
    int dx = 0, dy = 0;
    vector<int> vx = {1, 0, -1, 0};
    vector<int> vy = {0, 1, 0, -1};
    int pvt = 0;
    bool err = false;
    
    cin >> M >> n;
    
    while(n--) {
        string cmd;
        int opt;
        cin >> cmd >> opt;
        if(cmd == "MOVE") {
            dx += vx[pvt]*opt;
            dy += vy[pvt]*opt;
            if(dx > M || dx < 0 || dy > M || dy < 0) {
                cout << -1 << endl;
                err = true;
                break;
            }
        } else if(cmd == "TURN") {
            if(opt == 0) {
                if(pvt == 3) {
                    pvt = 0;
                }else {
                    pvt++;
                }
            } else {
                if(pvt == 0) {
                    pvt = 3;
                }else {
                    pvt--;
                }
            }
        }
    }
    
    if(!err) {
        cout << dx << " " << dy;
    }
    
    return 0;
}
