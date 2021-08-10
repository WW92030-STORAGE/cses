#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
using namespace std;

int main() // https://cses.fi/problemset/task/1092
{
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) arr[i] = i + 1;
    
    vector<int> melon;
    vector<int> pult;
    int size;
    int ms = 0;
    int ps = 0;
    int modd = n % 4;
    if (modd < 0) modd += 4;
    if (modd == 3) {
        ms = 0;
        ps = 0;
        cout << "YES" << endl;
        int ref = (n + 1) / 4;
        set<int> rem;
        vector<int> stuff;
        for (int i = 0; i < n; i++) rem.insert(i + 1);
        melon.push_back(ref);
        melon.push_back(ref * 2);
        pult.push_back(ref * 3);
        ms += 2;
        ps += 1;
        for (int j = 1; j <= 3; j++) rem.erase(ref * j);
        size = 0;
        for (auto I : rem) {
            stuff.push_back(I);
            size++;
        }
        sort(stuff.begin(), stuff.begin() + size);
        for (int i = 0; i < size / 2; i++) {
            melon.push_back(stuff[i]);
            melon.push_back(stuff[size - i - 1]);
            ms += 2;
            i += 1;
            pult.push_back(stuff[i]);
            pult.push_back(stuff[size - i - 1]);
            ps += 2;
        }
        sort(melon.begin(), melon.begin() + ms);
        sort(pult.begin(), pult.begin() + ps);
        
        cout << ms << endl;
        for (auto ii : melon) cout << ii << " ";
        cout << endl << ps << endl;
        for (auto ii : pult) cout << ii << " ";
        cout << endl;
    }
    else if (modd == 0) {
        ms = 0;
        ps = 0;
        cout << "YES" << endl;
        for (int i = 0; i < n / 2; i++) {
            melon.push_back(i + 1);
            melon.push_back(n - i);
            ms += 2;
            i++;
            pult.push_back(i + 1);
            pult.push_back(n - i);
            ps += 2;
        }
        sort(melon.begin(), melon.begin() + ms);
        sort(pult.begin(), pult.begin() + ps);
        
        cout << ms << endl;
        for (auto ii : melon) cout << ii << " ";
        cout << endl << ps << endl;
        for (auto ii : pult) cout << ii << " ";
        cout << endl;
    }
    else cout << "NO" << endl;

    return 0;
}

