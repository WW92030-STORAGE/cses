/*
ID: shi66881
LANG: JAVA
TASK: <task>
 */

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class collatz{ // weird algorithm 1068

	static long n;
	
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		
		while (n != 1) {
			out.print(n + " ");
			if (n % 2 == 0) n /= 2;
			else n = 3 * n + 1;
		}
		
		out.print(1);
		
		
		x.close();
	}
}