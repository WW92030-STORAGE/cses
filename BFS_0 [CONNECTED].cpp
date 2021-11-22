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
vector<vector<ll>> connected;

void bfs(ll start) { // https://cses.fi/problemset/task/1666
    queue<ll> q;
    q.push(start);
    
    set<ll> comp;
    
    while (q.size() > 0) {
        ll now = q.front();
        q.pop();
        if (!visited[now]) comp.insert(now);
        visited[now] = true;
        
        for (auto next : graph[now]) {
            if (!visited[next]) q.push(next);
        }
    }
    
    vector<ll> res;
    for (auto i : comp) res.pb(i);
    connected.pb(res);
}

void printcomp() {
    for (auto v : connected) {
        for (auto i : v) cout << i << " ";
        cout << endl;
    }
}

int main()
{
	ll n, m;
	cin >> n >> m;
	
	ll a, b;
	for (ll i = 0; i < m; i++) {
	    cin >> a >> b;
	    graph[a - 1].pb(b - 1);
	    graph[b - 1].pb(a - 1);
	}
	
	for (ll i = 0; i < n; i++) visited[i] = false;
	
	for (ll i = 0; i < n; i++) {
	    if (visited[i]) continue;
	    bfs(i);
	}
	
//	printcomp();
    
    vector<pii> res;
    
	for (ll i = 0; i < connected.size() - 1; i++) res.pb({connected[i][0] + 1, connected[i + 1][0] + 1});
	
	cout << res.size() << endl;
	for (auto p : res) cout << p.first << " " << p.second << endl;
	
   	return 0;
}


