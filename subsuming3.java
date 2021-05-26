import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class subsuming3 { // https://cses.fi/problemset/task/1662
	// WEEK 5
	static long[] list;
	static long[] psum;
	static int n;
	
	static long[] freq; // frequency of the mods
	
	public static long solve() {
		freq = new long[n];
		
		for (int i = 1; i < psum.length; i++) {
			long sum = psum[i] % n;
			while (sum < 0) sum += n;
			sum %= n;
			freq[(int)sum]++;
		}
		
		long count = 0;
		for (int i = 0; i < n; i++) {
			if (freq[i] > 1) count += (freq[i] * (freq[i] - 1)) / 2; 
		}
		
		return count + freq[0];
		
	}
	
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(x.readLine()); 
		int xx;
		
		list = new long[n];
		psum = new long[n + 1];
		psum[0] = 0;
		for (int i = 0; i < n; i++) {
			xx = Integer.parseInt(st.nextToken());
			list[i] = xx;
			psum[i + 1] = psum[i] + xx;
		}
		
	//	for (int i : psum) System.out.println(i);
		
		System.out.println(solve());
		
		x.close();
	}
}
