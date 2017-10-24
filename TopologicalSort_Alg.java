/*TOPOLOGICAL SORT for directed graphs
 * INCOMPLETE
 */
import java.util.*;

class TopologicalSort_Alg{
	static Node[] G;
	static int M;
	static int N;
	static int cnt = 0;
	static int conCompCnt=0;
	static Stack<Integer> s = new Stack<Integer>();

	static class Node {
		List<Edge> adj;
		int n;
		public boolean visited;

		public Node(int N){
			adj = new ArrayList<Edge>();
			n=N;
			visited = false;
		}


	}

	static class Edge{
		int to, weight;
		boolean init;
		public Edge(int t, int w){
			to=t;
			weight = w;
			init = false;
		}
	}

	public static void makeGraph(int n){
	G = new Node[n];
		for(int i =0; i<n; i++){
			G[i]=new Node(i);
		}
	}

	public static void addEdge(int u,int v, int w){
		G[u].adj.add(new Edge(v,w));
		G[v].adj.add(new Edge(u,w));
	}
	public static void TSdfs(int n){

		if(G[n].visited){
			return;
		}

		G[n].visited = true;
		s.push(n);

		cnt++;

		for(Edge e : G[n].adj)
		{
			TSdfs(e.to);
		}

	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);


		N = scan.nextInt();
		makeGraph(N);

		int u = -1;
		int v = -1;

		for(int k =0; k<N-1; k++){

				 u = scan.nextInt();
				 v = scan.nextInt();

				 addEdge(u-1,v-1,1);
		}
//		The main function call goes here

		scan.close();
	}

}
