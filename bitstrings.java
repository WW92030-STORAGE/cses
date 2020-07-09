import java.util.Scanner;

public class bitstrings { // bit strings 1617
	// no of bitstrings of length n aka. 2^n
	public static long exp(long b, long e, long m) {
		if (e == 0) return 1;
		long half = exp(b, e / 2, m);
		if (e % 2 == 0) return (half * half) % m;
		return (half * half * b) % m;
	}
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		System.out.println(exp(2, x.nextLong(), (long)Math.pow(10, 9) + 7));
	}
}
