#include <iostream>
#include <algorithm>
#define ll long long
using namespace std;

int main() // https://cses.fi/problemset/task/1635
{
    ll modd = 1e9 + 7;
    int n, k;
    cin >> n >> k;
    int denom[n];
    for (int i = 0; i < n; i++) {
        cin >> denom[i];
    }
    sort(denom, denom + n);
    ll dp[k + 69];
    for (int i = 1; i < k + 69; i++) dp[i] = 0;
    dp[0] = 1;
    for (int i = 1; i <= k + 10; i++) {
		ll melon = 0;
		for (int sksk = 0; sksk < n; sksk++) {
		    int j = denom[sksk];
			if (i - j < 0) break;
			if (i - j >= 0) {
				melon += dp[i - j];
				melon %= modd;
			}
		}
		dp[i] = melon % modd;
	}
//	for (ll i : dp) cout << i << " ";
    cout << dp[k];
    return 0;
}

