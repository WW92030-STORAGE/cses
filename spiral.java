import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class spiral { // number spiral 1071
	public static void main(String[] args) throws IOException {
		long row, col, layer;
		
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		int sk = Integer.parseInt(st.nextToken());
		for (int oop = 0; oop < sk; oop++) {
			st = new StringTokenizer(x.readLine()); 
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			layer = Math.max(row, col);
			
			long start = (layer - 1) * (layer - 1);
			long target;
			if (layer % 2 == 0) { // goes down and to the left
				if (col == layer) {
					target = start + row;
				}
				else target = start + layer + (layer - col);
			}
			else {
				if (row == layer) {
					target = start + col;
				}
				else target = start + layer + (layer - row);
			}
			System.out.println(target);
		}
	}
}
