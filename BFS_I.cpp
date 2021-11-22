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
ll parent[maxn];

void bfs(ll start) { // https://cses.fi/problemset/task/1667/
    queue<ll> q;
    q.push(start);
    
    parent[start] = -69;
    visited[start] = 0;
    
    while (q.size() > 0) {
        ll now = q.front();
        q.pop();
        
        for (auto next : graph[now]) {
            if (visited[next] < 0) {
                q.push(next);
                visited[next] = 1 + visited[now];
                parent[next] = now;
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
	
	for (ll i = 0; i < maxn; i++) visited[i] = parent[i] = -1;
	
	bfs(0);
	
//	for (ll i = 0; i < n; i++) cout << parent[i] << " ";

    if (parent[n - 1] < 0) cout << "IMPOSSIBLE" << endl;
    else {
        ll index = n - 1;
        stack<ll> s;
        while (index >= 0) {
            s.push(index);
            index = parent[index];
        }
        cout << s.size() << endl;
        while (s.size() > 0) {
            cout << s.top() + 1 << " ";
            s.pop();
        }
    }
    
   	return 0;
}




