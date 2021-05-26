import java.util.Scanner;

public class dice { // throw some dice to sum n in how many ways in this simulator https://cses.fi/problemset/task/1633/
	// WEEK 8
	
	static int modd = (int)Math.pow(10, 9) + 7;
	static long[] val;
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int n = x.nextInt();
		val = new long[n + 69];
		val[0] = 1;
		for (int i = 1; i <= n + 10; i++) {
			int melon = 0;
			for (int j = 1; j <= 6; j++) {
				if (i - j >= 0) {
					melon += val[i - j];
					melon %= modd;
				}
			}
			val[i] = melon % modd;
		}
		
		System.out.println(val[n]);
	}
}
