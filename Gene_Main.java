/*UVa Problem 612 Inversions
 * Data Structures
 * TLE - LinkedLists
 * TLE - ArrayLists
 * Presentation Error (Blank Line at the end) - Arrays
 * Accepted - Arrays
 * 
 * (Used Eclipse Debugger for the first time)
*/

import java.util.*;

class Gene implements Comparable{
//	public int len;
	public String seq;
	public int prec;
	
	public Gene(String s, int a){
		seq = s;
		prec = 0;
//		len = a;
	}
	public void print(){
		System.out.println(this.seq);
	}
	
	public void invCalc(){
		for(int i = 0; i<this.seq.length()-1;i++){
			for(int j = i+1;j<this.seq.length();j++){
				if(this.seq.charAt(i)>this.seq.charAt(j)){
					this.prec++;
				}
			}
		}
		
	}

	@Override
	public int compareTo(Object gene) {
		// TODO Auto-generated method stub
		return this.prec - ((Gene)gene).prec;
	}
		
	
}

class Gene_Main{
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int a,n,num;
		a = scan.nextInt();
		Gene[] list;
		
		for(int i = 0; i<a; i++){
			n = scan.nextInt();
			num = scan.nextInt();
//			System.out.println(a+" "+n+" "+num);
			list = new Gene[num];
			for(int j = 0;j<num;j++){
				String s = scan.next();
				list[j] = (new Gene(s,n));				
			}
			for(Gene g : list){
				g.invCalc();			
			}
			Arrays.sort(list);
			for(Gene g : list){
				g.print();			
			}
			if(i!=a-1)
			System.out.println();
		}
		
		
		
		scan.close();
		
	}
	
	
	
}






//import java.util.*;
//
//
//public class Main {
//    static String direction = "";
//
//    static void setDirection(String s,String turn){
//        int dir = -1;
//        Map <Integer,String> gets = new HashMap<Integer ,String>();
//        gets.put(1,"east");
//        gets.put(2,"north");
//        gets.put(3,"west");
//        gets.put(4,"south");
//
//        Map <String,Integer> geti = new HashMap<String,Integer>();
//        geti.put("east",1);
//        geti.put("north",2);
//        geti.put("west",3);
//        geti.put("south",4);
//
////        System.out.println(s);
////        System.out.println(turn);
//
//
//        dir = geti.get(s);
//
//        if(turn.equalsIgnoreCase("right")){
//            dir += 3;
//            if(dir>4)
//                dir%=4;
//        }
//         if(turn.equalsIgnoreCase("left")){
//            dir += 1;
//            if(dir>4)
//                dir%=4;
//        }
//        direction = gets.get(dir);
//
//        System.out.println(dir);
//        System.out.println(direction);
//
//    }
//
//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        int n;
//        String s ;
//        String[][] arr = {};
//        List<String[]> list = new ArrayList<String[]>();
//
//
//        n = Integer.parseInt(scan.nextLine().trim());
//        scan.useDelimiter("\n");
//        for(int i =0;i<n;i++){
//
//            s = scan.next();
//            list.add(s.split(" "));
//        }
//
//        for(int i =0;i<n;i++){
//             System.out.println(Arrays.toString(list.get(i)));
//
//        }
//
////        setDirection("south","right");
//        String[] temp = list.get(0);
//        direction = temp[1];
//
//        for(int i = 1;i<list.size();i++){
//            temp = list.get(i);
//            if(temp[1].equalsIgnoreCase("right")){
//                System.out.println(direction);
//                setDirection(direction,"right");
//            }
//            if(temp[1].equalsIgnoreCase("left")){
//                System.out.println(direction);
//                setDirection(direction,"left");
//            }
//
//        }
//        String best = "";
//        System.out.println(direction);
//        for(int j = list.size()-1;j>-1;j--){
//             String[] t = list.get(j);
//
//            if(j==list.size()-1){
//                best += "Head ";
//                best += direction;
//                best += " from ";
//                for(int i = 2;i<list.get(j).length;i++){
//                    best += t[i];
//                }
//                System.out.println(best);
//            }
//            if(j==0){
//                best += "Arrive ";
//                best += " at ";
//                for(int i = 2;i<list.get(j).length;i++){
//                    best += t[i];
//                }
//                System.out.println(best);
//            }
//            if(t.equals("on")){
//                best += "Continue ";
//                best += " on ";
//                for(int i = 2;i<list.get(j).length;i++){
//                    best += t[i];
//                }
//                System.out.println(best);
//            }
//
//        }
//
//    }
//
//
//
//}
