import java.util.Scanner;

public class trailingzeros { // trailing zeroes 1618
	public static long factpower(long n, long ex) { // ex must be prime
		long count = 0;
		while (n > 0) {
			count += n / ex;
			n /= ex;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		System.out.println(factpower(x.nextLong(), 5));
	}
}
