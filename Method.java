import java.math.BigInteger;

public class Method {
	
	public long[] fib = new long[25];
	public long[] temp = new long[25];
	
	//Returns the factorial of the number given (n)
	public int fac(int n)
	{
		if(n==0)return 1;
		if(n==1)return 1;
		else return n*fac(n-1);
	}
	
	//Returns the bumber n-choose-k for given n and k
	public long choose(int n, int k)
	{
		long temp = 1;
		if(n<k)temp=0;
		else {
			for(int i = 0; i<k ; i++){
				temp*=(n-i);
			}
			for(int i = 0; i<k ; i++){
				temp/=(i+1);
			}
		}
		return temp;
	}
	
	//Returns the sum of first n squares
	public long sq(int n)
	{
		return n*(n+1)*(2*n+1)/6;
	}
	
	//Returns the sum of first n cubes
	public long cu(int n)
	{
		return n*(n+1)*(n+1)*n/4;
	}
		
	//Returns the nth Fibonacci Sequence term
	public long fib(long n)
	{
		long[] fib = new long[(int)n+1];
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
	
	//The Seive of Eratosthenes 
	public int seive(int n)
	{
		int tot = 0;

		
		//mark all the numbers as prime
		for (int x = 0; x<n+1; x++)
		{
			temp[x] = x;
		
		}
		
		//remove all the non-primes from the list isPrime
		for (int i = 2; i<n+1; i++)
		{
			if(temp[i]!=0)
			{
				for(int j = 1; j*i<n+1; j++)
				{
					System.out.println(temp[j*i]);
					temp[j*i]=0;
					
					
				}
			}
			
		}
		
		for (int i= 2 ; i<n+1; i++)
		{
			if(temp[i]!=0)
			{
				tot+=1;
//				System.out.print(temp[i]);
//				System.out.println();
			}
		}
		return tot;
	}
	
	
	
}

//static void lis(){
//
//Arrays.fill(LIS, 1);
////Arrays.fill(from, -1);
//for(int a =0; a<A.length; a++){
//	for(int b = 0; b<a ; b++){
//		if(A[a]<A[b] && LIS[a]<LIS[b]+1)
//		{
//			LIS[a]=LIS[b]+1;
////			this.from[a]=b;
//		}
////		System.out.println(Arrays.toString(LIS));
////		System.out.println(Arrays.toString(from));
//		}
//	}
//}
//
//static int maxLIST(int[] LIST)
//{
//
//int maxLIS;
//int maxIndex = 0;
//maxLIS = LIST[0];
//for(int m = 1; m<LIS.length; m++)
//	{
//		if(LIS[m]>=LIST[maxIndex])
//		{
//			maxLIS = LIST[m];
//			maxIndex = m;
//		}
//	}
//return maxLIS;
//}