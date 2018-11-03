import java.util.*;

public class Topological_Sort {

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

    static boolean[] visited;
    static Node[] graph;
    static Stack<Integer> s;
    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> rev_map = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int i = 0;
        String[] input = scan.nextLine().split(" ");

        graph = new Node[input.length];
        visited = new boolean[input.length];
        Arrays.fill(visited, false);
        s = new Stack<>();

        for(String s : input){
            graph[i] = new Node();
            map.put(s,i);
            rev_map.put(i++, s);
        }

        input = scan.nextLine().split(" ");
        for(int j = 0; j<input.length; j+=2){
            graph[map.get(input[j])].to.add(map.get(input[j+1]));
        }

        System.out.println(Arrays.toString(graph));

        for(int j = 0; j<graph.length; j++){
            dfs_TS(j);
        }

        System.out.println();
        for(int j = 0; j<graph.length; j++){
            System.out.print(rev_map.get(s.pop()));
        }

    }

    static void dfs_TS(int n){
        System.out.print("->" + n);
        if(visited[n])return;
        visited[n] = true;
        for(int next : graph[n].to){
            if(!visited[next]){
                dfs_TS(next);
            }
        }
        s.push(n);
        System.out.println();
        System.out.println(s);
    }

}
