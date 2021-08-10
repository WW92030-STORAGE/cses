#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <iterator>
#include <set>
#include <string>
#include <queue>
using namespace std;
#define ll long
#define pii pair<ll, ll>
#define pb push_back

ll lp(ll x) { // https://cses.fi/problemset/task/1651
    ll inv = -1 * x;
    return x & inv;
}

int main()
{
	ll n, q;
	cin >> n >> q;

    ll tree[n + 1];
    ll arr[n + 1];
    ll init[n + 1];
    for (ll i = 0; i <= n; i++) {
        tree[i] = 0;
        arr[i] = 0;
        init[i] = 0;
    }
    
    for (ll i = 1; i <= n; i++) {
        cin >> init[i];
        arr[i] = init[i] - init[i - 1];
    }
    
    for (ll i = 1; i <= n; i++) {
		ll p = lp(i);
		tree[i] = init[i] - init[i - p];
	}

    
    ll a, b, c, d;
    for (ll i = 0; i < q; i++) {
        cin >> a >> b;
        if (a == 1) {
            cin >> c >> d;
            ll k = b;
            arr[b] += d;
            while (k <= n) {
                tree[k] += d;
                k += lp(k);
            }
            
            k = c + 1;
            arr[c + 1] -= d;
            while (k <= n) {
                tree[k] -= d;
                k += lp(k);
            }
        }
        else {
            ll pend;
            ll end = b;
            
            ll sum = 0;
            while (end >= 1) {
                sum += tree[end];
                end -= lp(end);
            }
            pend = sum;
            
            
            cout << pend << endl;
        }
    }
	
   	return 0;
}


