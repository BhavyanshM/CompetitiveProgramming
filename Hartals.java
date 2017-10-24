/*UVa 10050 Hartals - Accepted Solution
 * Accepted First Attempt
 * Remember to refresh variables appropriately
*/
import java.util.Arrays;
import java.util.Scanner;

class Hartals{
	static Scanner scan = new Scanner(System.in);
//	static int party[];
	static int loss[];
	static boolean hartal[];
	public static void main(String[] args){
		int T;
		T = scan.nextInt();
		loss = new int[T];
		for(int i = 0; i<T; i++){
			int n = scan.nextInt();
			int p = scan.nextInt();
			hartal = new boolean[n];
//			party = new int[p];
			int h;
			Arrays.fill(hartal, false);
//			System.out.println(Arrays.toString(hartal));
			for(int j = 0; j<p; j++){
				h = scan.nextInt();
				for(int k = 1; h*k<=n; k++){
					if(hartal[(h*k-1)]!=true && !((h*k-1)%7 == 5 || (h*k-1)%7 == 6)){
						hartal[(h*k-1)] = true;
						loss[i]++;
//						System.out.println(h*k);
					}
				}
			}
			
			
		}
		for(int x = 0; x<loss.length; x++)
		System.out.println((loss[x]));
	}
	
}


