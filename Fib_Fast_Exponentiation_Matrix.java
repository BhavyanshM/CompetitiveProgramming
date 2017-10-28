import java.util.Scanner;

public class Main {

	static long[][] fib = {{1,1},{1,0}};
	static final long MOD = 1000000000;
	
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		long[][] ans;
		for(int i = 0; i<t; i++){
			scan.nextInt();
			long n = scan.nextLong();
			ans = fib(fib,n-1);
			System.out.println((i+1) + " " + ans[0][0]);
		}		
		scan.close();
	}
	
	static void print(long[][] mat){
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j<mat[0].length; j++){
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static long[][] matmul(long[][] a, long[][] b){
		long[][] result = new long[a.length][b[0].length];
		for(int i = 0; i<a.length; i++){
			for(int j = 0; j<b[0].length; j++){
				for(int k = 0; k<a[0].length; k++){
					result[i][j] = (result[i][j]%MOD + (((a[i][k]%MOD) * (b[k][j]%MOD))%MOD ))%MOD;
				}
			}
		}
		return result;
	}
	
	static long[][] fib(long[][] mat, long n){
		if(n<2)return mat;
		long[][] temp = fib(mat,n/2);
//		System.out.println("CALLED:" + n);
		if(n%2==0){			
			return matmul(temp, temp);
		}else if(n%2==1){
			return matmul(mat, matmul(temp,temp));
		}
		return mat;
	}
}
