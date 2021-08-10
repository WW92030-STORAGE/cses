#include <stdio.h>
#include <iostream>
#include <algorithm>
using namespace std;

int main() // https://cses.fi/problemset/task/1158
{
    int n, maxi;
    cin >> n >> maxi;
    int weights[n + 69];
    int vals[n + 69];
    
    for (int ii = 0; ii < n; ii++) cin >> weights[ii];
    for (int ii = 0; ii < n; ii++) cin >> vals[ii];
    
    int dp[n + 100][maxi + 100];
    int i, w;
    
    for (i = 0; i <= n; i++) {
        for (w = 0; w <= maxi; w++) {
            if (i == 0 || w == 0) dp[i][w] = 0;
            else if (weights[i - 1] <= w) dp[i][w] = max(vals[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
			else dp[i][w] = dp[i - 1][w]; 
        }
    }
    cout << dp[n][maxi];

    return 0;
}
