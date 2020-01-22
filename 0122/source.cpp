#pragma warning (disable:4996)
#include<iostream>
#include<map>
#include<deque>
#include<string>

using namespace std;

int main()
{
	string str = "";
	int T, cnt = 0;
	cin >> str;
	cin >> T;

	while (T--) {
		int pvt = 0;
		string tmpStr;
		cin >> tmpStr;
		bool isFound = false;
		for (int i = 0; i < str.size(); i++) {
			for (int j = pvt%10; j < 10; j++) {
				if (str[i] == tmpStr[j]) {
					isFound = true;
					pvt = ++j;
					break;
				}
			}
			if (!isFound) {
				break;
			}
			else if (isFound && i == str.size() - 1) {
				cnt++;
			}
			isFound = false;
		}
		
	}
	cout << cnt << endl;
	return 0;
}