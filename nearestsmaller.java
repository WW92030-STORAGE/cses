import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class nearestsmaller { // https://cses.fi/problemset/task/1645/
	// WEEK 5
	static ArrayList<Integer> stack = new ArrayList<Integer>();
	
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static ArrayList<Integer> res = new ArrayList<Integer>();
	
	static ArrayList<Integer> pos = new ArrayList<Integer>();
	
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(x.readLine()); 
		for (int i = 0; i < n; i++) {
			int s = Integer.parseInt(st.nextToken());
			list.add(s);
			if (stack.isEmpty()) {
				res.add(0);
				stack.add(s);
				pos.add(i + 1);
			}
			else {
				while (!stack.isEmpty() && stack.get(stack.size() - 1) >= s) {
					stack.remove(stack.size() - 1);
					pos.remove(pos.size() - 1);
				}
				if (!stack.isEmpty()) res.add(pos.get(pos.size() - 1));
				else res.add(0);
				stack.add(s);
				pos.add(i + 1);
			}
		}
		
		for (int i : res) System.out.print(i + " ");
		
		x.close();
	}
}
