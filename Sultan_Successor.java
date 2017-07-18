/* A modification of the backtracking algorithm to solve the Classic Queens problem
 * Gets the sum of all the numbers assigned to the positions of the queens in the BOARD matrix.
 */

import java.util.Scanner;
import java.util.Arrays;

class Sultan_Successor {	
	static int count = 0;
	static int board[][];
	
	static void backtrack(int[] a, int k, int n){
//		System.out.println(Arrays.toString(a) + " k = " + k);
		int[] c = new int[n];
		int nc;
		if(is_a_solution(a,k,n)){
			process_solution(a,k,n);
		}else{
			k++;
			nc = construct_candidates(a,k,n,c);
//			System.out.println(nc);
			for(int i = 0; i<nc; i++){
				a[k] = c[i];
				backtrack(a,k,n);
			}
		}
	}
	
	static int construct_candidates(int[] a,int k,int n,int[] c){
		int x = 0;
		boolean[] in_perm = new boolean[n+1];
		Arrays.fill(in_perm, false);
		for(int i = 0; i<k; i++){
			in_perm[ a[i] ] = true;
		}
		for(int i = 1; i<=n; i++){
			if(in_perm[i]==false){
				if(is_good(a,k,i))
				c[x++] = i; 
			}
		}

		return x;
	}
	
	static boolean is_good(int[] a, int k, int y){
		int conf = 0;
		for(int i = 1; i<k; i++){
			if(conflict(i,a[i],k,y))
				conf++;
		}
		return conf==0;
	}
	
	static boolean conflict(int x1, int y1, int x2, int y2){
		boolean result = false;
		result = (x1 == x2)
			||	 (y1 == y2)
			||	 ((x1+y1)==(x2+y2))
			|| 	 ((x1-y1)==(x2-y2));	
		return result;
	}
	
	static boolean is_a_solution(int[] a,int k,int n){
		return k==n;
	}
	
	static void process_solution(int[] a,int k,int n){
		int sum = 0;
		for(int m = 1; m<=n; m++)sum += board[m][a[m]];
		count = Math.max(sum, count);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		board = new int[9][9];
				
		for(int i = 0; i<t; i++){
			for(int j = 1; j<9; j++){
				for(int k = 1; k<9; k++){
					board[j][k] = scan.nextInt();
				}
			}			
		
		
		int[] a = new int[8+1];
		backtrack(a,0,8);
		System.out.printf("%5d", count);
		System.out.println();
		count = 0;
		}
	}	
}
