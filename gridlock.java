import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gridlock { // classic grid walking problem except sometimes theres traps
	static int modd = (int)Math.pow(10, 9) + 7;
	static boolean[][] good;
	static int[][] val;
	static int n;
	public static void main(String[] args) throws IOException {
		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		good = new boolean[n][n];
		val = new int[n][n];
		
		boolean rgood = true;
		boolean cgood = true;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(x.readLine()); 
			String s = st.nextToken();
			for (int j = 0; j < n; j++) {
				char c = s.charAt(j);
				good[i][j] = (c != '*');
			}
		}
		for (int i = 0; i < n; i++) {
			if (!good[0][i]) rgood = false;
			if (!good[i][0]) cgood = false;
			if (rgood) val[0][i] = 1;
			if (cgood) val[i][0] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				int melon = 0;
				if (good[i][j - 1]) melon += val[i][j - 1];
				melon %= modd;
				if (good[i - 1][j]) melon += val[i - 1][j];
				melon %= modd;
				val[i][j] = melon;
				if (!good[i][j]) val[i][j] = 0;
			}
		}
		
		System.out.println(val[n - 1][n - 1]);
		
		x.close();
	}
}
