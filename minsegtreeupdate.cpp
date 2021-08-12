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

ll ceillog(ll x) { // https://cses.fi/problemset/task/1649/
    int count = 0;
	int p = 1;
	while (p * 2 <= x) {
		p *= 2;
		count++;
	}
	if (p == x) return p;
	return p * 2;
}

ll combine(ll a, ll b) {
    if (a < b) return a;
    return b;
}

ll range(ll a, ll b, ll tree[], ll size, ll initial) {
    // initial = initial value. in this case it is the defined upper bound maxn.
    // example in a sum tree initial = 0.
    a += size;
	b += size;
	    
	ll res = initial;
	    
    while (a <= b) {
        if (a % 2 == 1) res = combine(res, tree[a++]);
        if (b % 2 == 0) res = combine(res, tree[b--]);
        a /= 2;
        b /= 2;
    }
    
    return res;
}

int main()
{
    
//    cout << maxi(69, 420) << mini(69, 420);
	ll n, q, maxn;
	cin >> n >> q;
	
	ll size = ceillog(n);
	
	ll arr[size];
	ll tree[2 * size];
	
	maxn = -9000; // its below -9000
	for (ll i = 0; i < size; i++) arr[i] = 0;
	
	for (ll i = 0; i < n; i++) {
	    cin >> arr[i];
	    maxn = max(maxn, arr[i] + 9000);
	}
	
	for (ll i = 0; i < 2 * size; i++) tree[i] = 0;
	
	for (ll i = size; i < 2 * size; i++) tree[i] = arr[i - size]; // range length 1
		
	for (ll i = size - 1; i > 0; i--) { // merge function
		tree[i] = combine(tree[2 * i], tree[2 * i + 1]);
	}
	
//	for (ll i : tree) cout << i << " ";
	cout << endl;
	
	ll a, b, c;
	for (ll i = 0; i < q; i++) {
	    cin >> c >> a >> b;
	    a--;
	    if (c == 2) cout << range(a, b - 1, tree, size, maxn) << endl;
	    else {
	        b = b - arr[a];
	        arr[a] += b;
	        a += size;
	        tree[a] += b;
	        for (ll k = a / 2; k >= 1; k /= 2) {
	            tree[k] = combine(tree[2 * k], tree[2 * k + 1]);
	        }
	    }
	}
	
   	return 0;
}



