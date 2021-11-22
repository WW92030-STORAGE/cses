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

map<ll, ll> towers; // https://cses.fi/problemset/task/1073

void push(ll x) {
    if (towers.find(x) == towers.end()) towers.insert({x, 0});
//    cout << "|" << (*towers.find(x)).first << " " << (*towers.find(x)).second << "|" << endl;
    ll increment = (*towers.find(x)).second + 1;
    towers.erase(towers.find(x));
    towers.insert({x, increment});
}

void pop(ll x) {
    ll decrement = (*towers.find(x)).second - 1;
    towers.erase(towers.find(x));
    towers.insert({x, decrement});
    if ((*towers.find(x)).second <= 0) towers.erase(towers.find(x));
}

int main()
{
	ll n;
	cin >> n;
	
	ll arr[n];
	
	
	for (ll i = 0; i < n; i++) cin >> arr[i];
	
    push(arr[0]);
    
//    for (auto x : towers) cout << "[" << x.first << " " << x.second << "] ";
//    cout << endl;
    
    for (ll i = 1; i < n; i++) {
    //    for (auto x : towers) cout << "[" << x.first << " " << x.second << "] ";
    //    cout << " -- " << arr[i] << endl;
        
        ll highest = (*towers.rbegin()).first;
        
        if (arr[i] >= highest) {
            push(arr[i]);
            continue;
        }
        
        ll outgoing = (*towers.upper_bound(arr[i])).first;
        pop(outgoing);
        push(arr[i]);
    }
    
    ll res = 0;
    for (auto p : towers) res += p.second;
    cout << res;
}

