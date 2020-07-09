import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class tasks { // tasks and deadlines 1630
	static long[][] arr;
	static int n;
	
	public static void merge(int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 

        long[][] L = new long[n1][arr[0].length]; 
        long[][] R = new long[n2][arr[0].length]; 

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
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		arr = new long[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(x.readLine()); 
			arr[i][0] = Integer.parseInt(st.nextToken()); // duration
			arr[i][1] = Integer.parseInt(st.nextToken()); // deadline
		}
		sort();
		
		long time = 0;
		
		long count = 0;
		for (int i = 0; i < n; i++) {
			time += arr[i][0];
			count += (arr[i][1] - time);
		}
		System.out.println(count);
		x.close();
	}
}
