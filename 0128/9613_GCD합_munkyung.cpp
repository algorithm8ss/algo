#include <iostream>
#include <vector>

using namespace std;

int main()
{
	int t;

	cin >> t;

	while (t--) {
		long n, result = 0;
		vector<long> v;
		cin >> n;
		
		for (int i = 0; i < n; i++) {
			int tmp;
			cin >> tmp;
			v.push_back(tmp);
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int a = v[i], b = v[j], gcd;
				while (b != 0) {
					gcd = a % b;
					a = b;
					b = gcd;
				}
				result += a;
			}
		}
		cout << result << endl;
	}
	return 0;
}