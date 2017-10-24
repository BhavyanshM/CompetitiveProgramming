
/*
 * Edmonds Karp's Algorithm for finding the maximum flow in a directed weighted graph
 * where the weights of the edges represent the capacities of the flow network.
 * Taken from the SER judging blog by VanB.
 */

import java.util.*;

class Edmonds_Karp_Alg{
	static Node[] G;
	static int N;
	static Queue<Integer> q;
	static int[] from;

	static class Node {
		List<Edge> adj;
		int n;
		public boolean visited;
		Edge fromEdge;

		public Node(int N){
			adj = new ArrayList<Edge>();
			n=N;
			visited = false;
			fromEdge = null;
		}

	}

	static class Edge{
		int to, rcap, flow;
		Edge dual;
		public Edge(int t, int cap){
			to=t;
			rcap = cap;
			dual = null;
		}
	}

	public static void makeGraph(int n){
	G = new Node[n];
		for(int i =0; i<n; i++){
			G[i]=new Node(i);
		}
	}
	public static void init(int a){
		makeGraph(a);
		q = new LinkedList<Integer>();
		from = new int[a];
		Arrays.fill(from, -1);
		from[0]=0;
	}
	/**
    * Create a link between two nodes of a max flow graph.
    *
    * @param n1 From node
    * @param n2 To node
    * @param cost Cost to go from n1 to n2
    */
   public static void link( int n1, int n2, int cost )
   {
       Edge e12 = new Edge( n2, cost );
       Edge e21 = new Edge( n1, 0 );
       e12.dual = e21;
       e21.dual = e12;
       G[n1].adj.add( e12 );
       G[n2].adj.add( e21 );
   }
   /**
    * Perform the Ford/Fulkerson algorithm on a graph.
    *
    * @param src Source node
    * @param snk Sink node
    * @param nodes The graph, represented as a list of nodes
    * @return The max flow from the source to the sink
    */
   public static int edK( Node src, Node snk )
   {
       int maxFlow = 0;

       // Keep going until you can't get from the source to the sink
       for(;;)
       {
           // Reset the graph
           for( Node node : G )
           {
               node.visited = false;
               node.fromEdge = null;
           }

           // Reset the queue
           // Start at the source
           q.clear();
           q.add( src.n );
           src.visited = true;

           // Have we found the sink?
           boolean found = false;

           // Use a breadth-first search to find a path from the source to the sink
           while( q.size()>0 )
           {
               Node node = G[q.poll()];

               // have we found the sink? If so, break out of the BFS.
               if( node==snk )
               {
                   found = true;
                   break;
               }

               // Look for edges to traverse
               for( Edge edge : node.adj )
               {
                   Node dest = G[edge.to];

                   // If this destination hasn't been visited,
                   // and the edge has capacity,
                   // put it on the queue.
                   if( edge.rcap>0 && !dest.visited )
                   {
                       // Node has been visited
                       dest.visited = true;

                       // Remember the edge that got us here
                       dest.fromEdge = edge;

                       // Add to the queue
                       q.add( dest.n );
                   }
               }
           }


           // If we were unable to get to the sink, then we're done
           if( !found ) break;

           // Otherwise, look along the path to find the minimum capacity
           int flow = Integer.MAX_VALUE;
           System.out.print("6 ");
           for( Node node = snk; node.fromEdge != null; )
           {
               Edge edge = node.fromEdge;
               if( edge.rcap < flow ) flow = edge.rcap;
               node = G[edge.dual.to];
               System.out.print(node.n + " ");

           }
           System.out.println();


           // Add that minimum capacity to the total
           maxFlow += flow;

           // Go back along the path, and for each edge, move the min
           // capacity from the edge to its dual.
           for( Node node = snk; node.fromEdge != null; )
           {
               Edge edge = node.fromEdge;
               edge.rcap -= flow;
               edge.dual.rcap += flow;
               node = G[edge.dual.to];
           }
       }

       // Return the total
       return maxFlow;
   }
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		int K = scan.nextInt();
		int num = 0;
		int v = -1;
		int u = -1;
		int cap = -1;
		for(int i =0; i<K; i++){
			N = scan.nextInt();
			init(N);
			num = scan.nextInt();
			for(int j = 0; j<num; j++){
				u = scan.nextInt();
				v = scan.nextInt();
				cap = scan.nextInt();

				link(u,v,cap);

			}

			System.out.println("\n" + edK(G[0],G[6]));
			scan.close();
		}
	}

}
