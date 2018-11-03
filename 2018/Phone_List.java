import java.util.HashMap;
import java.util.Scanner;
public class Phone_List {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int t = 0; t<T; t++){
            HashMap<String, Boolean> map = new HashMap<>();
            int n = scan.nextInt();
            String[] list = new String[n];
            scan.nextLine();
            for(int i = 0; i<n; i++){
                String s = scan.nextLine();
                map.put(s, true);
                list[i] = s;
            }
            boolean good = true;
            for(int i = 0; i<n; i++){
                String s = list[i];
                for(int j = 1; j<s.length(); j++){
                    if(map.containsKey(s.substring(0, j))){
                        good = false;
                        break;
                    }
                }
                if(!good)break;
            }
            System.out.println(good ? "YES" : "NO");
        }
    }
}
