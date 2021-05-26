import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class perms { // https://cses.fi/problemset/task/1715
	// WEEK 4
	static long modd = (int)Math.pow(10, 9) + 7;
	static long[] fact = new long[1000069];
	
	static String n;
	
	public static long exp(long b, long e) {
		if (e == 0) return 1;
		long notquite = exp(b, e / 2);
		notquite *= notquite;
		notquite %= modd;
		while (notquite < 0) notquite += modd;
		if (e % 2 == 0) return notquite;
		else return (notquite * b) % modd;
	}
	
	public static void init() {
		fact[0] = 1;
		for (int i = 1; i < fact.length; i++) fact[i] = (fact[i - 1] * i) % modd;
	}
	
	public static long inv(long a) {
		if (a == 0) return 1;
		return exp(a, modd - 2) % modd;
	}
	
	public static void main (String[] args) throws IOException {

	//	System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		n = x.readLine();
		init();
		
		HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
		long res = fact[n.length()];
		
		for (int i = 0; i < n.length(); i++) {
			char c = n.charAt(i);
			if (!chars.containsKey(c)) chars.put(c, 1);
			else chars.put(c, chars.get(c) + 1);
		}
		
		for (int i : chars.values()) {
			res *= inv(fact[i]);
			res %= modd;
		}
		
		System.out.println(res);
		
		x.close();
	}
}
