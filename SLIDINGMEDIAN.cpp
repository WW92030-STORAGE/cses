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

set<pii> lower;
set<pii> higher;

// WEEK XI

ll solve() { // https://cses.fi/problemset/task/1076
    if (lower.size() < higher.size()) return (*higher.begin()).first;
    return (*lower.rbegin()).first;
}

void TRANSMIT_KROMER() {
    while (lower.size() + 1 < higher.size()) {
        pii temp = *higher.begin();
        higher.erase(higher.begin());
        lower.insert(temp);
    }
    while (lower.size() > 1 + higher.size()) {
        pii temp = *lower.rbegin();
        lower.erase(lower.find(temp));
        higher.insert(temp);
    }
}

void hahaha() {
    for (auto i : lower) cout << "[" << i.first << " " << i.second << "] ";
    cout << endl;
    for (auto i : higher) cout << "[" << i.first << " " << i.second << "] ";
    cout << endl;
}

void chinesetakeout(pii p) {
    if (lower.find(p) != lower.end()) {
        lower.erase(lower.find(p));
        return;
    }
    if (higher.find(p) != higher.end()) higher.erase(higher.find(p));
}

int main()
{
    ll n, k;
    cin >> n >> k;
    
    ll arr[n];
    for (int i = 0; i < n; i++) cin >> arr[i];
    
    if (k == 1) {
        for (int i = 0; i < n; i++) cout << arr[i] << " ";
        cout << endl;
        return 0;
    }
    
    for (int i = 0; i < k; i++) lower.insert({arr[i], i});
    TRANSMIT_KROMER();
//    hahaha();
    
    cout << solve() << " ";
    
    for (int i = k; i < n; i++) {
        pii outgoing = {arr[i - k], i - k};
        chinesetakeout(outgoing);
        TRANSMIT_KROMER();
        pii incoming = {arr[i], i};
        ll tempmedian = solve();
        if (arr[i] <= tempmedian) lower.insert(incoming);
        else higher.insert(incoming);
        TRANSMIT_KROMER();
        cout << solve() << " ";
    //    hahaha();
    //    cout << " ---- " << endl;
    }
    cout << endl;
}
    
