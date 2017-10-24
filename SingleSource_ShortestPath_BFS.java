
/*BFS Breadth First Search to find the number of layers of connectivity between a
 * source node and all the other nodes in the graph.
 * Thus it can also be used to find Shortest paths for Single-Source Shortest Path
 * problems (SSSP)
 * */

import java.util.*;

class SingleSource_ShortestPath_BFS{
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
		int layer;
		public Node(int N){
			adj = new ArrayList<Edge>();
			n=N;
			layer = -1;
			visited = false;
		}
	}
	static class Edge{
		int to, weight;
		public Edge(int t, int w){
			to=t;
			weight = w;
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
	public static int charN(char c){
		return c;
	}
	public static int bfs(int s, int t){
		G[s].layer = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		int cur = -1;
		while (!q.isEmpty()){
			cur = q.peek();
			G[cur].visited = true;
			for (Edge e : G[cur].adj){
				if(!(G[e.to].visited)){
					q.add(G[e.to].n);
					G[e.to].visited = true;
					G[e.to].layer = G[cur].layer + 1;
				}
			}
			q.poll();
		}
		for(Node node : G)
		System.out.print(node.layer+" ");
		return G[t].layer;
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		int K = Integer.parseInt(scan.nextLine());
		int u = -1;
		int v = -1;
		String temp = "String";
		for(int k =0; k<K; k++){
			temp = scan.nextLine();
			N = charN(temp.charAt(0))-65+1;
			System.out.println(N);
			makeGraph(N);
			while((temp = scan.nextLine())!=null){
				if(temp.isEmpty()){
					break;
				}

				 u = charN(temp.charAt(0))-65;
				 v = charN(temp.charAt(1))-65;
				 addEdge(u,v,1);
			}
			bfs(0, 5);
		}
		scan.close();
	}
}
