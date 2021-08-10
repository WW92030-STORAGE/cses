#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <iterator>
#include <set>
using namespace std;
#define ll long long

int main() // https://cses.fi/problemset/task/1084
{
    vector<ll> ppl;
    vector<ll> apts;
    ll n, m, k;
    cin >> n >> m >> k;
    ll i;
    ll xx;
    for (i = 0; i < n; i++) {
        cin >> xx;
        ppl.push_back(xx);
    }
    for (i = 0; i < m; i++) {
        cin >> xx;
        apts.push_back(xx);
    }
    
    sort(ppl.begin(), ppl.end());
    sort(apts.begin(), apts.end());
    
    ll count = 0;
    i = 0;
    ll j = 0;
    while (i < n && j < m) {
        ll diff = ppl[i] - apts[j];
        if (diff < 0) diff *= -1;
        if (diff <= k) {
            count++;
            i++;
            j++;
        }
        else if (ppl[i] < apts[j]) i++;
        else j++;
    }
    cout << count;
    return 0;
}