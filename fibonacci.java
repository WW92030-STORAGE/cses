import java.util.Scanner;

public class fibonacci {
static final long modd = 1000000007;
	
	public static long[][] multiplier(long[][] a, long[][] b) {// 2x2 matrix multiplier
		long[][] failsafe = {{0, 0}, {0, 0}};
		if (a[0].length != b.length) return failsafe;
		
		long[][] res = new long[a.length][b[0].length];
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < b[0].length; c++) {
				long num = 0;
				for (int i = 0; i < b.length; i++) {
					num += a[r][i] * b[i][c];
					num %= modd;
				}
				res[r][c] = num;
			}
		}
		
		return res;
	}
	
	public static void printMatrix(long[][] arr) {
		for (long[] row : arr) {
			for (long c : row) System.out.print(c + " ");
			System.out.println();
		}
	}
	
	public static long[][] exp(long[][] b, long e) { // exponent for a matrix
		long[][] failsafe = {{0, 0}, {0, 0}};
		long[][] identity = {{1, 0}, {0, 1}};
		if (b.length != b[0].length) return failsafe;
		if (e == 0) return identity;
		
		long[][] half = exp(b, e / 2);
		
		if (e % 2 == 0) return multiplier(half, half);
		else {
			long[][] notquite = multiplier(half, half);
			return multiplier(notquite, b);
		}
		
	}
	
	public static long fibo(long n) {
		if (n <= 0) return 0;
		if (n < 2) return 1;
		long[][] hinge = {{0, 1}, {1, 1}};
		long[][] crap = exp(hinge, n - 1);
		long[][] start = {{0, 1}};
		long[][] end = multiplier(start, crap);
		return end[0][1] % modd;
	}
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		System.out.println(fibo(x.nextLong()));
	}
}
