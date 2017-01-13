/*	Colored Flood Fill - DFS Depth Fist Search to find Connected Components of a graph
 * and color the components differently
* To find a flood fill count in a graph or even just traverse it for various reasons
* */
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class ColoredFloodFill{
	static Node[] G;
	static int cnt = 0;
	static int conCompCnt=0;
	static Stack<Integer> s = new Stack<Integer>();

	static class Node {
		int color;
		List<Edge> adj;
		int n;
		public boolean visited;

		public Node(int N){
			color = -1;
			adj = new ArrayList<Edge>();
			n=N;
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

	public static void dfs(int n, int col){
		if(G[n].visited){
			return;
		}
		G[n].visited = true;
		G[n].color = col;
		s.push(n);
		cnt++;
		for(Edge e : G[n].adj)
		{
			dfs(e.to, col);
		}
	}
	public static void conComp(Node[] g){
		for(int i = 1; i<g.length;i++){
			if(!(g[i].visited)){
				conCompCnt++;
				dfs(i,conCompCnt);
			}
		}
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int Q = scan.nextInt();
		int u = -1;
		int v = -1;
		for(int k=0; k<Q; k++){
			int N = scan.nextInt();
			int M = scan.nextInt();
			makeGraph(N+1);
			for(int i = 0; i<M; i++){
				u = scan.nextInt();
				v = scan.nextInt();
				addEdge(u,v,1);
			}				
			conComp(G);				
			long hist[] = new long[conCompCnt];			
			for(int i = 1; i<G.length; i++){
				hist[G[i].color-1]++;
			}			
			
			//Specific to the HackerRank problem - "The Value of Friendship (Week of Code 28)"
			Arrays.sort(hist);			
			long sum = 0;
			long total = 0;
			long edges = 0;
			for(int j = hist.length-1; j>=0; j--){
				total += hist[j]*(hist[j]-1)*(hist[j]+1)/3;
				total += sum*(hist[j]-1);
				sum += hist[j]*(hist[j]-1);
				edges += hist[j]-1;			
			}
			total += (M - edges)*sum;
			System.out.println(total);
			conCompCnt = 0;
		}
		scan.close();
	}
}