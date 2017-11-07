import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {
	
	private static final int MAX_N = 1010;
	private static final int MAX_W = 40;
	private static int N, MW;
	private static int[] val = new int[MAX_N], weight = new int[MAX_N];
	private static int[][] sack = new int[MAX_N][MAX_W];
	
	public static void main(String[] args) {

	    Scanner sc = new Scanner(System.in);
	    int i, j, T, G, ans;

	    T = sc.nextInt();
	    while (T-- > 0) {
	      for (i = 0; i < MAX_N; i++)
	        for (j = 0; j < MAX_W; j++)
	          sack[i][j] = -1;

	      N = sc.nextInt();
	      for (i = 0; i < N; i++) {
	        val[i] = sc.nextInt();
	        weight[i] = sc.nextInt();
	      }

	      ans = 0;
	      G = sc.nextInt();
	      while (G-- > 0) {
	        MW = sc.nextInt();
	        ans += knap(N-1, MW);
	      }

	      System.out.printf("%d\n", ans);
	      
//	      for(int x = 0; x<N; x++) {
//	    	  System.out.println(Arrays.toString(sack[i]));
//	      }
	    }
		
	}
	
	static int knap(int i, int remW) {
//		System.out.println("(" + i + "," + remW + ")");
		if(remW<=0) {
			return 0;
		}
		
		if(i==-1) {
			return 0;
		} 
		
		if(sack[i][remW] != -1) {
			return sack[i][remW];
		}else {
			if(remW-weight[i]<0) return sack[i][remW] = knap(i-1, remW);
			sack[i][remW] = Math.max(knap(i-1, remW-weight[i])+val[i], knap(i-1, remW));
//			System.out.println(sack[i][remW]);
			return sack[i][remW];
		}
		
	}
	
	

}
