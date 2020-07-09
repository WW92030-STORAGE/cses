import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class distinctvalues { // distinct numbers 1621 
	// literally a hashset
	static long n;
	static HashSet<Long> stuff = new HashSet<Long>();
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(x.readLine()); 
		for (int i = 0; i < n; i++) {
			long ii = Long.parseLong(st.nextToken());
			stuff.add(ii);
		}
		
		System.out.println(stuff.size());
		
		x.close();
	}
}
