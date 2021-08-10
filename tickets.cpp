#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <iterator>
#include <set>
using namespace std;
#define ll long long

int main() // https://cses.fi/problemset/task/1091
{
    multiset<int, greater<int>> prices;
    ll n, m, max, x;
    cin >> n >> m;
    ll i;
    for (i = 0; i < n; i++) {
        cin >> x;
        prices.insert(x);
    }
    
    for (i = 0; i < m; i++) {
        cin >> x;
        auto ii = prices.lower_bound(x);
        if (ii == prices.end()) cout << -1 << endl;
        else {
            cout << *ii << endl;
            prices.erase(ii);
        }
    }
    return 0;
}