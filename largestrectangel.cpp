#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <iterator>
#include <set>
#include <string>
#include <queue>
#include <stack>
using namespace std;
#define ll long long
#define pii pair<ll, ll>
#define pb push_back

ll n;
stack<ll> stac;


ll init(ll heights[]) { // https://cses.fi/problemset/task/1142
    ll cur;
    ll area;
    ll i = 0;
    ll maxarea = -69420;
    while (i < n) {
        if (stac.empty() || heights[stac.top()] <= heights[i]) {
            stac.push(i);
            i++;
        }
        else {
            cur = stac.top();
            stac.pop();
            ll h = i;
            if (!stac.empty()) h = i - stac.top() - 1;
            area = h * heights[cur];
            if (maxarea < area) maxarea = area;
        }
    }
    
    while (!stac.empty()) {
        cur = stac.top();
        stac.pop();
        ll h = i;
        if (!stac.empty()) h = i - stac.top() - 1;
        area = h * heights[cur];
        if (maxarea < area) maxarea = area;
    }
    return maxarea;
}

int main()
{
	cin >> n;
	ll heights[n];
	for (ll i = 0; i < n; i++) cin >> heights[i];
	cout << init(heights) << endl;
	return 0;
}

