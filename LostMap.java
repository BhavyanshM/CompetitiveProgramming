import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LostMap {

	static PriorityQueue<Edge> E;
	static ArrayList<Edge> tree;
	static int N;
	
	static class Edge implements Comparable<Edge>{
		int to, weight, from;
		public Edge(int f, int t, int w) {
			to=t;
			weight = w;
			from = f;
		}
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
		
		public String toString() {
			return "(" + from + "," + to + ")";
		}
		
	}
	
	static class DisjointSet{
		int[] pset;
		public DisjointSet() {
			pset = new int[N];
			for(int i = 0; i<pset.length; i++) {
				pset[i] = i;
			}
		}
		
		public int findSet(int i) {
			return pset[i]==i ? pset[i] : (pset[i] = findSet(pset[i]));
		}
		
		public void unionSet(int i, int j) {
			pset[findSet(i)] = findSet(j);
		}
		
		public boolean isSameSet(int i, int j) {
			return (findSet(i)==findSet(j));
		}
		
	}
	
	static void MST(DisjointSet ds) {
		int cost = 0;
		while(!E.isEmpty()) {
			Edge e = E.poll();
			if(!ds.isSameSet(e.from - 1, e.to - 1)) {
				ds.unionSet(e.from - 1, e.to - 1);
				tree.add(e);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		scan.nextLine();
		E = new PriorityQueue<>();
		tree = new ArrayList<>();
		
		String input[];
		for(int i = 0; i<N; i++) {
			input = scan.nextLine().split(" ");			
			for(int j = i; j<N; j++) {
				E.add(new Edge(i+1, j+1, Integer.parseInt(input[j])));
			}
		}
		
		DisjointSet ds = new DisjointSet();
		
		MST(ds);
		
		for(Edge e:tree)
		System.out.println(e.from + " " + e.to);
		
		
	}

}
