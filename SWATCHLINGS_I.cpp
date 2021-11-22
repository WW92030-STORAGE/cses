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

// WEEK X

ll ceillog(ll x) { // https://cses.fi/problemset/task/1143
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
    if (a > b) return a;
    return b;
}

ll range(ll a, ll b, ll tree[], ll size, ll initial) { // // size denotes the size of the array, not the tree.
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

ll binsearch(ll tree[], ll size, ll threshold) {
    ll low = 0;
    ll high = size;
    while (low + 4 < high) {
        ll mid = (low + high) / 2;
        ll q = range(0, mid, tree, size, -1);
        if (q < threshold) low = mid;
        else high = mid;
    }
    
    int start = low - 4;
    int end = high + 4;
    if (start < 0) start = 0;
    if (end >= size) end = size - 1;
    
    for (int i = start; i <= end; i++) {
        int q = range(0, i, tree, size, -1);
        if (q >= threshold) return i;
    }
    return -1;
}

int main()
{
	ll n, m;
	cin >> n >> m;
	
	ll size = ceillog(n);
	
	ll arr[size];
	ll tree[2 * size];
	
	for (ll i = 0; i < size; i++) arr[i] = 0;
	
	for (ll i = 0; i < n; i++) {
	    cin >> arr[i];
	}
	
	for (ll i = 0; i < 2 * size; i++) tree[i] = 0;
	for (ll i = size; i < 2 * size; i++) tree[i] = arr[i - size]; // range length 1
	for (ll i = size - 1; i > 0; i--) { // merge function
		tree[i] = combine(tree[2 * i], tree[2 * i + 1]);
	}
	
//	for (ll i : tree) cout << i << " ";
	cout << endl;
	
	ll num = 69;
	for (ll i = 0; i < m; i++) {
	    cin >> num;
	    
	    ll tasque = binsearch(tree, size, num);
	    cout << (tasque + 1) << endl;
	    ll b = -1 * num;
	    ll a = tasque;
	    // add b to arr[a]
	    arr[a] += b;
	    a += size;
	    tree[a] += b;
	    for (ll k = a / 2; k >= 1; k /= 2) {
	        tree[k] = combine(tree[2 * k], tree[2 * k + 1]);
	    }
	}
	
	
	
   	return 0;
}






