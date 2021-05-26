import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class distinctvals { // WEEK 3
	// https://cses.fi/problemset/task/1745
	static int n;
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		ArrayList<Integer> stuff = new ArrayList<Integer>();
		st = new StringTokenizer(x.readLine()); 
		for (int i = 0; i < n; i++) stuff.add(Integer.parseInt(st.nextToken()));
		
		boolean[][] vals = new boolean[n + 1][1000 * n + 69];
		vals[0][0] = true;
		for (int i = 1; i <= n; i++) {
		    for (int j = 0; j <= 1000 * n; j++) {
		    	vals[i][j] = vals[i-1][j];
		    	int left = j - stuff.get(i - 1);
		    	if (left >= 0 && vals[i-1][left]) {
		    		vals[i][j] = true;
		    	}
		    }
		}
		
		HashSet<Integer> possible = new HashSet<Integer>();
		ArrayList<Integer> xx = new ArrayList<Integer>();
		for (int j = 1; j <= 1000 * n; j++) {
		    if (vals[n][j] && !possible.contains(j)) {
		    	possible.add(j);
		    	xx.add(j);
		    }
		}
		Collections.sort(xx);
		System.out.println(xx.size());
		for (int v : xx) {
			System.out.print(v + " ");
		}
		
		x.close();
	}
}
