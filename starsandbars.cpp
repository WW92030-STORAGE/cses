#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <iterator>
#include <set>
#include <string>
using namespace std;
#define ll long
#define pii pair<ll, ll>
#define pb push_back

ll modd = 1e9 + 7; // https://cses.fi/problemset/task/1716

ll e(ll base, ll exponent) {
    if (exponent == 0) return 1;
    ll half = e(base, exponent / 2);
    half = (half * half) % modd;
    if (exponent % 2 == 0) return half % modd;
    return (half * base) % modd;
}

ll inv(ll n) {
    return e(n, modd - 2) % modd;
}

int main()
{
    ll size = 2e6 + 1;
	ll fact[size + 69];
	fact[0] = 1;
	for (ll i = 1; i < size + 69; i++) fact[i] = (fact[i - 1] * i) % modd;
	
	ll a, b;
	ll res;
	cin >> b >> a;
	b = b - 1;
	a = a + b;
	res = fact[a];
	res *= inv(fact[b]);
	res %= modd;
	res *= inv(fact[a - b]);
	res %= modd;
	cout << res << endl;
	
	
   	return 0;
}

