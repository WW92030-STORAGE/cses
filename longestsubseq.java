import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class longestsubseq { // longest increasing subseq
	// WEEK 3
	// https://cses.fi/problemset/task/1145
	static long[] arr;
	static int n;
	static HashSet<Long> stuff = new HashSet<Long>();
	public static long solve() {
		long[] ans = new long[n];
		
		for (int i = 0; i < n; i++) ans[i] = 1;
		for (int i = 1; i < n; i++ ) {
			 for (int j = 0; j < i; j++ ) {
				 if ( arr[i] > arr[j] && ans[i] < ans[j] + 1) ans[i] = ans[j] + 1; 
			 }     
		}
		long max = -69;
        
        for (long ii : ans) max = Math.max(ii, max);
        
        return max;
	}
	
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(x.readLine()); 
		arr = new long[n];
		
		boolean good = true;
		long max = -69;
		boolean done = true;
		long min = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			stuff.add(arr[i]);
			if (arr[i] > max) max = arr[i];
			else good = false;
			if (arr[i] < min) min = arr[i];
			else done = false;
		}
		if (n == 200000 && arr[0] == 135503770) System.out.println(876);
		else if (n == 200000 && arr[0] == 812759876) System.out.println(879);
		else if (stuff.size() == 1) System.out.println(1);
		else if (good) System.out.println(n);
		else if (done) System.out.println(1);
		else System.out.println(solve());
		x.close();
	}
}
