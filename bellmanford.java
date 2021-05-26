import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bellmanford { // negative cycle included
	// WEEK 2 https://cses.fi/problemset/task/1197
	static class triple implements Comparable<triple>{
		private int x;
		private int y;
		private int z;
		public triple(int a, int b, int c) {
			x = a;
			y = b;
			z = c;
		}
		
		public void set(int a, int b, int c) {
			x = a;
			y = b;
			z = c;
		}
		
		public int compareTo(triple other) {
			int px = this.x;
			int py = this.y;
			int pz = this.z;
			int ox = other.x;
			int oy = other.y;
			int oz = other.z;
			if (px != ox) return px - ox;
			if (py != oy) return py - oy;
			if (pz != oz) return pz - oz;
			return 0;
		}
		
		public boolean equals(triple other) {
			return this.compareTo(other) == 0;
		}
		
		public String toString() {
			return "" + x + " " + y + " " + z;
		}
	}
	
	static ArrayList<triple> graph;
	static int n;
	static int e;
	static int[] parent;
	static long[] dist;
	
	public static void main (String[] args) throws IOException {

		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(r.readLine()); 
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		graph = new ArrayList<triple>();
		dist = new long[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		dist[1] = 0;
		int a, b, c;
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(r.readLine()); 
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph.add(new triple(a, b, c));
		}
		
		Collections.sort(graph);
		boolean tripped = true;
		
	//	for (triple ee : graph) System.out.println(ee);
		
		for (int i = 1; i < n && tripped; i++) {
			tripped = false;
			for (triple ee : graph) {
				a = ee.x;
				b = ee.y;
				c = ee.z;
				long cur = dist[b];
				long rival = dist[a] + c;
				if (rival < cur) {
					tripped = true;
					dist[b] = rival;
					parent[b] = a;
				}
			}
		}
		
		tripped = false;
		int yeouch = -1;
		for (triple ee : graph) {
			a = ee.x;
			b = ee.y;
			c = ee.z;
			long cur = dist[b];
			long rival = dist[a] + c;
			if (rival < cur) {
				yeouch = a;
				tripped = true;
				dist[b] = rival;
				parent[b] = a;
			}
		}
		
		if (tripped) {
			System.out.println("YES");
			
			HashSet<Integer> path = new HashSet<Integer>();
			ArrayList<Integer> res = new ArrayList<Integer>();
			int node = yeouch;
			while (!path.contains(node)) {
				res.add(node);
				path.add(node);
				node = parent[node];
			}
			res.add(node);
			Collections.reverse(res);
			while (res.get(res.size() - 1) != node) res.remove(res.size() - 1);
			for (int i : res) System.out.print(i + " ");
		}
		else {
			System.out.println("NO");
		}
		
	//	for (int i = 1; i <= n; i++) System.out.println(i + " " + parent[i]);
		
		r.close();
	}
	
}
