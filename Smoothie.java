import java.util.Arrays;
import java.util.Scanner;

public class Smoothie {

	static int[] nums;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int s = scan.nextInt();
		nums = new int[n];
		
		for(int i = 0; i<n; i++) {
			nums[i] = scan.nextInt();
		}
		
		System.out.println(Arrays.toString(nums));
	}
	
	static int edit() {
		return 0;
	}

}
