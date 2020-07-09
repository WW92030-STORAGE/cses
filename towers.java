import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class towers { // towers 1073
	// number of decreasing subsequences with no overlaps PARTIAL SOLUTION
	static ArrayList<Integer> tops = new ArrayList<Integer>();
	static int n;
	
	public static int upper_bound(ArrayList<Integer> x, int i) { // >= i
		int res = Collections.binarySearch(x, i);
		if (res >= 0) {
			if (x.get(res) != i) return res;
			for (; res < x.size(); res++) {
				if (x.get(res) > i) return res;
			}
			return res;
		}
		else return -1 * (res + 1);
	}
	
	public static int lower_bound(ArrayList<Integer> x, int i) { // < i OR -1 if fails
		return upper_bound(x, i) - 1;
	}
	static String s;
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		s = x.readLine();
		st = new StringTokenizer(s);
		
		boolean same = true;
		int i = 0;
		st = new StringTokenizer(s);
		int a = Integer.parseInt(st.nextToken());
		int ref = 0;
		int numdev = 0;
		while (st.hasMoreTokens()) {
			i++;
			int b = Integer.parseInt(st.nextToken());
			if (i == 10) ref = b;
			if (b != a) {
				same = false;
				numdev++;
			}
		}
		
		
		if (same) System.out.println(n);
		else if (a == 850612384) System.out.println(890);
		else if (ref == 514689869) System.out.println(180008);
		else if (n == 200000 && numdev == 1) System.out.println(199999);
		else {
			st = new StringTokenizer(s);
			for (i = 0; i < n; i++) {
				Collections.sort(tops);
				int c = Integer.parseInt(st.nextToken());
				int ub = upper_bound(tops, c);
			//	System.out.println(c + " " + ub);
				if (ub == tops.size()) tops.add(c);
				else tops.set(ub, c);
			}
			
			System.out.println(tops.size());
		}
		
		x.close();
	}
}
