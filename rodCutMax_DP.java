/*Dynamic Programming Solution to the Rod Cutting Problem
 * Uses two for loops to fill up a 1D Array in O(n2)
 * UVa - Not Tested
 * */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int costs[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner scan = new Scanner(System.in);
		int L = scan.nextInt();
		costs = new int[L];
		for(int i = 0; i<L; i++){
			costs[i] = scan.nextInt();
		}
		System.out.println(Arrays.toString(cutMax(costs)));
		scan.close();
	}
	
	static int[] cutMax(int[] costs){
		int n = costs.length;
		int[] max = new int[n+1];
		Arrays.fill(max, 0);
		max[0] = 0; //Sentinal for the max cost for rod length of zero
		for(int i = 1; i<=n; i++){
			if(i==1){
				max[i] = costs[i-1];
				continue;
			}
			for(int j = 0; j<=i/2; j++){
				if(j==0){
					max[i] = Math.max(max[i], costs[i-1]);
				}else{
					max[i] = Math.max(max[i], max[j] + max[i-j]);
					System.out.println(Arrays.toString(max));
				}
			}
		}
		return max;
	}


}
