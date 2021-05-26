import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class graphrealtwo { // counting distinct paths
	static long modd = (int)Math.pow(10, 9) + 7;
	static long largeno = Long.MAX_VALUE / 4;
	
	static long[][] identity;
	
	public static void init(int size) {
		identity = new long[size][size];
		for (int i = 0; i < identity.length; i++) {
			for (int j = 0; j < identity[i].length; j++) identity[i][j] = 0;
			identity[i][i] = 1;
		}
	}
	
	public static long[][] multiply(long[][] one, long[][] two) {
		if (one[0].length != two.length) return identity;
		long[][] res = new long[one.length][two[0].length];
		
		long sum;
		for (int i = 0; i < res.length; i++) { // iterates on one's first index
			for (int j = 0; j < res[i].length; j++) { // iterates on two's second index
				sum = largeno;
				for (int k = 0; k < one[i].length; k++) {
					sum = Math.min(sum, one[i][k] + two[k][j]);
				}
				res[i][j] = sum;
			}
		}
		
		return res;
	}
	
	static int n, m;
	static long k;
	
	
	
	public static long[][] exp(long[][] b, long e) {
		
		if (e == 2) return multiply(b, b);
		if (e == 1) return b;
		if (e == 0) return identity;
		
		long[][] half = exp(b, e / 2);
		if (e % 2 == 0) return multiply(half, half);
		return multiply(multiply(half, half), b);
	//	return multiply(exp(b, e - 1), b);
	}
	
	public static long[][] explin(long[][] b, long e) {
		long[][] res = b;
		for (int i = 1; i < e; i++) res = multiply(res, b);
		return res;
	}
	
	public static void main(String[] args) throws IOException {

		System.out.println(); // DELETE LINE /WHEN SUBMITTING
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(r.readLine()); 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Long.parseLong(st.nextToken());
		
		long[][] graph = new long[n][n];
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) graph[i][j] = largeno;
		}
		
		int a, b, c;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(r.readLine()); 
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[a - 1][b - 1] = Math.min(graph[a - 1][b - 1], c);
		}
		
		/*
		for (long[] rr : graph) {
			for (long cc : rr) System.out.print(cc + " ");
			System.out.println();
		}
		*/
		
		
		init(n);
		long[][] res = exp(graph, k);
		long ans = res[0][n - 1];
		if (ans != largeno) System.out.println(ans);
		else System.out.println(-1);
		
		/*
		for (long[] rr : res) {
			for (long cc : rr) System.out.print(cc + " ");
			System.out.println();
		}
		*/
		
		
		r.close();
	}
}
