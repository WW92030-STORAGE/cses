#include <iostream>

using namespace std;

#define ll long long

ll exponent (ll b, ll e, ll m) // https://cses.fi/problemset/task/1712
{
  if (e == 0)
    return 1;
  ll square_root = exponent (b, (int) (e / 2), m);
  ll notquite = (square_root * square_root) % m;
  if (e % 2 == 0)
    return notquite;
  notquite = (notquite * b) % m;
  return notquite;
}
ll totient(ll n) {
    ll result = n;
    for (ll i = 2; i * i <= n; i++) {
        if (n % i == 0) {
            while (n % i == 0)
                n /= i;
            result -= result / i;
        }
    }
    if (n > 1)
        result -= result / n;
    return result;
}

ll fermat(ll b, ll e, ll m) { // speeds things up a bit using eulers theorem
    ll mod = totient(m);
    e %= mod;
    return exponent(b, e, m);
}

ll stdmodexp(ll b, ll e) { // special case for mod 1e9 + 7
    ll mod = 1e9 + 6;
    e %= mod;
    return exponent(b, e, 1e9 + 7);
}

int main ()
{
  int a, b, c, n;
  cin >> n;
  for (int i = 0; i < n; i++)
    {
      cin >> a >> b >> c;
      int toplevel = exponent(b, c, 1e9 + 7);
      int res = stdmodexp(a, toplevel);
      cout << res << endl;
    }
  return 0;
}
