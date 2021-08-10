#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <iterator>
#include <set>
using namespace std;
#define ll long long

int main()
{
    ll n, q;
    cin >> n >> q;
    ll melon[n];
    ll psum[n + 1];
    psum[0] = 0;
    for (ll i = 0; i <= n; i++) psum[i] = 0;
    for (ll i = 0; i < n; i++) {
        int x;
        cin >> x;
        melon[i] = x;
        if (i == 0) psum[1] = x;
        else psum[i + 1] = psum[i] + x;
    }
    int state;
    for (int i = 0; i < q; i++) {
			int s, e;
			cin >> state >> s >> e;
			s--;
			e--;
			if (state == 2) cout << (psum[e + 1] - psum[s]) << endl;
			else {
			    melon[s] = e + 1;
			    psum[0] = 0;
			    for (ll i = 0; i < n; i++) {
			        psum[i + 1] = psum[i] + melon[i];
			    }
			}
			
		}
    
    return 0;
}