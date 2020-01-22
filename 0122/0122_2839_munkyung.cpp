#pragma warning (disable:4996)
#include<iostream>

using namespace std;

int main()
{
	int size, cnt = -1;
	cin >> size;
	bool isFinish = false;

	for (int i = size/5; i >= 0; i--) {
		if((size - (5*i)) % 3 == 0) {
			cnt = i + ((size - (5 * i)) / 3);
			isFinish = true;
			break;
		}
	}
	cout << cnt << endl;
	return 0;
}