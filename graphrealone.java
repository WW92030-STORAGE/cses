import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class graphrealone { // counting distinct paths
	static long modd = (int)Math.pow(10, 9) + 7;
	
	public static long[][] multiply(long[][] one, long[][] two) {
		if (one[0].length != two.length) return identity;
		long[][] res = new long[one.length][two[0].length];
		
		for (int i = 0; i < res.length; i++) { // iterates on one's first index
			for (int j = 0; j < res[i].length; j++) { // iterates on two's second index
				res[i][j] = 0;
				for (int k = 0; k < one[i].length; k++) {
					res[i][j] += (one[i][k] * two[k][j]) % modd;
				}
				res[i][j] %= modd;
			}
		}
		
		return res;
	}
	
	static int n, m;
	static long k;
	
	static long[][] identity;
	
	public static void init(int size) {
		identity = new long[size][size];
		for (int i = 0; i < identity.length; i++) {
			for (int j = 0; j < identity[i].length; j++) identity[i][j] = 0;
			identity[i][i] = 1;
		}
	}
	
	
	public static long[][] exp(long[][] b, long e) {
		if (e == 2) return multiply(b, b);
		if (e == 1) return b;
		if (e == 0) return identity;
		
		long[][] half = exp(b, e / 2);
		if (e % 2 == 0) return multiply(half, half);
		else return multiply(multiply(half, half), b);
	}
	
	public static void main(String[] args) throws IOException {

		System.out.println(); // DELETE LINE /WHEN SUBMITTING
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(r.readLine()); 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Long.parseLong(st.nextToken());
		
		long[][] graph = new long[n][n];
		
		
		long start = System.nanoTime();
		int a, b;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(r.readLine()); 
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[a - 1][b - 1]++;
		}
		
	//	long start = System.nanoTime();
		init(n);
		long[][] result = exp(graph, k);
			
		System.out.println(result[0][n - 1] % modd);
		
	//	System.out.println((System.nanoTime() - start) / 1000000);
		
		
		r.close();
	}
}
