/*Accepted - UVa 674 Coin Change Problem with {1, 5, 10, 25, 50}
 * Extremely Important - Do not Reset the Table for Every Input Test Case (Time Limit Exceeded)
 * Top-Down Approach with Memoization for the Number of Ways - Coin Change - Problem
 * */

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {

	static int[] cc[];
	static int[] S = {1, 5, 10, 25, 50};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int m = 5;
		cc = new int[m][7500];
		for(int i = 0; i<m; i++){
			Arrays.fill(cc[i], -1);
		}	
		
		
//		int m = scan.nextInt(); //Total number of denominations
//		S = new int[m];			
		
//		for(int i = 0; i<m; i++){
//			S[i] = scan.nextInt();
//		}
		
		try{
			while(scan.hasNext()){
				int N = scan.nextInt(); //Total money to change				
				System.out.println(change(m-1, N));				
			}
		}catch(Exception e){}
		
//		for(int i = 0; i<cc.length; i++){
//			System.out.println(Arrays.toString(cc[i]));
//		}
	}
	
	static int change(int i, int money){
//		System.out.println("(" + i + "," + money + ")");
		if(money==0){
			return 1;
		}if(money<0){
			return 0;
		}if(i<=-1 && money>=1){
			return 0;
		}
		if(cc[i][money]!=-1){
			return cc[i][money];
		}else{
			cc[i][money] = change(i-1, money) + change(i, money-S[i]);
			return cc[i][money];
		}		
	}
}
