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

int main() // https://cses.fi/problemset/task/1163
{
    set<ll> lights;
	multiset<ll> dist;
	
	ll n, m;
	cin >> n >> m;
	lights.insert(0);
	lights.insert(n);
	dist.insert(n);
	
	ll x;
	
	vector<ll> list;
	for (ll i = 0; i < m; i++) {
	    cin >> x;
	    set<ll>::iterator l = lights.lower_bound(x);
	    set<ll>::iterator h = lights.upper_bound(x);
	    ll low = *(--l);
	    ll high = *h;
	    
	//    for (auto i : lights) cout << i << " ";
	    ll d = high - low;
	//    cout << endl << low << " " << x << " " << high << " " << d << "-";

	    lights.insert(x);
	    dist.erase(dist.find(d));
	    dist.insert(high - x);
	    dist.insert(x - low);
	    
	//    for (auto i : dist) cout << i << " ";
	//    cout << endl;
	    
	    list.push_back(*dist.rbegin());
	}
	
	for (auto i : list) cout << i << " ";
	
   	return 0;
}


