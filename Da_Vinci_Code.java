/*UVa Online Judge Problem 11385 - Da Vinci Code (Accepted)
 * Used Fibonacci function to generate first 93 Fibonacci numbers in a long[]
 * Runtime Error - int[] used instead of long[]
 * Runtime Error - Do not assume anything at all
*/
import java.util.*;

class Da_Vinci_Code{
	
	static long fibIn[];
	static int fibIndex[];
	static long fib[] = new long[93];
	static String s;
	static char letter[];
	static Scanner scan = new Scanner(System.in);
	static Scanner strscan;

	public static void main(String[] args){
		
		int T = scan.nextInt();
		int length;
		for(int  i = 0; i<T; i++){
				length = scan.nextInt();
				fibIn = new long[length];
				fibIndex = new int[length];    
				for(int j = 0; j<length; j++){
					fibIn[j] = scan.nextLong();					
				}
				fib(92);
				s = scan.nextLine();
				s = scan.nextLine();
//				int temp = 0;
				int max = 0;
				for(int j = 0; j<fibIn.length; j++){
					int x = 0;
					while(fibIn[j]!=fib[x]){
						x++;
					}
					if(Math.max(x-1, max)>max)
					{
						max = x-1;
					}
					fibIndex[j]=x-1;
//					System.out.print((x-1)+" ");
				}
				letter = new char[max];
				Arrays.fill(letter, ' ');
				
//				temp = 0;
				strscan = new Scanner(s);
				strscan.useDelimiter("");
				int j = 0;
				while(strscan.hasNext())
				{
//					if(s.charAt(j)==',' || s.charAt(j)==' '){
//						temp++;
////						System.out.println(">"+s+"<");
//					}
					char a = strscan.next().charAt(0);
					if((a) <= 'Z' && (a) >= 'A'){
						letter[fibIndex[j]-1]=a;
						j++;
//						System.out.println(">"+a+"<");
					}
					if(j==length)break;
				}
				System.out.println(String.valueOf(letter));
		}
//		System.out.println(Arrays.toString(fib));
		
	}
	
	//Returns the nth Fibonacci Sequence term
		static public long fib(long n)
		{
//			fibon = new long[(int)n+1];
			long fibo;
			if(n==0)
				return 0;
			if(n==1)
				return 1;
			if(fib[(int)n]!=0)
				return fib[(int)n];
			else 
				fibo = fib(n-1) + fib(n-2);
			fib[(int)n] = fibo;
			return fibo;
		}
}

