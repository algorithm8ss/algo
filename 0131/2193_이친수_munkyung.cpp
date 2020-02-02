#include <iostream>

using namespace std;

int main()
{
	int N;
	cin >> N;
  
	long long D[91][2] = { 0 };
	long long sum = 0;

	D[1][0] = 0;
	D[1][1] = 1;

	for (int i = 2; i <= N; i++) 
	{
		D[i][0] = D[i - 1][0] + D[i-1][1];
		D[i][1] = D[i - 1][0];
	}

	sum += D[N][0] + D[N][1];
	
	cout << sum << endl;
	return 0;
}
