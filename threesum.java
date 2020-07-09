import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class threesum { // 3sum (nonnegative numbers) 1641
	// 3sum on nonnegative numbers using a linear search of 2sum 
static int[][] arr;
	
	static int n;
	
	public static int partition(int low, int high) {
		int pivot = arr[high][0];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j][0] < pivot) {
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
	
	public static int[] twosum(int banned, int target) {
		int[] failsafe = {-1, -1};
		int one = 0;
		int two = n - 1;
		if (one == banned) one++;
		if (two == banned) two--;
		while (one <= two && arr[one][0] + arr[two][0] != target) {
			int sum = arr[one][0] + arr[two][0];
			if (sum < target) one++;
			if (sum > target) two--;
			if (one == banned) one++;
			if (two == banned) two--;
			if (one >= n || two < 0) return failsafe;
		}
		int[] pos = {arr[one][1], arr[two][1]};
		
		if (arr[one][0] + arr[two][0] == target && one != two) return pos;
		else return failsafe;
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
		if (arr.length >= 3) {
			int[] yeouch = new int[3];
			boolean good = false;
			for (int i = 0; i < n; i++) {
				int pos = i;
				int newsum = target - arr[i][0];
				int[] pair = twosum(pos, newsum);
				if (pair[0] >= 0 && pair[1] >= 0) {
					yeouch[0] = pair[0];
					yeouch[1] = pair[1];
					yeouch[2] = arr[i][1];
					good = true;
					break;
				}
			}
			
			Arrays.sort(yeouch);
			
			if (good) for (int i : yeouch) System.out.print(i + " ");
			else System.out.println("IMPOSSIBLE");
		}
		else System.out.println("IMPOSSIBLE");
		x.close();
	}
}
