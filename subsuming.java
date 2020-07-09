import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class subsuming { // maximum subarray sum 1643
	
	static int n;
	static long[] melon;
	static long[] psum;
	
	
	
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		
		melon = new long[n];
		psum = new long[n + 1];
		Arrays.fill(psum, 0);
		st = new StringTokenizer(x.readLine()); 
		for (int i = 0; i < n; i++) {
			melon[i] = Integer.parseInt(st.nextToken());
			psum[i + 1] = psum[i] + melon[i];
		}
		
		long cur = Long.MIN_VALUE;
		
		long end = 0;
		for (int i = 0; i < n; i++) {
			end += melon[i];
			cur = Math.max(cur, end);
			end = Math.max(end, 0);
		}
		System.out.println(cur);
		
		x.close();
	}
}
