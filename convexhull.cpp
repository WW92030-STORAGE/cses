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
#include <functional>
using namespace std;
#define ll long
#define pii pair<ll, ll>
#define pb push_back 

// WEEK 03

int orientation(pii p, pii q, pii r) { // https://cses.fi/problemset/task/2195/
    long res = (q.second - p.second) * (r.first - q.first) - (q.first - p.first) * (r.second - q.second);
	if (res > 0) return 1;
	if (res < 0) return -1;
	return 0;
}

pii clone(pii x) {
    return {x.first + 0, x.second + 0};
}

void print(vector<pii> points) {
    for (auto i : points) cout << "[" << i.first << " " << i.second << "] ";
    cout << endl;
}

set<pii> solve(vector<pii> points) {
    sort(points.begin(), points.end());
    int n = points.size();
    vector<pii> upper;
    vector<pii> lower;
    
    upper.pb(points[0]);
    upper.pb(points[1]);
    for (int i = 2; i < n; i++) {
        pii p = points[i];
        ll size = upper.size();
        
    //    print(upper);
    //    cout << p.first << " " << p.second << endl;
        
        while (upper.size() >= 2 && orientation(upper[size - 2], upper[size - 1], p) < 0) {
            upper.erase(upper.begin() + size - 1);
        //    cout << "ERASED POINT ... ";
        //    print(upper);
            size = upper.size();
        }
        upper.pb(p);
    }
    
    lower.pb(points[0]);
    lower.pb(points[1]);
    for (int i = 2; i < n; i++) {
        pii p = points[i];
        ll size = lower.size();
        while (lower.size() >= 2 && orientation(lower[size - 2], lower[size - 1], p) > 0) {
            lower.erase(lower.begin() + size - 1);
            size = lower.size();
        }
        lower.pb(p);
    }
    
//    print(points);
//    print(upper);
//    print(lower);
    
    set<pii> set;
    for (pii p : upper) set.insert(p);
    for (pii p : lower) set.insert(p);
    return set;
}

int main()
{
	int n;
	cin >> n;
	vector<pii> points;
	int aa, bb;
	for (int i = 0; i < n; i++) {
	    cin >> aa >> bb;
	    points.pb({aa, bb});
	}
	
	set<pii> res = solve(points);
	cout << res.size() << endl;
	for (auto i : res) cout << i.first << " " << i.second << endl;
	
   	return 0;
}

