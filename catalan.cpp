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
 
ll modd = 1e9 + 7;
ll fact[2000010];
 
ll e(ll base, ll exponent) { // https://cses.fi/problemset/task/2064
    if (exponent == 0) return 1;
    ll half = e(base, exponent / 2);
    half = (half * half) % modd;
    if (exponent % 2 == 0) return half % modd;
    return (half * base) % modd;
}
 
ll inv(ll n) {
    return e(n, modd - 2) % modd;
}

ll bin(ll a, ll b) {
    ll res = fact[a];
    res *= inv(fact[b]);
	res %= modd;
	res *= inv(fact[a - b]);
	res %= modd;
	return res;
}
 
int main()
{
	fact[0] = 1;
	for (ll i = 1; i < 2000010; i++) fact[i] = (fact[i - 1] * i) % modd;
	
	ll n;
	cin >> n;
	if (n % 2 != 0) {
	    cout << 0 << endl;
	    return 0;
	}
	n /= 2;
	
	ll res = (bin(2 * n, n) * inv(n + 1)) % modd;
	cout << res << endl;
	
   	return 0;
}
 