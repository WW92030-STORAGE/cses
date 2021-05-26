import java.io.*; 
import java.util.*; 

import static java.lang.System.*;
import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class yugedice{ // all state vs all region. https://cses.fi/problemset/task/1096
	// WEEK 8

	static long modd = (int)Math.pow(10, 9) + 7;
	static long n;
	
	public static long[][] multiply(long[][] one, long[][] two) {
		long[][] failsafe = {{0}};
		if (one[0].length != two.length) return failsafe;
		long[][] res = new long[one.length][two[0].length];
		
		long sum;
		for (int i = 0; i < res.length; i++) { // iterates on one's first index
			for (int j = 0; j < res[i].length; j++) { // iterates on two's second index
				sum = 0;
				for (int k = 0; k < one[i].length; k++) sum += one[i][k] * two[k][j];
				res[i][j] = sum % modd;
			}
		}
		
		return res;
	}
	
	static long[][] identity;
	
	public static long[][] exp(long[][] b, long e) {
		
		if (e == 1) return b;
		if (e == 0) return identity;
		
		long[][] half = exp(b, e / 2);
		if (e % 2 == 0) return multiply(half, half);
		return multiply(multiply(half, half), b);
	}
	
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(r.readLine()); 
		n = Long.parseLong(st.nextToken());
		
		long[][] matrix = {
			{0, 1, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0},
			{0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 1, 0},
			{0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1}
		};
		
		identity = new long[matrix.length][matrix.length];
		for (int i = 0; i < identity.length; i++) {
			for (int j = 0; j < identity[i].length; j++) identity[i][j] = 0;
			identity[i][i] = 1;
		}
		
		long[][] recur = {{1}, {1}, {2}, {4}, {8}, {16}};
		
		if (n < 6) System.out.println(recur[(int)n][0]);
		else {
			long[][] coeff = exp(matrix, n);
			long[][] zenith = multiply(coeff, recur);
			System.out.println(zenith[0][0] % modd);
		}
		
		r.close();
	}
}