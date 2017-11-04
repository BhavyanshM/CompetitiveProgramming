import java.util.Arrays;
import java.util.Scanner;

public class ZebrasOcelots {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int size = 0; 
		size = scan.nextInt();
		
		int zCount = 0;
		
		scan.nextLine();
		
		String num = "";
		char input;
		for(int i = 0; i < size; i++) {
			input = scan.nextLine().toLowerCase().charAt(0);
			if(input=='z')
			num += 1;
			if(input=='o' || input=='0')
			num += 0;
		}
		
		long n = Long.parseLong(num, 2);
		
		long nums = (long)Math.pow(2, num.length());
		nums--;
		nums-=n;
		System.out.println(nums);
		
	}

}
