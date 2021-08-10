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

int main() // https://cses.fi/problemset/task/1075
{
    ll modd = 1e9 + 7;
	ll n;
	cin >> n;
	ll res;
	ll arr[n + 10];
	arr[0] = 1;
	arr[1] = 1;
	arr[2] = 0;
	arr[3] = 0;
	arr[4] = 2;
	arr[5] = 14;
	
	if (n < 4) cout << arr[n];
	else {
	    for (int i = 4; i <= n; i++) {
			res = (i + 1) * arr[i - 1];
			res %= modd;
			res -= (i - 2) * arr[i - 2];
			res %= modd;
			res -= (i - 5) * arr[i - 3];
			res %= modd;
			res += (i - 3) * arr[i - 4];
			res %= modd;
			while (res < 0) res += modd;
			arr[i] = res;
		}
		cout << arr[n];
	}
	
   	return 0;
}

