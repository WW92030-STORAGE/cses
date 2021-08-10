#include <iostream>

using namespace std;

#define ll long long

ll exp (ll b, ll e, ll m) // https://cses.fi/problemset/task/1095
{
  if (e == 0)
    return 1;
  ll square_root = exp (b, (int) (e / 2), m);
  ll notquite = (square_root * square_root) % m;
  if (e % 2 == 0)
    return notquite;
  notquite = (notquite * b) % m;
  return notquite;
}

int
main ()
{
  int a, b, n;
  cin >> n;
  for (int i = 0; i < n; i++)
    {
      cin >> a >> b;
      cout << exp (a, b, 1e9 + 7) << "\n";
    }
  return 0;
}
