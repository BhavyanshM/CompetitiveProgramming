
import java.util.Arrays;
import java.util.Scanner;

class LongestIncreasingSequence{
	static Scanner scan ;
	static int[] O ;
	static int n;
	static int[] LIS;
	static int[] A;

	static boolean isGood(int b, int a){
		int ai = -1;
		int bj = -1;
		for(int i = 0; i<n; i++)
		{
			if(O[i]==a)
				ai = i;
		}
		for(int j = 0; j<n; j++)
		{
			if(O[j]==b)
				bj = j;
		}
		if(ai>bj && ai!=-1 && bj!=-1)
		{
			return true;
		}
		else return false;
	}
	static void lis(){

		Arrays.fill(LIS, 1);
//		Arrays.fill(from, -1);
		for(int a =0; a<A.length; a++){
			for(int b = 0; b<a ; b++){
				if(isGood(A[b],A[a]) && LIS[a]<LIS[b]+1)
				{
					LIS[a]=LIS[b]+1;
//					this.from[a]=b;
				}
				System.out.println(Arrays.toString(LIS));
//				System.out.println(Arrays.toString(from));
			}
		}
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		n = scan.nextInt();
		O = new int[n];
		A = new int[n];
		LIS = new int[n];

		for(int i = 0; i<n; i++)
		{
			O[i] = scan.nextInt();
		}


		while(scan.hasNext()){
			Arrays.fill(A, -1);
			for(int i = 0; i<n; i++)
			{
				A[i] = scan.nextInt();
			}
			lis();
			System.out.println(maxLIST(LIS));
		}
	}

	static int maxLIST(int[] LIST)
	{

	int maxLIS;
	int maxIndex = 0;
	maxLIS = LIST[0];
	for(int m = 1; m<LIS.length; m++)
		{
			if(LIS[m]>=LIST[maxIndex])
			{
				maxLIS = LIST[m];
				maxIndex = m;
			}
		}
	return maxLIS;
	}
}
