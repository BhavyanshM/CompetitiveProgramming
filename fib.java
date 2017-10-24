import java.util.Scanner;

public class fib{

		public static void main(String[] args)
		{
			Scanner scan = new Scanner(System.in);
			long t = scan.nextLong();
			long sum = 0;
			long temp = 0;
			long n = 0;

			for(int i = 0; i<t; i++)
			{
				n = scan.nextLong();
				for (long j =0; nfib(3*j+2)<=n ; j++)
				{
					temp = (nfib(3*j+2));
//					System.out.println(temp);
					sum = sum + (temp);

				}
				System.out.println(sum);
				sum = 0;
			}

			scan.close();
		}

		public static long nfib(long s)
		{
			double phi = (1.0+Math.sqrt(5))/2;
			double _phi = (1.0-Math.sqrt(5))/2;
			double n = (double)s+1;
//			System.out.println(n);
			return (long)((Math.pow(phi, n)-Math.pow(_phi, n))/Math.sqrt(5));

		}
	}
