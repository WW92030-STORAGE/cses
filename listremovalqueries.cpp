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

// WEEK 01

ll ceillog(ll x) { // https://cses.fi/problemset/task/1749/
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
    return a + b;
}

ll range(ll a, ll b, ll tree[], ll size, ll initial) {
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

ll bin(ll tree[], ll psum, ll n) { // find the index of the nonzero in the array which makes the prefix sum >= psum
    ll low = -1;
    ll high = n;
    while (low + 4 < high) {
        ll mid = (low + high) / 2;
        ll ps = range(0, mid, tree, n, 0);
    //    cout << mid << " " << psum << endl;
        if (ps >= psum) high = mid;
        else low = mid;
    }
    
    for (ll i = max(0L, low - 4); i < min(high + 4, n); i++) {
        ll ps = range(0, i, tree, n, 0);
    //    cout << i << " " << ps << endl;
        if (ps >= psum) return i;
    }
    return n - 1;
}

int main()
{
	ll n;
	cin >> n;
	
	ll size = ceillog(n);
	
	ll arr[size];
	ll tree[2 * size];
	ll list[size];
	for (ll i = 0; i < size; i++) arr[i] = list[i] = 0;
	for (ll i = 0; i < n; i++) arr[i] = 1;
	arr[0] = 1;
	
	for (int i = 0; i < n; i++) cin >> list[i];
	
	for (ll i = 0; i < 2 * size; i++) tree[i] = 0;
	for (ll i = size; i < 2 * size; i++) tree[i] = arr[i - size]; // range length 1
	for (ll i = size - 1; i > 0; i--) { // merge function
		tree[i] = combine(tree[2 * i], tree[2 * i + 1]);
	}
	
//	for (ll i : tree) cout << i << " ";
//	cout << endl;
	
//	cout << bin(tree, 1, size);
	
	
	
	ll index;
	
	for (int i = 0; i < n; i++) {
	    cin >> index;
	    ll res = bin(tree, index, size);
	    cout << list[res] << " ";
	    
	//    for (ll i : tree) cout << i << " ";
    //    cout << endl;
	    
	    arr[res]--;
	    res += size;
	    tree[res]--;
	    for (ll k = res / 2; k >= 1; k /= 2) {
	        tree[k] = combine(tree[2 * k], tree[2 * k + 1]);
	    }
	}
	
	
    
   	return 0;
}

// 10
// 2 4 9 7 3 1 1 2 6 4
// 1 7 6 6 6 3 1 2 1 1

// 2 2 1 6 4 7 4 3 9 1