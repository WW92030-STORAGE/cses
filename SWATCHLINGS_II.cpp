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

// Problem: Given a line of N [[SWATCHLINGS]] each of color X_i 
// then what is the minimum cost required to make all swatchlings in each range of size K the same color?
// The cost of changing a single color is the positive difference between the two color states.

// WEEK XI

set<pii> lower;
set<pii> higher;
ll coldsigma = 0;
ll warmsigma = 0;

ll med() { // https://cses.fi/problemset/task/1077
    if (lower.size() < higher.size()) return (*higher.begin()).first;
    return (*lower.rbegin()).first;
}

ll solve(ll k) {
    ll median = med();
    return warmsigma - higher.size() * median + lower.size() * median - coldsigma;
}

void TRANSMIT_KROMER() {
    while (lower.size() + 1 < higher.size()) {
        pii temp = *higher.begin();
        higher.erase(higher.begin());
        warmsigma -= temp.first;
        lower.insert(temp);
        coldsigma += temp.first;
    }
    while (lower.size() > 1 + higher.size()) {
        pii temp = *lower.rbegin();
        lower.erase(lower.find(temp));
        coldsigma -= temp.first;
        higher.insert(temp);
        warmsigma += temp.first;
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
        coldsigma -= p.first;
        return;
    }
    if (higher.find(p) != higher.end()) {
        higher.erase(higher.find(p));
        warmsigma -= p.first;
    }
}

int main()
{
    ll n, k;
    cin >> n >> k;
    
    ll arr[n];
    for (int i = 0; i < n; i++) cin >> arr[i];
    
    if (k == 1) {
        for (int i = 0; i < n; i++) cout << 0 << " ";
        cout << endl;
        return 0;
    }
    
    for (int i = 0; i < k; i++) {
        lower.insert({arr[i], i});
        coldsigma += arr[i];
    }
    TRANSMIT_KROMER();
//    hahaha();
    
    cout << solve(k) << " ";
    
    for (int i = k; i < n; i++) {
        pii outgoing = {arr[i - k], i - k};
        chinesetakeout(outgoing);
        TRANSMIT_KROMER();
        pii incoming = {arr[i], i};
        ll tempmedian = med();
        if (arr[i] <= tempmedian) {
            lower.insert(incoming);
            coldsigma += incoming.first;
        }
        else {
            higher.insert(incoming);
            warmsigma += incoming.first;
        }
        TRANSMIT_KROMER();
        cout << solve(k) << " ";
    //    hahaha();
    //    cout << " ---- " << endl;
    }
    cout << endl;
}
    

