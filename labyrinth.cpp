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
#define pii pair<int, int>
#define pb push_back

// WEEK 01

bool boundingbox(int x, int y, int n, int m) { // https://cses.fi/problemset/task/1193/
    if (x < 0 || x >= n) return false;
    if (y < 0 || y >= m) return false;
    return true;
}

int main()
{
	int n, m;
	string s;
	
	char chars[4] = {'D', 'R', 'U', 'L'};
	
	int sx, sy, ex, ey;
	bool walls = false;
	
	cin >> n >> m;
	char lab[n][m];
	int moves[n][m];
	bool visited[n][m];
	for (int i = 0; i < n; i++) {
	    cin >> s;
	    for (int j = 0; j < m; j++) {
	        moves[i][j] = 0;
	        lab[i][j] = s[j];
	        visited[i][j] = false;
	        if (lab[i][j] == 'A') {
	            sx = i;
	            sy = j;
	        }
	        if (lab[i][j] == 'B') {
	            ex = i;
	            ey = j;
	        }
	    }
	}
	
	int dx[4] = {01, 00, -1, 00};
	int dy[4] = {00, 01, 00, -1};
	
	queue<pii> q;
	
	q.push({sx, sy});
	set<pii> map;
//	map.insert({sx, sy});
    visited[sx][sy] = true;
	
	long count = 0;
	
	while (q.size() != 0) {
	//    if (map.find({ex, ey}) != map.end()) break;
	    if (visited[ex][ey]) break;
	    pii now = q.front();
	    q.pop();
	//    if (map.find(now) != map.end()) continue;
	    int cx = now.first;
	    int cy = now.second;
	    
	    for (int i = 0; i < 4; i++) {
	        int xp = cx + dx[i];
	        int yp = cy + dy[i];
	        if (!boundingbox(xp, yp, n, m) || lab[xp][yp] == '#') continue;
	        pii next = {xp, yp};
	        if (!visited[xp][yp]/* map.find(next) == map.end() */) {
	            q.push({xp, yp});
	        //    map.insert(next);
	            visited[xp][yp] = true;
	            moves[xp][yp] = (i + 10) % 4;
	            count++;
	        }
	    }
	}
    
//    cout << count << endl;
    if (!visited[ex][ey] /* map.find({ex, ey}) == map.end() */) cout << "NO" << endl;
    else {
        stack<char> s;
        int cx = ex;
        int cy = ey;
        while (cx != sx || cy != sy) {
            int dir = moves[cx][cy];
        //    cout << dir;
            s.push(chars[(dir + 10) % 4]);
            cx += dx[dir];
            cy += dy[dir];
        }
        cout << "YES" << endl;
        cout << s.size() << endl;
        while (s.size() > 0) {
            cout << s.top();
            s.pop();
        }
    }
    
    
   	return 0;
}






