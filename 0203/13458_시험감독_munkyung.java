#include <iostream>
#include <vector>

using namespace std;

int main()
{
	int N, B, C;
	long cnt = 0;
	vector<int> v;

	cin >> N;
	
	while (N--) {
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}

	cin >> B >> C;

	for (int i = 0; i < v.size(); i++) {
		if (v[i] - B <= 0) {
			cnt++;
		}
		else {
			if ((v[i] - B) % C == 0) {
				cnt += (v[i] - B) / C;
				cnt++;
			} else {
				cnt += (v[i] - B) / C + 1;
				cnt++;
			}
		}
	}

	cout << cnt;
	return 0;
}
