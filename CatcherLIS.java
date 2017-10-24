


/*Longest Integer Sequence Problem CATCHER
 Accepted Solution for UVa 231: Testing the CATCHER, below
 */


import java.util.*;

class CatcherLIS{
	static Integer[] A;
	static int n;
	static int temp,temp1;
	static ArrayList<Integer> input;
	static Scanner scan;
	static int[] LIS;
	public static void main(String[] args){

		input = new ArrayList<Integer>();
		scan = new Scanner(System.in);
		temp = -2;
		temp1 = -2;
		int t =0;
		while(true){
			temp = scan.nextInt();
			if(temp==-1){
				A = new Integer[input.size()];
//				System.out.println(Arrays.toString((input.toArray(A))));
				A = input.toArray(A);
				LIS = new int[A.length];
				lis();
				if(t!=0)
				System.out.println();
				t++;
				System.out.println("Test #"+t+":");
				System.out.println("  maximum possible interceptions: "+maxLIST(LIS));
				temp1=scan.nextInt();
				if(temp1==-1){
					break;
				}
				else{

					input = new ArrayList<Integer>();
					input.add(temp1);


				}
			}
			else{
				input.add(temp);
			}
		}

	}

	static void lis(){

	Arrays.fill(LIS, 1);
//	Arrays.fill(from, -1);
	for(int a =0; a<A.length; a++){
		for(int b = 0; b<a ; b++){
			if(A[a]<A[b] && LIS[a]<LIS[b]+1)
			{
				LIS[a]=LIS[b]+1;
//				this.from[a]=b;
			}
//			System.out.println(Arrays.toString(LIS));
//			System.out.println(Arrays.toString(from));
			}
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
