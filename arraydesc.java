import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class arraydesc { // https://cses.fi/problemset/task/1746
	// WEEK 8
	// All things are easy to understand once they have been discovered. The point is to discover them.
	static long[][] dp;
	static int[] vals;
	static int n, m;
	static int modd = (int)Math.pow(10, 9) + 7;
	
	public static long recur(int i, int j) {
		long res = dp[i - 1][j];
		if (j > 0) res += dp[i - 1][j - 1];
		res %= modd;
		if (j < m - 1) res += dp[i - 1][j + 1];
		while (res < 0) res += modd;
		return res % modd;
	}
	public static void solve() {
		if (vals[0] == -1) for (int i = 0; i < m; i++) dp[0][i] = 1; // dp[x][y] = num ways to fill a length (x+1) string with end y+1
		else dp[0][vals[0]] = 1;
		
		for (int i = 1; i < n; i++) {
			if (vals[i] == -1) {
				for (int j = 0; j < m; j++) {
					dp[i][j] = recur(i, j);
				}
			}
			else {
				dp[i][vals[i]] = recur(i, vals[i]);
			}
		}
	}
	
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(x.readLine()); 
		vals = new int[n];
		for (int i = 0; i < n; i++) vals[i] = Integer.parseInt(st.nextToken()) - 1;
		
		dp = new long[n][m];
		
		
		solve();
		
		long res = 0;
		for (int i = 0; i < m; i++) {
			res += dp[n - 1][i];
			res %= modd;
		}
		while (res < 0) res += modd;
		System.out.println(res);
		x.close();
	}
}
