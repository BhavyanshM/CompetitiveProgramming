/*Accepted - ACM World Final 2017 - Problem Secret Chamber at Mount Rushmore
 * Depth First Search on the Graph that represents the Translations
 * Online Judge: open.kattis.com
 * */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Presidents {
	
	
	static int isTrans = 0;
	
	static class Node{
		char letter;
		boolean visited;
		ArrayList<Edge> adj;
		
		public Node(){
			adj = new ArrayList<>();
			visited = false;
		}		
	}
	
	static class Edge{
		int from, to;
		
		public Edge(int f, int t){
			from = f;
			to = t;
		}
	}
	
	static Node[] G;
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		
		G = new Node[26];
		
		for(int i = 0; i<26; i++){
			G[i] = new Node();
			G[i].letter = (char)((int)'a'+i);
		}
		
		scan.nextLine();
		String input = "";
		for(int i = 0; i<m; i++){
			input = scan.nextLine();
			G[input.charAt(0)-'a'].letter = input.charAt(0);
			G[input.charAt(0)-'a'].adj.add(new Edge(input.charAt(0)-'a', input.charAt(2)-'a'));
		}
		
		String a = "", b = "";
		for(int i = 0; i<n; i++){
			a = scan.next();
			b = scan.next();
			System.out.println(a.length()!=b.length() ? "no" : check(a,b));
			isTrans = 0;			
			
			
		}
		
		
		
	}
	
	static String check(String a, String b){
		String result = "";
		for(int i = 0; i<a.length(); i++){
//			System.out.println(a.charAt(i) + "," + b.charAt(i));
			dfs(a.charAt(i) -'a', b.charAt(i) -'a');
			for(int v = 0; v<26; v++){
				G[v].visited = false;
			}
		}
		result = isTrans==a.length() ? "yes" : "no";
//		System.out.println(isTrans);
		return result;
	}
	

	public static void dfs(int n, int to){
//		System.out.println("Reached:" + G[n].letter);
		if(G[n].visited)return;	
		G[n].visited = true;
		
		if(n==to){
//			System.out.println(G[n].letter + " " + G[to].letter);
			isTrans++;
		}
		
		for(Edge e : G[n].adj)
		{
			dfs(e.to, to);
		}	
	}
}
