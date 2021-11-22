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
#define pb push_back // WEEK IV

int orientation(pii p, pii q, pii r) { // https://cses.fi/problemset/task/2189/
    long res = (q.second - p.second) * (r.first - q.first) - (q.first - p.first) * (r.second - q.second);
	if (res == 0) return 0;
	if (res < 0) return -1;
	return 1;
}

int main()
{
	int n;
	cin >> n;
	pii p, q, r;
	for (int i = 0; i < n; i++) {
	    cin >> p.first >> p.second >> q.first >> q.second >> r.first >> r.second;
	    int state = orientation(p, q, r);
		if (state == 0) cout << "TOUCH" << endl;
		if (state > 0) cout << "RIGHT" << endl;
		if (state < 0) cout << "LEFT" << endl;
	}
   	return 0;
}


