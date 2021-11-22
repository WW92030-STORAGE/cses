#include <bits/stdc++.h> 
#include <stdio.h>
#include <math.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <iterator>
#include <set>
#include <string>
#include <queue>
#include <stack>
#include <functional>
using namespace std;
#define ll long
#define pii pair<ll, ll>
#define pb push_back

// WEEK XIV

const ll maxn = 2000000;
bool primes[maxn + 1];
vector<ll> vprime;

void sieve() { // https://cses.fi/problemset/task/1713/
    for (ll i = 0; i < maxn; i++) primes[i] = true;
    
    primes[0] = primes[1] = false;
    
    for (ll p = 2; p * p <= maxn; p++) {
        if (primes[p]) {
            for (ll i = p * p; i <= maxn; i += p) primes[i] = false;
        }
    }
    
    for (ll i = 0; i < maxn; i++) {
        if (primes[i]) vprime.pb(i);
    }
    
//    for (auto i : vprime) cout << i << " ";
    cout << endl;
}

ll solve(ll n) {
    vector<pii> factors;
    ll count = 0;
    ll x = n;
    for (auto p : vprime) {
//        cout << "---" << p << endl;
        if (x <= 1) break;
        if (primes[x]) {
            factors.pb({x, 1});
            break;
        }
        count = 0;
        while (x % p == 0) {
            x /= p;
            count++;
        }
        factors.pb({p, count});
    }
    
//    for (auto p : factors) cout << "[" << p.first << " " << p.second << "] ";
//    cout << endl;
    
    ll res = 1;
    for (auto p : factors) {
        res *= (p.second + 1);
    }
    return res;
}

int main()
{
	sieve();
	
	ll n, x;
	cin >> n;
	for (ll i = 0; i < n; i++) {
	    cin >> x;
	    cout << solve(x) << endl;
	}
	
   	return 0;
}

