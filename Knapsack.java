import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {

	static int[] val, weight, sack[];
	static int n, S;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		S = scan.nextInt();
		
		val = new int[n];
		weight = new int[n];
		
		sack = new int[n][S];
		
		for(int i = 0; i<n; i++) {
			Arrays.fill(sack[i], -1);
		}
		
		for(int i = 0; i<n; i++) {
			val[i] = scan.nextInt();
		}
		
		for(int i = 0; i<n; i++) {
			weight[i] = scan.nextInt();
		}
		
		System.out.println(knap(n-1, S-1));
		
		for(int i = 0; i<n; i++) {
			System.out.println(Arrays.toString(sack[i]));
		}
		
	}
	
	static int knap(int i, int remW) {
		if(remW<=0) {
			return 0;
		}
		
		if(i==0) {
			return 0;
		} 
		
		if(sack[i][remW] != -1) {
			return sack[i][remW];
		}else {
			sack[i][remW] = Math.max(knap(i-1, remW-weight[i])+val[i], knap(i-1, remW));
			return sack[i][remW];
		}
		
	}
	
	

}
