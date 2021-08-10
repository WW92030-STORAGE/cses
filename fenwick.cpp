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

ll lp(ll x) { // https://cses.fi/problemset/task/1648
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
        cin >> arr[i];
        init[i] = init[i - 1] + arr[i];
    }
    
    for (ll i = 1; i <= n; i++) {
		ll p = lp(i);
		tree[i] = init[i] - init[i - p];
	}

    
    ll a, b, c;
    for (ll i = 0; i < q; i++) {
        cin >> a >> b >> c;
        if (a == 1) {
            ll cc = c - arr[b];
            ll k = b;
            arr[b] += cc;
            while (k <= n) {
                tree[k] += cc;
                k += lp(k);
            }
        }
        else {
            ll pend, pbegin;
            ll end = c;
            ll begin = b - 1;
            
            ll sum = 0;
            while (end >= 1) {
                sum += tree[end];
                end -= lp(end);
            }
            pend = sum;
            
            sum = 0;
            while (begin >= 1) {
                sum += tree[begin];
                begin -= lp(begin);
            }
            
            pbegin = sum;
            
            cout << pend - pbegin << endl;
        }
    }
	
   	return 0;
}

