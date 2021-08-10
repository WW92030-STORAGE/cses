#include <iostream>
#include <algorithm>
#define ll long long
using namespace std;

int main() // https://cses.fi/problemset/task/1636
{
    int modd = 1e9 + 7;
    int size, target;
    cin >> size >> target;
    int denom[size];
    for (int i = 0; i < size; i++) {
        cin >> denom[i];
    }
    sort(denom, denom + size);
    int val[size + 2][target + 2];
    for (int i = 0; i < size + 2; i++) {
        for (int j = 0; j < target + 2; j++) val[i][j] = 0;
    }
    val[0][0] = 1;
    for (int i = 1; i <= size; i++) {
			for (int j = 0; j <= target; j++) {
				val[i][j] = val[i-1][j];
				int left = j - denom[i - 1];
				if (left >= 0) {
					val[i][j] += val[i][left];
					val[i][j] %= modd;
				}
			}
		}
    
    
    cout << val[size][target];
    return 0;
}
