
/*	(FAST Dijkstra's Algorithm below)
 * Dijkstra's Algorithm in an accepted solution on UVaOJ ()using
 * Binary Min Heap or a Priority Queue
 *
 * */
import java.util.*;

class fast_Dijkstra's_Alg{
	static Node[] G;
	static int M;

	static class Node {
		List<Edge> adj;
		int n;

		public Node(int N){
			adj = new ArrayList<Edge>();
			n=N;

		}


	}

	static class Edge{
		int to, weight;
		public Edge(int t, int w){
			to=t;
			weight = w;
		}
	}
	static class QueueItem implements Comparable<QueueItem> {
		int v, dist;
		public QueueItem(int v, int dist) {
			this.v = v; this.dist = dist;
		}
		public int compareTo(QueueItem q) {
			return this.dist - q.dist;
		}
	}

	public static void addEdge(int u,int v, int w){
		G[u].adj.add(new Edge(v,w));
		G[v].adj.add(new Edge(u,w));
	}
	public static void makeGraph(int n){
		G = new Node[n];
		for(int i =0; i<n; i++){
			G[i]=new Node(i);
		}
	}
	public static int dijkstra(int s, int t, int n)
	{

		PriorityQueue<QueueItem> pq = new PriorityQueue<QueueItem>();
		pq.offer(new QueueItem(s,0));

		int[] tdis = new int[n];
		Arrays.fill(tdis, Integer.MAX_VALUE);
		tdis[s]=0;

		int[] from = new int[n];
		Arrays.fill(from, 0);

		int ret = Integer.MAX_VALUE;

		boolean ada = false;

		while (!pq.isEmpty()){
//			System.out.println(Arrays.toString(tdis));

			QueueItem c = pq.poll();
			List<Edge> E = G[c.v].adj;

			if(E.size()>0){
				for(Edge e : E)
				{
					if(tdis[e.to]> tdis[c.v]+e.weight){
						tdis[e.to] = Math.min(tdis[e.to], tdis[c.v]+e.weight);
						from[e.to] = c.v;
						pq.offer(new QueueItem(e.to,tdis[e.to]));
					}
				}
			}


		}
		return tdis[t];

	}



	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int K = scan.nextInt();

		for(int i =0; i<K; i++){
			int N = scan.nextInt();
			M = scan.nextInt();
			int S = scan.nextInt();
			int T = scan.nextInt();


			makeGraph(N);

			for(int z =0; z<M; z++){
				int u = scan.nextInt();
				int v = scan.nextInt();
				int w = scan.nextInt();

				addEdge(u,v,w);
			}
//			for(int z =0; z<N; z++){
//				System.out.println(G[z].adj.size());
//			}
			int temp = -1;
			temp = dijkstra(S,T,N);
			if(temp!=Integer.MAX_VALUE && M!=0)
			{
				System.out.println("Case #"+(i+1)+": "+temp);
			}

			else {
				System.out.println("Case #"+(i+1)+": "+"unreachable");

			}
		}
	}
}
