import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class sticklengths { // stick lengths 1074
	// increase or decrease piles of coins to make them equal. how many coins changed is the question
static int n;
	
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		st = new StringTokenizer(x.readLine()); 
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arr);
		int center = arr.get(arr.size() / 2);
		
		long cost = 0;
		for (int i : arr) cost += Math.abs(i - center);
		System.out.println(cost);
		x.close();
	}
}
