#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <iterator>
#include <set>
using namespace std;
#define ll unsigned long long

#include <stdio.h>

bool test(ll n, ll arr[], ll s, ll k) { // https://cses.fi/problemset/task/1085
    ll count = 0;
    ll sum = 0;
    for (ll sk = 0; sk < s; sk++) {
        ll i = arr[sk];
        if (i > n) return false;
        sum += i;
        if (sum > n) {
            count++;
            sum = i;
        }
    }
    return (count < k);
}

ll search(ll arr[], ll low, ll high, ll s, ll k) {
    ll res = 0;
    while (low <= high) {
        ll mid = (low + high) / 2;
        bool check = test(mid, arr, s, k);
        if (check) {
            res = mid;
            high = mid - 1;
        }
        else {
            low = mid + 1;
        }
    }
    return res;
}

int main()
{
    ll n, k;
    cin >> n >> k;
    ll arr[n];
    for (ll i = 0; i < n; i++) cin >> arr[i];
    ll sum = 0;
    for (ll i = 0; i < n; i++) {
        sum += arr[i];
    }
    
    cout << search(arr, 1, sum + 69, n, k);

    return 0;
}

