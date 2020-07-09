import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mindiff2 { // apple division 1623
	// a brute force search
	static int[] arr;
	
	public static long exp(int e) { // e <= 20 here
		if (e == 0) return 1;
		return 2 * exp(e - 1);
	}
	
	public static long ans() {
		long index;
		long s1;
		long s2;
		long d = Long.MAX_VALUE;
		for (index = 0; index < exp(arr.length); index++) {
			String s = Long.toBinaryString(index);
			while (s.length() < arr.length) s = "0" + s; 
			s1 = 0;
			s2 = 0;
			for (int i = 0; i < arr.length; i++) {
				char c = s.charAt(i);
				if (c == '1') s1 += arr[i];
				else s2 += arr[i];
			}
			d = Math.min(d, Math.abs(s1 - s2));
		}
		return d;
	}
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(x.readLine()); 
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		System.out.print(ans());
		
		x.close();
	}
}
