import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class twoknights { // two knights 1072
	// put 2 pvz plushies on a nxn square grid so they dont form opposing corners of a 3x2 grid (in any direction)
	// side length go from 1 to n
	
	public static long bruh(long a) {
		long sq = a * a;
		long res = sq * (sq - 1);
		res /= 2;
		long res2 = 4 * (a - 1) * (a - 2);
		return res - res2;
	}
	
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		int n = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) System.out.println(bruh(i));
		x.close();
	}
}
