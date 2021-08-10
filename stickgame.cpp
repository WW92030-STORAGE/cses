#include <stdio.h>
#include <iostream>
using namespace std;

int main() // https://cses.fi/problemset/task/1729
{
    int n, m;
    cin >> n >> m;
    bool state[n];
    int vals[m];
    for (int i = 0; i < m; i++) {
        cin >> vals[i];
        state[i] = false;
    }
	for (int i = 1; i <= n + 1; i++) {
		bool win = false; // win if can get to losing state
		for (int j : vals) {
			if (i - j >= 0) {
				if (!state[i - j]) {
	    			win = true;
					break;
				}
			}
		}
		state[i] = win;
	}
	for (int i = 1; i <= n; i++) {
    	if (state[i]) cout << "W";
		else cout << "L";
	}
    return 0;
}
