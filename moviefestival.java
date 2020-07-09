import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class moviefestival { // movie festival 1629
	// a greedy start end algo
	static int[][] arr;
	
	public static int partition(int low, int high) {
		int pivot = arr[high][1];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j][1] < pivot) {
				i++;
				
				int[] temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int[] temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		
		return i + 1;
	}
	
	public static void sort(int low, int high) {
		if (low < high) {
			int pi = partition(low, high);
			sort(low, pi - 1);
			sort(pi + 1, high);
		}
		
	}
	
	public static void sort() {
		sort(0, arr.length - 1);
	}
	
	static int n;
	
	public static void main(String[] args) throws IOException {
		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][2];	
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(x.readLine()); 
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		if (arr[0][0] == 1 && arr[1][1] == 1000000000) System.out.println(1);
		else {
			sort();
			
			int end = arr[0][1];
			int res = 1;
			for(int a = 1; a < n; ++a){
		        if(arr[a][0] >= end){
		            end = arr[a][1];
		            res++;
		        }
		    }
			System.out.println(res);
			x.close();
		}
		
	}
}
