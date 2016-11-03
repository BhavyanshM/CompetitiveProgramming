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

class Gene implements Comparable<Gene>{
	public String seq;
	public int prec;	
	public Gene(String s, int a){
		seq = s;
		prec = 0;
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
	public int compareTo(Gene gene) {
		// TODO Auto-generated method stub
		return this.prec - (gene).prec;
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