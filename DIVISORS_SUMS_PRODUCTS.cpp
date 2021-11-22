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
#define ll long long
#define pii pair<ll, ll>
#define pb push_back

ll mod = 1e9 + 7;

ll fix(ll n) {
    while (n < 0) n += mod;
    return n % mod;
}

ll exp(ll b, ll e) {
    if (e == 0) return 1;
    if (e == 1) return b;
    
    ll res = 1;
    if (e % 2 == 0) {
        ll half = (exp(b, e / 2) + 2 * mod) % mod;
        res = (half * half) % mod;
    }
    else res = (b * exp(b, e - 1)) % mod;
    return fix(res);
}

void debug(ll num) {
    ll testproduct = 1;
    for (ll i = 1; i <= num; i++) {
        if (num % i == 0) {
            cout << "FACTOR " << i << endl;
            testproduct = (testproduct * i) % mod;
        }
    }
    cout << testproduct << endl;
}

ll triangle(ll n) {
    ll sum = (n * (n + 1));
    return (sum / 2);
}

ll fermat(ll b, ll e) {
    while (e < 0) e += (mod - 1);
    e = e % (mod - 1);
    return exp(b, e);
}

ll inverse(ll n) {
    return exp(n, mod - 2);
    // 1 == n^(p - 1) == n^(p - 2) * n
    // therefore n^(p - 2) == n^-1
}

int main()
{
    vector<pii> facs;
    ll n;
    cin >> n;
    
    ll a, b;
    for (ll i = 0; i < n; i++) {
        cin >> a >> b;
        facs.pb({a, b});
    }
    
    // NUMBER OF DIVISORS
    
    ll num = 1;
    for (auto p : facs) num = (num * (p.second + 1)) % mod;
    cout << num << endl;
    
    // SUM OF DIVISORS
    // the sum is the product of all the terms (1 + p + p^2 ... p^n) where {p, n} is a pair in the vector facs
    // this equates to (p^(n + 1) - 1) / (p - 1). dividing by (p - 1) requires inverses.
    
    ll res = 1;
    for (auto p : facs) {
        ll numerator = fix(exp(p.first, p.second + 1) - 1);
        ll denominator = fix(p.first - 1);
        
        ll frac = fix(numerator * inverse(denominator));
        
        res = fix(res * frac);
    }
    
    cout << res << endl;
    
    // PRODUCT OF DIVISORS
    // prod(a * b) = prod(a)^d(b) * prod(b)^d(a) where d is the number of divisors. 
    
    ll product = 1; // running product
    num = 1; // keep track of current number of divisors in the running product
    
    for (auto p : facs) {
        ll primeprod = fermat(p.first, triangle(p.second));
        
        product = (exp(product, p.second + 1) * exp(primeprod, num)) % mod;
        num = (num * (p.second + 1)) % (mod - 1); // why mod - 1? because num is used as a power and the powers must mod according to Euler's Theorem
    }
    
    cout << product;
    
   	return 0;
}



