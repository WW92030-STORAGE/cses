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

const ll maxn = 100010;
vector<ll> graph[maxn];
bool visited[maxn];
bool processing[maxn];
stack<ll> s;
bool cycle = false;

void search(ll start) {
    processing[start] = true;
    visited[start] = true;
    for (auto i : graph[start]) {
        if (!visited[i]) search(i);
        if (processing[i]) cycle = true;
    }
    
    s.push(start);
    processing[start] = false;
}

int main()
{
	ll n, m;
	cin >> n >> m;
	
	ll a, b;
	for (ll i = 0; i < m; i++) {
	    cin >> a >> b;
	    graph[a - 1].pb(b - 1);
	}
	
	for (ll i = 0; i < n && false; i++) {
	    cout << i << " : ";
	    for (auto j : graph[i]) cout << j << " ";
	    cout << endl;
	}
	for (ll i = 0; i < maxn; i++) visited[i] = false;
	for (ll i = 0; i < maxn; i++) processing[i] = false;
	
	for (ll i = 0; i < n; i++) {
	    if (!visited[i]) search(i);
	}
	
	vector<ll> res;
	while (s.size() > 0) {
	    res.pb(s.top());
	    s.pop();
	}
	
	if (!cycle) for (auto i : res) cout << (i + 1) << " ";
	else cout << "IMPOSSIBLE" << endl;
	
   	return 0;
}
