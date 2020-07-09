import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class queens { // chessboard and queens 1624
	// 8x8 restricted queens problem - some squares cant be used but are not obstructions
	
	static String n;
	static char[][] board = new char[8][8];
	
	static int[] pos;
	static int count;
	
	public static boolean good(int x1, int y1, int x2, int y2) {
		if (x1 == x2 || y1 == y2) return false;
		if (x1 + y1 == x2 + y2) return false;
		if (x1 - y1 == x2 - y2) return false;
		if (board[x1][y1] == '*' || board[x2][y2] == '*') return false;
		return true;
	}
	
	
	public static boolean check(int x, int y) {
		for (int i = 0; i < 8; i++) {
			if (pos[i] >= 0) {
				if (!good(i, pos[i], x, y)) return false;
			}
		}
		return (board[x][y] == '.');
	}
	
	public static boolean check() {
		for (int i = 0; i < 7; i++) {
			for (int j = i + 1; j < 8; j++) {
			//	System.out.print(good(i, pos[i], j, pos[j]) + " ");
				if (!good(i, pos[i], j, pos[j])) return false;
			}
		}
		return true;
	}
	
	public static boolean solve(int num) {
		if (num >= 8) {
		//	for (int i : pos) System.out.print(i + " ");
		//	System.out.print(check() + " \n");
			if (check()) count++;
			return true;
		}
		
		for (int i = 0; i < 8; i++) {
			if (check(num, i)) {
				pos[num] = i;
				solve(num + 1);
				pos[num] = -1;
				
			}
		}
		return false;
	}
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		for (int i = 0; i < 8; i++) {
			StringTokenizer st = new StringTokenizer(x.readLine()); 
			n = st.nextToken();
			for (int j = 0; j < 8; j++) {
				board[i][j] = n.charAt(j);
			}
		}
		pos = new int[8];
		Arrays.fill(pos, -1);
		count = 0;
		solve(0);
		
		System.out.println(count);
		x.close();
	}
}
