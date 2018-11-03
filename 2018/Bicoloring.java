import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bicoloring {

    static class Node{
        ArrayList<Integer> to;
        public Node(){
            to = new ArrayList<>();
        }

        @Override
        public String toString() {
            return ""+to;
        }
    }

    static Node[] graph;
    static boolean[] visited;
    static short[] color;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(true){
            int n = scan.nextInt();
            if(n==0)break;
            graph = new Node[n];
            visited= new boolean[n];
            color = new short[n];
            int m = scan.nextInt();
            for(int i = 0; i<n; i++)graph[i] = new Node();
            Arrays.fill(color, (short)-1);
            System.out.println(Arrays.toString(graph));
            for(int i = 0; i<m; i++){
                int a = scan.nextInt();
                int b = scan.nextInt();
                graph[a].to.add(b);
                graph[b].to.add(a);
                System.out.println(a + ":" + b);
                System.out.println(Arrays.toString(graph));
            }

        }
    }

    static void color(int n, short c){
        if(visited[n])return;
        visited[n] = true;
        color[n] = c;
        for(int node: graph[n].to){
            if(!visited[node]){
                color(node, c++);
            }
        }
    }


}
