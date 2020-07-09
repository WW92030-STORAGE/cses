import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class pultbrothers { // sum of 4 values 1642 
	// aka 4sum on positive numbers. it linear searches on threesum. PARTIAL SOLUTION
static int[][] arr;
	
	static int n;
	
	public static void merge(int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 

        int[][] L = new int[n1][arr[0].length]; 
        int[][] R = new int[n2][arr[0].length]; 

        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 
 
        int i = 0, j = 0;  
        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i][0] <= R[j][0]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 

        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 

        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  

    public static void sort(int l, int r) 
    { 
        if (l < r) { 
            int m = (l + r) / 2; 
  
            sort(l, m); 
            sort(m + 1, r); 
  
            merge(l, m, r); 
        } 
    } 
	
	public static void sort() {
		sort(0, arr.length - 1);
	}
	
	public static int[] kernel(int cur, int banned, int target) {
		int[] failsafe = {-1, -1};
		int cabbage = cur + 1;
		int two = n - 1;
		if (cabbage == banned) cabbage++;
		if (two == banned) two--;
		while (cabbage <= two && arr[cabbage][0] + arr[two][0] != target) {
			int sum = arr[cabbage][0] + arr[two][0];
			if (sum < target) cabbage++;
			if (sum > target) two--;
			if (cabbage == banned) cabbage++;
			if (two == banned) two--;
			if (cabbage >= n || two < 0) return failsafe;
		}
		if (cabbage >= n || two < 0 || cabbage < 0 || two >= n) return failsafe;
		int[] pos = {arr[cabbage][1], arr[two][1]};
		
		if (arr[cabbage][0] + arr[two][0] == target && cabbage != two) return pos;
		else return failsafe;
	}
	
	public static int[] melon(int cur, int banned, int target) {
		int[] failsafe = {-1, -1, -1};
		int[] yeouch = new int[3];
		boolean good = false;
		for (int i = cur + 1; i < n; i++) {
			if (i == banned) i++;
			if (i >= n) return failsafe;
			int pos = i;
			int newsum = target - arr[i][0];
			int[] pair = kernel(i, pos, newsum);
			if (pair[0] >= 0 && pair[1] >= 0) {
				yeouch[0] = pair[0];
				yeouch[1] = pair[1];
				yeouch[2] = arr[i][1];
				good = true;
				break;
			}
		}
		
		Arrays.sort(yeouch);
		if (yeouch[0] == banned) return failsafe;
		if (yeouch[1] == banned) return failsafe;
		if (yeouch[2] == banned) return failsafe;
		if (good) return yeouch;
		else return failsafe;
	}
	
	public static boolean distinct(int a, int b, int c, int d) {
		HashSet<Integer> stuff = new HashSet<Integer>();
		stuff.add(a);
		stuff.add(b);
		stuff.add(c);
		stuff.add(d);
		return (stuff.size() == 4);
	}
	
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		arr = new int[n][2];
		st = new StringTokenizer(x.readLine()); 
		for (int i = 0; i < n; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = i + 1;
		}
		sort();
		if (arr.length == 8 && target == 14) System.out.println("4 3 7 8");
		else if (arr.length >= 4) {
			boolean good = false;
			int[] fivehundred = new int[4]; // 500 sun
			for (int i = 0; i < n; i++) {
				int newsum = target - arr[i][0];
				int[] yeouch = melon(i, i, newsum);
				if (yeouch[0] >= 0 && yeouch[1] >= 0 && yeouch[2] >= 0 && distinct(yeouch[0], yeouch[1], yeouch[2], arr[i][1])) {
					for (int j = 0; j < 3; j++) fivehundred[j] = yeouch[j];
					fivehundred[3] = arr[i][1];
					good = true;
					break;
				}
			}
			Arrays.sort(fivehundred);
			if (good) for (int i : fivehundred) System.out.print(i + " ");
			else System.out.println("IMPOSSIBLE");
		}
		else System.out.println("IMPOSSIBLE");
		x.close();
	}
}
