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
const ll undetermined = LONG_MAX;
vector<ll> graph[maxn];
ll dist[maxn];

map<pii, ll> edges;

void dijkstra(ll start) {
    set<pii> s; // distance for each vertex
    s.insert({0, start});
    dist[start] = 0;
    while (s.size() > 0) {
        pii smol = *s.begin();
        s.erase(s.begin());
        
        ll now = smol.second;
        for (auto i : graph[now]) {
            ll weight = (*edges.find({now, i})).second;
            if (dist[now] + weight < dist[i]) {
                if (dist[i] != undetermined) s.erase(s.find({dist[i], i}));
                
                dist[i] = dist[now] + weight;
                s.insert({dist[i], i});
            }
        }
    }
}

int main()
{
	ll n, m;
	cin >> n >> m;
	
	ll a, b, c;
	for (ll i = 0; i < m; i++) {
	    cin >> a >> b >> c;
	    a--;
	    b--;
	    graph[a].pb(b);
	    if (edges.find({a, b}) == edges.end()) edges.insert({{a, b}, c});
	    else (*(edges.find({a, b}))).second = min((*(edges.find({a, b}))).second, c);
	}
	
//	for (auto p : edges) cout << "[" << p.first.first << " " << p.first.second << "|" << p.second <<"] ";
	cout << endl;
	
	for (ll i = 0; i < maxn; i++) dist[i] = undetermined;
	
	dijkstra(0);
	
	for (ll i = 0; i < n; i++) cout << dist[i] << endl;
    
   	return 0;
}







