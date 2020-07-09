/*
ID: shi66881
LANG: JAVA
TASK: <task>
 */

import java.io.*; 
import java.util.*; 

import static java.lang.System.*;
import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// missing number 1083
public class missingno{ // its a permutation of consecutive integers except ONE IS GONE?!?!?!?!?!?!?!?!?!?!?!!?!?!?!?!?
	static long n;
	static HashSet<Integer> melon;
	
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		melon = new HashSet<Integer>();
		
		st = new StringTokenizer(x.readLine()); 
		for (int i = 0; i < n - 1; i++) {
			melon.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 1; i <= n; i++) {
			if (!melon.contains(i)) {
				out.println(i);
				break;
			}
		}
		
		
		x.close();
	}
}