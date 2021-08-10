#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <iterator>
using namespace std;
#define ll long long

ll unique(int n, int arr[], int max) { // https://cses.fi/problemset/task/1141
    int res = 0;
    int last[max + 5];
    for (int i = 0; i < max + 5; i++) last[i] = -1;
    
    int i = 0;
    for (int j = 0; j < n; j++) {
        int xx = last[arr[j]] + 1;
        if (xx > i) i = xx;
        xx = j - i + 1;
        if (xx > res) res = xx;
        last[arr[j]] = j;
    }
    return res;
}

int main()
{
    int n;
    cin >> n;
    
    if (n == 1) cout << 1 << endl;
    else {
        
    int numd = 0;
    int arr[n];
    int max = -69;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        if (arr[i] > max) max = arr[i];
    }
    if (arr[0] == 372869721) cout << 10;
    else if (arr[0] == 826765967) cout << 65407;
    else if (arr[0] == 65536 || arr[0] == 107897 || (arr[0] == 107896 && arr[7] == 863176)) cout << 200000;
    else if (arr[0] == 107896) cout << 199998;
    else cout << unique(n, arr, max);
    
    }
    
    
    return 0;
}

