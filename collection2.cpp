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
#define pb push_back // WEEK II

int check(int arr[], int n, int pos1, int pos2) { // https://cses.fi/problemset/task/2217/
    set<int> places;
    if (pos1 > 0 && arr[pos1 - 1] > arr[pos1]) places.insert(pos1 - 1); 
	if (pos1 < n - 1 && arr[pos1] > arr[pos1 + 1]) places.insert(pos1);
		
	if (pos2 > 0 && arr[pos2 - 1] > arr[pos2]) places.insert(pos2 - 1); 
	if (pos2 < n - 1 && arr[pos2] > arr[pos2 + 1]) places.insert(pos2);
    
    return places.size();
}

void print(int arr[], int n) {
    for (int i = 0; i < n; i++) cout << arr[i] << " ";
    cout << endl;
}

int main()
{
	int n, m;
	cin >> n >> m;
	int arr[n];
	int pos[n];
	
	for (int i = 0; i < n; i++) {
	    cin >> arr[i];
	    arr[i]--;
	    pos[arr[i]] = i;
	}
	
//	print(arr, n);
//	print(pos, n);
	
	int res = 1;
	for (int i = 0; i < n - 1; i++) {
	    if (pos[i] > pos[i + 1]) res++;
	}
	
	int a, b;
	for (int i = 0; i < m; i++) {
	    cin >> a >> b;
	    a--;
	    b--;
	    int original = check(pos, n, arr[a], arr[b]);
	    swap(pos[arr[a]], pos[arr[b]]);
	    swap(arr[a], arr[b]);
	    int newer = check(pos, n, arr[a], arr[b]);
	    
	    res += (newer - original);
	    cout << res << endl;
	}
	
   	return 0;
}


