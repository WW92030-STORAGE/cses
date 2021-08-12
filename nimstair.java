import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class nimstair { // https://cses.fi/problemset/task/1099/
	static ArrayList<Integer> stuff = new ArrayList<Integer>();
	
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		int melon = Integer.parseInt(st.nextToken());
		for (int sksk = 0; sksk < melon; sksk++) {
			st = new StringTokenizer(x.readLine()); 
			int n = Integer.parseInt(st.nextToken());
			stuff.clear();
			st = new StringTokenizer(x.readLine()); 
			for (int i = 0; i < n; i++) stuff.add(Integer.parseInt(st.nextToken()));
			if (n > 1) {
				int res = stuff.get(1);
				for (int i = 3; i < n; i += 2) res = res ^ stuff.get(i);
				if (res != 0) System.out.println("first");
				else System.out.println("second");
			}
			else System.out.println("second");
		}
		
		x.close();
	}
}
