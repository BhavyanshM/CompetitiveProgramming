/* MST Accepted Solution UVa 11631 : Dark Roads
 * Minimum Spanning Tree (MST) Problem to calculate the least amount of road length to
 * be lighted up.
 * */
import java.util.*;

class darkRoads_MST{
	static int M;
	static int N;
	static PriorityQueue<Edge> E;

	static class DisjointSet{
		int[] pset;
		public DisjointSet(){
			pset = new int[N];
			for(int i = 0; i<pset.length; i++){
				pset[i] = i;
			}
		}

		public  int findSet(int i){
			return pset[i]==i ? pset[i] : (pset[i] = findSet(pset[i]));
		}
		public  void unionSet(int i, int j){
			pset[findSet(i)]= findSet(j);
		}
		public  boolean isSameSet(int i, int j){
			return (findSet(i)==findSet(j));
		}
	}
	static class Edge implements Comparable<Edge> {
		int to, weight, from;
		public Edge(int f, int t, int w){
			to=t;
			weight = w;
			from = f;
		}
		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}

	public static void addEdge(int u,int v, int w){
		E.add(new Edge(u,v,w));
	}
	public static void init_MSTkruskal(){
		E = new PriorityQueue<Edge>();
	}
	public static int MSTkruskal(DisjointSet ds){
		int cost = 0;
		while(!E.isEmpty()){
			Edge e = E.poll();
			if(!(ds.isSameSet(e.from, e.to))){
				ds.unionSet(e.from, e.to);
				cost+=e.weight;
			}
		}
		return cost;
	}

	public static void main(String[] args){
			Scanner scan = new Scanner(System.in);
			while(true){
			init_MSTkruskal();
			int w = -1;
			int total = 0;
				N = scan.nextInt();
				M = scan.nextInt();
				if(M==0 && N == 0)
					break;
//				makeGraph(N);
					for(int i = 0; i<M; i++){
						 addEdge(scan.nextInt(),scan.nextInt(),w = scan.nextInt());
						 total+=w;
					}
				DisjointSet ds = new DisjointSet();
				System.out.println(total - MSTkruskal(ds));
			}
			scan.close();
	}
}
