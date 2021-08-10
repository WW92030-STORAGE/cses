#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <iterator>
#include <set>
using namespace std;
#define ll long long

ll iii(bool b) { // https://cses.fi/problemset/task/1652 
    if (b) return 1;
    return 0;
}

int main()
{
    ll n, m;
    cin >> n >> m;
    ll tot[n + 1][n + 1];
    bool board[n][n];
    
    for (ll i = 0; i <= n; i++) {
        for (ll j = 0; j < n; j++) {
            if (i < n && j < n) board[i][j] = false;
            tot[i][j] = 0;
        }
    }
    
    for (ll i = 0; i < n; i++) {
        for (ll j = 0; j < n; j++) {
            char c;
            cin >> c;
            if (c == '*') board[i][j] = true;
        }
    }
    
    if (board[0][0]) tot[1][1] = 1;
	else tot[1][1] = 0;
	
	for (int i = 1; i <= n; i++) {
		tot[i][1] = tot[i - 1][1] + iii(board[i - 1][0]);
		tot[1][i] = tot[1][i - 1] + iii(board[0][i - 1]);
	}
	for (int i = 2; i <= n; i++) {
		for (int j = 2; j <= n; j++) {
			tot[i][j] = tot[i - 1][j] + tot[i][j - 1] + iii(board[i - 1][j - 1]) - tot[i - 1][j - 1];
		}
	}
	
	ll x1, y1, x2, y2;
	
	for (ll i = 0; i < m; i++) {
	    cin >> x1 >> y1 >> x2 >> y2;
	    x1--;
	    y1--;
	    ll res = tot[x2][y2] - tot[x1][y2] - tot[x2][y1] + tot[x1][y1];
	    cout << res << endl;
	}
    
    /*
    10 1
    **.*.*.**.
    *.**.*..*.
    .*****.**.
    **....***.
    .****...**
    .**.******
    .****..*.*
    *.**.**...
    ..*.****.*
    **.*.*...*
1 4 7 9
    */
    return 0;
}