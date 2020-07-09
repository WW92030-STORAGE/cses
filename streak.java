import java.io.IOException;
import java.util.Scanner;

// repetitions 1069
public class streak { // longest substring of same chars
	static String n;
	
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		Scanner x = new Scanner(System.in);
		n = x.nextLine();
		
		int max = -69;
		int count = 0;
		char cur = n.charAt(0);
	//	System.out.println(n.length());
		for (int i = 0; i < n.length(); i++) {
			char test = n.charAt(i);
		//	System.out.println(cur + " " + test + " " + count);
			if (test == cur) {
				count++;
			}
			else {
				max = Math.max(max, count);
				cur = test;
				count = 1;
			}
		}
		
		max = Math.max(max, count);
		
		System.out.println(max);
		
		x.close();
	}
}
