import java.util.HashMap;
import java.util.Scanner;

public class Hay_Point {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int w = scan.nextInt();
        int s = scan.nextInt();
        scan.nextLine();

        HashMap<String, Integer> map = new HashMap<>();


        for(int i = 0; i<w; i++){
            map.put(scan.next(), scan.nextInt());
        }

        String input = "";
        for(int i = 0; i<s; i++){
            int cost = 0;
            while(true){
                input = scan.nextLine();
                if(input.equals(".")){
                    break;
                }else{
                    for(String word : input.split("\\s")){
                        if(map.containsKey(word)){
                            cost += map.get(word);
                        }
                    }
                }
            }
            System.out.println(cost);
        }
    }

}
