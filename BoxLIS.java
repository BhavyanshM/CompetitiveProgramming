
import java.util.*;

public class BoxLIS {

	public static void main(String[] args)
	{
		while(true)
		{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int d = scan.nextInt();
		box[] B = new box[n];
		for(int i = 0; i<n; i++)
			{
				B[i] = new box(i,d);
				for(int j = 0; j<d; j++)
					{
						B[i].edge[j] = scan.nextInt();
					}
			}
		LIS l = new LIS(B);
		scan.close();
		}


//		if(B[0].isin(B[1]))
//			System.out.println("yes");
//		}
	}

}
class box{
	public int r;
	public int d;
	public int[] edge;

	public box(int rank, int dim){
		this.d = dim;
		this.r = rank;
		edge = new int[d];
	}
	public boolean isin(box b){
		int t =0;
		boolean isin = false;
		Arrays.sort(b.edge);
		Arrays.sort(this.edge);
		for(int i =0; i<this.edge.length; i++)
		{
			if(this.edge[i]>=b.edge[i])
			{
				t++;
			}
		}
		if(t==0)
			isin = true;
		return isin;
	}
}

class LIS{
	box[] A;
	int[] from;
	int[] LIS;
	int maxLIS;
	int maxIndex;
	ArrayList<box> sorted = new ArrayList<box>();
	int[] order = new int[maxLIS];

	public LIS(box[] arr){
		Arrays.fill(LIS, 1);
		Arrays.fill(from, -1);
		this.A= arr;
	}

	public void lis(){

		Arrays.fill(LIS, 1);
		Arrays.fill(from, -1);
		for(int a =0; a<A.length; a++){
			for(int b = 0; b<a ; b++){
				if(A[b].isin(A[a]) && LIS[a]<LIS[b]+1)
				{
					this.LIS[a]=LIS[b]+1;
					this.from[a]=b;
				}
				System.out.println(Arrays.toString(LIS));
			}
		}
	}

	public ArrayList<box> LISorted()
	{

		int fromInd = maxIndex;
		sorted.add(A[maxIndex]);
		for(int h = 0; h<maxLIS; h++)
		{

			if(from[fromInd]!=-1)
			sorted.add(A[from[fromInd]]);
			fromInd = from[fromInd];
		}
		Collections.reverse(sorted);
		return sorted;
	}

	public void maxArr()
	{

	maxLIS = LIS[0];
	for(int m = 1; m<LIS.length; m++)
		{
			if(LIS[m]>=LIS[maxIndex]){
				maxLIS = LIS[m];
				maxIndex = m;

			}
		}

	}
}
