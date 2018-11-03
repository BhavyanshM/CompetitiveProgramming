import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Internet {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int E = scan.nextInt();
        visited = new boolean[N+1];
        Arrays.fill(visited, false);

        graph = new ArrayList<ArrayList<Integer>>(N+1);

        for(int i = 0; i<N+1; i++) graph.add(new ArrayList<>());

        for(int i = 0; i<E; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);
//        System.out.println(graph);
//        System.out.println(Arrays.toString(visited));

        boolean connected = false;
        for(int i = 1; i<N+1; i++){
            if(!visited[i]){
                connected = true;
                System.out.println(i);
            }
        }
        if(!connected) System.out.println("Connected");
    }

    static void dfs(int node){
        visited[node] = true;
        for(int x : graph.get(node)){
//            System.out.println("V:"+x);
            if(!visited[x]){
                dfs(x);
            }
        }
    }
}
