import java.util.Scanner;

public class TnPo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int m = scan.nextInt();
			int n = scan.nextInt();
			int max = 0;
			for(int i = Math.min(m, n);i<Math.max(m, n)+1; i++){
				max = Math.max(max, count(i));
			}
			System.out.println(m + " " + n + " " + max);
		}
		scan.close();

	}
	public static int count(int n){
		int count = 1;
		while (tNpO(n)!=0){
			n = tNpO(n);
			count++;
		}
		return count;
	}
	
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
