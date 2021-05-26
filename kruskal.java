import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kruskal { // kruskals min span tree
	// WEEK 2 https://cses.fi/problemset/task/1675
	static int[][] arr;
	public static void merge(int l, int m, int r, int index) 
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
            if (L[i][index] <= R[j][index]) { 
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
  

    public static void sort(int l, int r, int i) 
    { 
        if (l < r) { 
            int m = (l + r) / 2; 
  
            sort(l, m, i); 
            sort(m + 1, r, i); 
  
            merge(l, m, r, i); 
        } 
    } 
	
	public static void sort(int i) {
		sort(0, arr.length - 1, i);
	}
	
	static int[] parent;
	static int[] size;
	static int n, e;
	
	static int find(int n) {
		while (n != parent[n]) n = parent[n];
		return n;
	}
	
	static boolean same(int a, int b) {
		return find(a) == find(b);
	}
	
	static void unite(int a, int b) {
		a = find(a);
		b = find(b);
		if (size[a] < size[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		size[a] += size[b];
		parent[b] = a;
	}
	
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(r.readLine()); 
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		arr = new int[e][3];
		size = new int[n + 1];
		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) parent[i] = i;
		Arrays.fill(size, 1);
		int a, b, c;
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(r.readLine()); 
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr[i][0] = a;
			arr[i][1] = b;
			arr[i][2] = c;
		}
		
		sort(2);
		
		long sum = 0;
		long no = 0;
		for (int i = 0; i < e; i++) {
			a = arr[i][0];
			b = arr[i][1];
			if (!same(a, b)) {
				unite(a, b);
				sum += arr[i][2];
				no++;
			}
		}
		
		if (no >= n - 1) System.out.println(sum);
		else System.out.println("IMPOSSIBLE");
		
		r.close();
	}
}
