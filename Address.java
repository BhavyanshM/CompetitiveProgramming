/*Used Map/HashMap for the first time. Similarly Set/HashSet can also be used for unique
 * elements in a list
*/
import java.util.*;

public class Address {
   static String direction = "";

   static void setDirection(String s,String turn){
       int dir = -1;
       Map <Integer,String> gets = new HashMap<Integer ,String>();
       gets.put(1,"east");
       gets.put(2,"north");
       gets.put(3,"west");
       gets.put(4,"south");

       Map <String,Integer> geti = new HashMap<String,Integer>();
       geti.put("east",1);
       geti.put("north",2);
       geti.put("west",3);
       geti.put("south",4);
       dir = geti.get(s);

       if(turn.equalsIgnoreCase("right")){
           dir += 3;
           if(dir>4)
               dir%=4;
       }
        if(turn.equalsIgnoreCase("left")){
           dir += 1;
           if(dir>4)
               dir%=4;
       }
       direction = gets.get(dir);

       System.out.println(dir);
       System.out.println(direction);
   }

   public static void main(String[] args){
       Scanner scan = new Scanner(System.in);
       int n;
       String s ;
       List<String[]> list = new ArrayList<String[]>();

       n = Integer.parseInt(scan.nextLine().trim());
       scan.useDelimiter("\n");
       for(int i =0;i<n;i++){

           s = scan.next();
           list.add(s.split(" "));
       }
       for(int i =0;i<n;i++){
            System.out.println(Arrays.toString(list.get(i)));
       }
//        setDirection("south","right");
       String[] temp = list.get(0);
       direction = temp[1];

       for(int i = 1;i<list.size();i++){
           temp = list.get(i);
           if(temp[1].equalsIgnoreCase("right")){
               System.out.println(direction);
               setDirection(direction,"right");
           }
           if(temp[1].equalsIgnoreCase("left")){
               System.out.println(direction);
               setDirection(direction,"left");
           }
       }
       String best = "";
       System.out.println(direction);
       for(int j = list.size()-1;j>-1;j--){
            String[] t = list.get(j);

           if(j==list.size()-1){
               best += "Head ";
               best += direction;
               best += " from ";
               for(int i = 2;i<list.get(j).length;i++){
                   best += t[i];
               }
               System.out.println(best);
           }
           if(j==0){
               best += "Arrive ";
               best += " at ";
               for(int i = 2;i<list.get(j).length;i++){
                   best += t[i];
               }
               System.out.println(best);
           }
           if(t.equals("on")){
               best += "Continue ";
               best += " on ";
               for(int i = 2;i<list.get(j).length;i++){
                   best += t[i];
               }
               System.out.println(best);
           }
       }
       scan.close();

   }



}
