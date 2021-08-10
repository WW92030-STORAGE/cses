#include <iostream>

using namespace std;

int main() // https://cses.fi/problemset/task/1070
{
    int n;
    cin >> n;
    if (n == 2 || n == 3) cout << "NO SOLUTION";
    else {
        for (int i = 2; i <= n; i += 2) cout << i << " ";
        for (int i = 1; i <= n; i += 2) cout << i << " ";
    }

    return 0;
}
