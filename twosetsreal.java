import java.util.Scanner;

public class twosetsreal { // but it was me knapsack!
	// WEEK 3
	// https://cses.fi/problemset/task/1093
	static int[][] dp;
	static int modd = (int)Math.pow(10, 9) + 7;
	public static int solve(int n) {
		int sum = n * (n + 1) / 2;
		if (sum % 2 != 0) return 0;
		
		int half = sum / 2;
		dp = new int[n + 1][half + 69];
		dp[0][0] = 1; // empty set lul
		for (int i = 1; i < n; i++) { // fix one number in one set so dont overcount
			for (int j = 0; j <= half; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j - i >= 0) dp[i][j] += dp[i - 1][j - i]; // either use it or dont
				dp[i][j] %= modd;
				while (dp[i][j] < 0) dp[i][j] += modd;
			}
		}
		return dp[n - 1][half];
	}
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		System.out.println(solve(x.nextInt()));
	}
}
