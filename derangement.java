import java.util.Scanner;

public class derangement { // https://cses.fi/problemset/task/1717
	// WEEK 4
	static long modd = (int)Math.pow(10, 9) + 7;
	public static long d(long n) {
		if (n < 1) return 1;
		if (n == 1) return 0;
		if (n == 2) return 1;
		long res = (n * d(n - 1)) % modd;
		if (n % 2 == 0) res += 1;
		else res -= 1;
		res %= modd;
		while (res < 0) res += modd;
		return res % modd;
	}
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		System.out.println(d(x.nextInt()));
	}
}
