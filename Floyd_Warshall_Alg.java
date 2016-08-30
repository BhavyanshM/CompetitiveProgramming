

/* Floyd-Warshall Algorithm to find the shortest paths in weighted-directed graphs
 * n-cubed algorithm
 * Also use for Single Source Shortest Path problems when n<100
 *
 * */
import java.util.*;

class Floyd_Warshall_Alg{
	static int[][] AdjMat;
	static int[][] paths;

	public static void initFW(int n){
		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				AdjMat[i][j]=Integer.MAX_VALUE;
				if(i==j)
					AdjMat[i][j]=0;
				paths[i][j] = -1;
			}
		}
	}
	public static void allPairsFW(int n){
		for(int k = 0; k<n; k++){
			for(int i = 0; i<n; i++){
				for(int j = 0; j<n; j++)
//				{
					if(AdjMat[i][k]!=Integer.MAX_VALUE && AdjMat[k][j]!=Integer.MAX_VALUE){

						if(AdjMat[i][j]> AdjMat[i][k] + AdjMat[k][j]){
//							System.out.println(i + " " + j + " " + k);
//							printArr2D(paths);
						paths[i][j] = paths[k][j];
						}
						AdjMat[i][j] = Math.min(AdjMat[i][j], AdjMat[i][k] + AdjMat[k][j]);
//						printArr2D(AdjMat);
//						System.out.println();
					}
//				}
			}
		}
	}
	public static void printArr2D(int[][] arr){
		for(int i =0; i<arr.length; i++){
			for(int j = 0; j<arr.length; j++){
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int K = scan.nextInt();
		int V = 0;
		int E = 0;
		for(int i = 0; i<K; i++){
			V = scan.nextInt();
			E = scan.nextInt();
			AdjMat = new int[V][V];
			paths = new int[V][V];
			initFW(V);

			for(int j = 0; j<E; j++){
				int r = scan.nextInt();
				int c = scan.nextInt();
				AdjMat[r][c] = scan.nextInt();
				paths[r][c] = r;
			}
//			printArr2D(paths);
//			System.out.println();

			allPairsFW(V);
			printArr2D(AdjMat);
			System.out.println();
			printArr2D(paths);
			System.out.println();

		}
		scan.close();
	}

}
