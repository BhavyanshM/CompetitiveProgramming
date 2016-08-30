import java.util.Scanner;

public class TnPo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		//While there are input values coming in, keep executing the loop code
		while(scan.hasNext()){
			int m = scan.nextInt();
			int n = scan.nextInt();
			int max = 0;
			
			//Calculate the lengths of all the numbers between and including m and n and also find the max of the calculated values.
			for(int i = Math.min(m, n);i<Math.max(m, n)+1; i++){
				max = Math.max(max, count(i));
			}
			System.out.println(m + " " + n + " " + max);
		}
		scan.close();

	}
	
	//Counts the cycle length for any number
	public static int count(int n){
		int count = 1;
		while (tNpO(n)!=0){
			n = tNpO(n);
			count++;
		}
		return count;
	}
	
	//Returns the tNpO of any number i.c. returns 3n+1 if n is odd, and n/2 if n is even.
	public static int tNpO(int n){
		if(n==1){
			return 0;
		}
		if(n%2==1){
			return 3*n + 1;
		}
		if(n%2==0){
			return n/2;
		}
		return 0;
	}

}
