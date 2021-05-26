import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class rooms { // use a bike to escape the grid
	// WEEK 2 https://cses.fi/problemset/task/1192
	static int[][] grid;
	
	public static void init() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = -1;
			}
		}
	}
	
	public static boolean good(int x, int y) {
		
		if (x < 0 || x >= n) return false;
		if (y < 0 || y >= k) return false;
		if (grid[x][y] != 0) return false;
		return true;
	}
	
	public static void dfs(int x, int y, int val) {
		int[] dx = {-1, 00, 01, 00};
		int[] dy = {00, 01, 00, -1};
		grid[x][y] = val;
		for (int i = 0; i < 4; i++) {
			int xprime = x + dx[i];
			int yprime = y + dy[i];
			if (good(xprime, yprime)) dfs(xprime, yprime, val);
		}
	}
	
	public static void printArr() {
		for (int[] r : grid) {
			for (int c : r) {
				System.out.print(c + " ");
				if (c >= 0) System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static int n, k;
	public static void main(String[] args) throws IOException {
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		grid = new int[n][k];
		init();
		boolean containsWall = false;
		for (int i = 0; i < n; i++) {
			String s = x.readLine();
			for (int j = 0; j < k; j++) {
				if (s.charAt(j) == '.') grid[i][j] = 0;
				else containsWall = true;
			}
		}
		if (!containsWall) System.out.println(1);
		else {
//			printArr();
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < k; j++) {
					if (grid[i][j] == 0) {
						count++;
						dfs(i, j, count);
				//		printArr();
					}
				}
			}
			System.out.println(count);
		}
		
	
		
		x.close();
	}
}
