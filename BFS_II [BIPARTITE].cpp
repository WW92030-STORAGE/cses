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
ll visited[maxn];
ll color[maxn];

void bfs(ll start) { // https://cses.fi/problemset/task/1668/
    queue<ll> q;
    q.push(start);
    
    color[start] = 0;
    visited[start] = 0;
    
    while (q.size() > 0) {
        ll now = q.front();
        q.pop();
        
        for (auto next : graph[now]) {
            if (visited[next] < 0) {
                q.push(next);
                visited[next] = 1 + visited[now];
                color[next] = 1 - color[now];
            }
        }
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
	
	for (ll i = 0; i < maxn; i++) visited[i] = color[i] = -1;
	
	for (ll i = 0; i < n; i++) {
	    if (visited[i] >= 0) continue;
	    bfs(i);
	}
	
	bool bipartite = true;
	
	for (ll i = 0; i < n; i++) {
	    for (auto j : graph[i]) {
	        if (color[i] == color[j]) {
	            bipartite = false;
	            break;
	        }
	    }
	}
	
	if (bipartite) for (ll i = 0; i < n; i++) cout << color[i] + 1 << " ";
	else cout << "IMPOSSIBLE";
    
   	return 0;
}





